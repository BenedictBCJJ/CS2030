class SmallCruise extends Cruise {
    
    private static final int loaders = 1;
    private static final int serviceTime = 30;
    
    public SmallCruise(String identifier, int arrival) {
        super(identifier, arrival, SmallCruise.loaders, SmallCruise.serviceTime);
    }
}
