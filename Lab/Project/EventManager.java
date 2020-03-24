/**
 * EventManager class handles Customer class using static methods, changing their activityTime 
 * and status appropriately according to the conditions.
 *<br>
 * In addition, the statistics of all events are stored in this class
 */

public class EventManager {

    private ServerManager serverManager;
    private int totalCustomers = 0;
    private double totalWaitingTime = 0;
    private int leavingCustomers = 0;

    EventManager(int numberOfServer) {
        this.serverManager = new ServerManager(numberOfServer);
    }


    /**
     * Returns appropriate string based on the status of the customer.
     * @param customer The customer whose status you want to return 
     * @return returns the activity time, customer id and customer status as a string
     */

    public String status(Customer customer) {
        switch (customer.status()) {
            case Served :
                return String.format("%.3f %d served by %d", customer.time(), customer.id(), customer.server());

            case Leaves :
                return String.format("%.3f %d leaves", customer.time(), customer.id());

            case Arrive :
                return String.format("%.3f %d arrives", customer.time(), customer.id());

            case Done :
                return String.format(
                        "%.3f %d done serving by %d", customer.time(), customer.id(), customer.server());

            case Waits :
                return String.format(
                        "%.3f %d waits to be served by %d", customer.time(), customer.id(), customer.server());

            default:
                return "error in code";

        }
    }


    /**
     * Returns a customer with updated status based on the situation of customers 
     * waiting and server status.
     *<br>
     * Returns null if customer has left after "Leave" or "Done" status.
     * @param customer chosen customer to update their status
     * @param server chosen server to check status against the customer
     * @return returns a new Customer with updated status or null
     */

    public Customer updateStatus(Customer customer) {

        if (customer.status() == Status.Done || customer.status() == Status.Leaves) {
            return null;

        } else if (customer.status() == Status.Served) {
            
            Server server = serverManager.getServer(customer.server());
            serverManager.updateServer(server.updateState(customer).setQueueToFree());
            totalCustomers++;
            
            return new Customer(customer.id(), customer.time() + 1, Status.Done, server.getId());

        } else if (customer.status() == Status.Waits) {
            
            Server server = serverManager.getServer(customer.server());
            serverManager.updateServer(server.updateState(customer));
            
            return new Customer(customer.id(), server.getTime(), Status.Served, server.getId());

        } else if (serverManager.isThereFreeServer(customer)) {
            
            Server server = serverManager.getFreeServer(customer);
            serverManager.updateServer(server.updateState(customer));
            
            return new Customer(customer.id(), customer.time(), Status.Served, server.getId());

        } else if(serverManager.isThereServerWithNoQueue()) {

            Server server = serverManager.getServerWithNoQueue();
            totalWaitingTime += server.getTime() - customer.time();
            serverManager.updateServer(server.setQueueToNotFree());
            
            return new Customer(customer.id(), customer.time(), Status.Waits, server.getId());

         
        } else {

            leavingCustomers++;
            return new Customer(customer.id(), customer.time(), Status.Leaves);

        }
}


/**
 * Returns the statistics of customer produced in this run.
 * @return returns string of average waiting time, total customers served, 
 *          customers that left without being served
 */

public String finalStatistics() {
    double averageWaitingTime = totalWaitingTime / totalCustomers;
    return (String.format("[%.3f %d %d]", 
                averageWaitingTime, totalCustomers, leavingCustomers));
}

public void print() {
    serverManager.print();
}

}


