class LongerThan implements BooleanCondition<String> {
    private final int length;

    LongerThan(int length) {
        this.length = length;
    }
    
    @Override
    public boolean test(String argument) {
        return argument.length() - this.length > 0;
    }
}
