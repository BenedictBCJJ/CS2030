class BigCruise extends Cruise {
    final float length;
    final float customers;

    private static final int lengthDivision = 40;
    private static final int customerDivision = 50;

    public BigCruise(String identifier, int arrival, int length, int customers) {
        super(identifier, arrival, 
                (int) Math.ceil((float) length / lengthDivision), 
                    (int) Math.ceil((float) customers / customerDivision));
        this.length = length;
        this.customers = customers;
    }
}
