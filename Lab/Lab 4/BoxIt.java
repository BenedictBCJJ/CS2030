class BoxIt<T> implements Transformer<T, Box<T>> {
    @Override
    public Box<T> transform(T value) {
        return Box.of(value);
    }
}
