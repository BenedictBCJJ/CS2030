/**
 * EventManager class handles Customer class using static methods, changing their activityTime 
 * and status appropriately according to the conditions.
 *<br>
 * In addition, the statistics of all events are stored in this class
 */

public class EventManager {
    
    private static boolean anyoneWaiting = false;
    private static int totalCustomers = 0;
    private static double totalWaitingTime = 0;
    private static int leavingCustomers = 0;
    
    /**
     * Returns appropriate string based on the status of the customer.
     * @param customer The customer whose status you want to return 
     * @return returns the activity time, customer id and customer status as a string
     */
    public static String status(Customer customer) {
        switch (customer.status()) {
            case Served :
                anyoneWaiting = false;
                return String.format("%.3f %d served", customer.time(), customer.id());

            case Leaves :
                return String.format("%.3f %d leaves", customer.time(), customer.id());

            case Arrive :
                return String.format("%.3f %d arrives", customer.time(), customer.id());

            case Done :
                return String.format("%.3f %d done", customer.time(), customer.id());

            case Waits :
                anyoneWaiting = true;
                return String.format("%.3f %d waits", customer.time(), customer.id());

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

    public static Customer updateStatus(Customer customer, Server server) {
        if (customer.status() == Status.Done || customer.status() == Status.Leaves) {
            return null;
        
        } else if (customer.status() == Status.Served) {
            totalCustomers++;
            return new Customer(customer.id(), customer.time() + 1, Status.Done);
        
        } else if (customer.time() >= server.get() && !anyoneWaiting) {
            return new Customer(customer.id(), customer.time(), Status.Served);
        
        } else if (customer.status() == Status.Waits) {
            return new Customer(customer.id(), server.get(), Status.Served);
        
        } else if (!anyoneWaiting) {
            totalWaitingTime += server.get() - customer.time();
            return new Customer(customer.id(), customer.time(), Status.Waits);
        
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

    public static String finalStatistics() {
        double averageWaitingTime = totalWaitingTime / totalCustomers;
        return (String.format("[%.3f %d %d]", 
                    averageWaitingTime, totalCustomers, leavingCustomers));
    }

}


