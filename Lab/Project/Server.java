/**
 * The Server class creates a server with time, 
 *      denoting when the server would be free to serve a customer.
 *<br>
 * The Server class can update its time to a newer free time based on the customer it serves.
 */

public class Server {
    private final double time;
    
    /**
     *Constructs a new Server object where the time 
     *       it will be free to serve is represented by the time value.
     *@param time the time that the server would be free to serve customer
     */
    public Server(double time) {
        this.time = time;
    }
    
    /**
     *Checks if the current customer activityTime lines up with the free period of the server, 
     *      updates the server time appropriately.
     *@param customerTime the time of the customer the server is trying to serve
     *@return if the time of the customer is appropriate, 
     *      a new server with a new free time will be create 
     *          otherwise this server would be returned
     */
    
    public Server updateState(double customerTime) {
        if (customerTime >= this.time) {        
            return new Server(customerTime + 1);
        } else {
            return this;
        }
    }

    public double get() {
        return this.time;
    }

}
