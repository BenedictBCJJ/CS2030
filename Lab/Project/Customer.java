/**
 * The Customer class creates a customer with id and activity time as constructor parameters, 
 *      the default status is "Arrive".
 *<br>
 * Only EventManager should change the status of the Customer class.
 */

public class Customer {
    private final int id;
    private final double activityTime;
    private final Status status;
    
    /**
     * Constructs a new customer with allocated id and activityTime. 
     *<br>
     * Customer arrives at activityTime with status allocated as Arrive
     * @param id The customer id
     * @param activityTime The arrival time of the customer
     * */
    public Customer(int id, double activityTime) {
        this.id = id;
        this.activityTime = activityTime;
        this.status = Status.Arrive;
    }
    
    /**
     * Constructor for EventManager to change status.
     *<br>
     * Constructs a new customer with allocated id, activityTime and status
     * @param id The customer id
     * @param activityTime The event time of the customer
     * @param status The current status of customer
     * */

    protected Customer(int id, double activityTime, Status status) {
        this.id = id;
        this.activityTime = activityTime;
        this.status = status;
    }

    public double time() {
        return this.activityTime;
    }

    public int id() {
        return this.id;
    }

    public Status status() {
        return this.status;
    }

}
