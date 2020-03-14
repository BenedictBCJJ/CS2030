import java.util.Comparator;

/**
 * A comparison function that implements the Comparator interface to determine 
 *      the order of Customer in a priority queue.
 */
class CustomerComparator implements Comparator<Customer> {
    
    /**
     * Implements the compare function from Comparator to work on Customer objects.
     * <br>
     * Returns a negative integer or a positive integer as the first Customer activity time 
     *      is less than, or greater than the second.
     * <br>
     * Returns a positive integer as both Customer activity time is same but 
     *      the first customer id is less than the second, or returns zero if customer id is equal.
     * @param c1 the first customer to compare
     * @param c2 the second customer to compare
     * @return a negative integer, 0 or a positive integer based activity time and id of
     *          first and second customer
     */
    
    @Override
    public int compare(Customer c1, Customer c2) {
        if (c1.time() < c2.time()) {
            return -1;
        } else if (c1.time() > c2.time() || c1.id() > c2.id()) {
            return 1;
        } else {
            return 0;
        }
    }
}

