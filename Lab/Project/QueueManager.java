import java.util.PriorityQueue;

/**
 * Abstraction of PriorityQueue methods for Customer Class, includes some methods 
 * from the PriorityQueue class that is required to operate on Customer objects.
 *<br>
 * In addition, checks if customer has left the venue
 */

public class QueueManager {
    private static PriorityQueue<Customer> customerQueue = 
            new PriorityQueue<Customer>(new CustomerComparator());
       
    /**
     * Inserts specified customer into the QueueManager.
     * @param customer the customer to add
     * @return true(as specified by Collection.add(E))
     */
    
    public static boolean add(Customer customer) {
        return customerQueue.add(customer);
    }
    
    /**
     * Check if the customer has left the venue.
     * @param customer the customer to check if they have left
     * @return true if customer has not left, false if customer has already left
     */

    public static boolean customerHasNotLeft(Customer customer) {
        return customer != null;
    }

    /**
     * Retrieves and removes the customer at the front of the queue, 
     *      returns null if this queue is empty.
     * @return the customer at the front of the queue or null if this queue is empty
     */

    public static Customer nextCustomer() {
        return customerQueue.poll();
    }

    /**
     * returns true if there is customer in the queue.
     * @return true if there is customer in the queue
     */

    public static boolean hasNextCustomer() {
        return customerQueue.iterator().hasNext();
    }
}
