public class Box<T> {
    private final T value;

    private static final Box<?> EMPTY_BOX = new Box<>(null);

    private Box(T value) {
        this.value = value;
    }

    static <U> Box<U> of(U value) {
        if (value == null) {
            return null;
        } else {
            return new Box<U>(value);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj instanceof Box) {
            Box<T> compare = (Box<T>) obj;

            if (compare.value == null && this.value == null) {
                return true;
            } else if (compare.value == null || this.value == null) {
                return false;
            } else {
                return compare.value == this.value || this.value.equals(compare.value);
            }

        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (this.value == null) {
            return "[]";
        } else {
            return String.format("[%s]", this.value);
        }
    }

    @SuppressWarnings("unchecked")
    public static <U> Box<U> empty() {
        return (Box<U>) EMPTY_BOX;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    static <U> Box<U> ofNullable(U value) {
        if (value == null) {
            return Box.empty();
        } else {
            return new Box<U>(value);
        }
    }


    public Box<T> filter(BooleanCondition<? super T> argument) {
        if (this.value != null && argument.test(this.value)) {
            return this;
        } else {
            return Box.empty();
        }
    }

    public <U> Box<U> map(Transformer<? super T, U> u) {
        if (this.value != null) {
            return new Box<U>(u.transform(this.value));
        } else {
            return Box.empty();
        }
    }


}
