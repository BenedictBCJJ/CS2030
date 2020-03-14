import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main {
    
    /**
     * Takes in a string of double values that denote the arriving time of customers
     * which would be assigned to each customer with increasing id from 1.
     * <br>
     * A server would try to serve all the customers based on their arrival time with each
     * service taking 1 time unit in duration.
     *<br>
     * If there is no customer being served, the next customer would be served.
     *<br>
     * If there is a customer being served and no customer waiting the next customer would wait.
     *<br>
     * If there is a customer waiting, the next customer would leave.
     * <br>
     * The sequence of events would be printed out in chronological order, events that happen
     * at the same time would happen based on the order of their id.
     *<br>
     * @param args command-line arguments that denote 
     *          the time of arrival of customers seperated by space key.
     */

    public static void main(String[] args) {
        Customer arrivingCustomer;
        Customer nextCustomer;
        Customer currentCustomer;

        Server server = new Server(0);
        Scanner sc = new Scanner(System.in);
        int id = 1;

        while (sc.hasNextDouble()) {
            double time = sc.nextDouble();
            arrivingCustomer = new Customer(id, time);
            QueueManager.add(arrivingCustomer);
            id++;
        }

        while (QueueManager.hasNextCustomer()) {
            currentCustomer = QueueManager.nextCustomer();
            System.out.println(EventManager.status(currentCustomer));
            nextCustomer = EventManager.updateStatus(currentCustomer, server);

            if (QueueManager.customerHasNotLeft(nextCustomer)) {
                QueueManager.add(nextCustomer);
                server = server.updateState(currentCustomer.time());
            }
        }

        System.out.println(EventManager.finalStatistics());
    }
}
