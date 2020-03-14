class LastDigitsOfHashCode implements Transformer<Object, Integer> {
    private final int digits;

    LastDigitsOfHashCode(int digits) {
        this.digits = digits;
    }

    @Override
    public Integer transform(Object value) {
        return (int) Math.abs((value.hashCode() % Math.pow(10, digits)));
    }
}
