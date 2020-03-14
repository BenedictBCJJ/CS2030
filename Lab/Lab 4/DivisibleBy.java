class DivisibleBy implements BooleanCondition<Integer> {
    private final Integer divisor;
     
    public DivisibleBy(Integer divisor) {
        this.divisor = divisor;
    }
    
    @Override
    public boolean test(Integer argument) {
        return  argument % this.divisor == 0;
    }
}
