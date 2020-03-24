import java.util.ArrayList;

public class ServerManager{
    private final ArrayList<Server> serverList = new ArrayList<>();

    ServerManager(int numberOfServer) {
        for(int id = 1; id <= numberOfServer; id++) {
            serverList.add(new Server(id, 0, true));
        }
    }
    
    public Server getServer(int id) {
        return this.serverList.get(id - 1);
    }

    public void updateServer(Server server) {
        serverList.set(server.getId() - 1, server);
    }
    
    public boolean isThereFreeServer(Customer customer) {
        for(Server server : serverList) {
            if(customer.time() >= server.getTime()) {
                return true;
            }
        }
        return false;
    }

    public Server getFreeServer(Customer customer) {
        for(Server server : serverList) {
            if(customer.time() >= server.getTime()) {
                return server;
            }
        }
        return null;
    }

    public boolean isThereServerWithNoQueue() {
        for(Server server: serverList) {
            if(server.queueIsFree()) {
                return true;
            }
        }
        return false;
    }

    public Server getServerWithNoQueue() {
        for(Server server: serverList) {
            if(server.queueIsFree()) {
                return server;
            }
        }
        
        return null;
    }
    
    public void print() {
        for(Server server : serverList) {
            System.out.println(server.getId() + " " + server.queueIsFree() + " " + server.getTime());
        }
    }
}
