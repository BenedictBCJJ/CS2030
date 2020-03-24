import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

abstract class InfiniteListImpl<T> implements InfiniteList<T> {

    static <U> InfiniteListImpl<U> generate(Supplier<? extends U> supplier) {
        return new InfiniteListImpl<U> () {
            public Optional<U> get() {
                return Optional.of(supplier.get());
            }
        };
    }


    static <V> InfiniteListImpl<V> iterate(V seed, UnaryOperator<V> f) {
        return new InfiniteListImpl<V>() {
            private V element = seed;
            private boolean firstElement = true;

            public Optional<V> get() {
                if(firstElement) {
                    firstElement = false;
                    return Optional.of(element);
                } else {
                    element = f.apply(element);
                }
                return Optional.of(element);
            }
        };
    }

    public InfiniteList<T> limit(long maxSize) {
        if(maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }else{ 
            return new InfiniteListImpl<T> (){
                private int count = 0;
                public Optional<T> get() {
                    if(count < maxSize) {
                        count++;
                        return InfiniteListImpl.this.get();
                    } else {
                        return Optional.empty();
                    }
                }
            };
        }
    }

    public void forEach(Consumer<? super T> action) {
        Optional<T> curr = get();
        while (curr.isPresent()) {
            curr.ifPresent(action);
            curr = get();
        }
    }

    public Object[] toArray() {
        ArrayList<Object> list = new ArrayList<>();
        Optional<T> curr = get();
        while (curr.isPresent()) {
            curr.ifPresent(x -> list.add(x));
            curr = get();
        }

        return list.toArray();
    }

    public <S> InfiniteList<S> map(Function<? super T, ? extends S> mapper) {
        return new InfiniteListImpl<S> () {
            public Optional<S> get() {
                return InfiniteListImpl.this.get().map(mapper);
            }
        };
    }

    public InfiniteList<T> filter(Predicate<? super T> predicate) {
        return new InfiniteListImpl<T> () {
            public Optional<T> get() {
                Optional<T> curr = InfiniteListImpl.this.get();
                if(curr.filter(predicate).isPresent() || curr.isEmpty()){
                    
                    return curr;
                } else {
                    
                    return this.get();
                }
            }
        };
    }

    public InfiniteList<T> takeWhile(Predicate<? super T> predicate) {
        return new InfiniteListImpl<T>() {
            public Optional<T> get() {
                Optional<T> curr = InfiniteListImpl.this.get();
                if(curr.filter(predicate).isPresent()){
                    return curr;
                } else {
                    return Optional.empty();
                }
            }
        };
    }

    public long count() {
        int counter = 0;
        while(get().isPresent()){
            counter++;
        }
        return counter;
    }
    
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        Optional<T> curr = get();
        Optional<T> next = get();
        while(next.isPresent()) {
            curr = Optional.of(accumulator.apply(curr.get(),next.get()));
            next = get();
        }
        return curr;
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T curr = identity;
        Optional<T> next = get();
        while(next.isPresent()) {
            curr = accumulator.apply(curr, next.get());
            next = get();
        }
        return curr;
    }


}
