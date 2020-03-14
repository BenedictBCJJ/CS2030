import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Collections;
import java.util.Comparator;

public class ImmutableList<T> {
    private final List<T> list;

    public ImmutableList(List<T> list) {
        this.list = List.copyOf(list);
    }

    @SafeVarargs
    public ImmutableList(T... values) {
        this.list = List.of(values);
    }

    @Override
    public String toString() {
        return this.list.toString();
    }

    public ImmutableList<T> add(T value) {
        List<T> shallowList = new ArrayList<T>(List.copyOf(this.list));
        shallowList.add(value);
        return new ImmutableList<T>(shallowList);
    }

    public ImmutableList<T> replace(T value, T replacement) {
        List<T> shallowList = new ArrayList<T>(List.copyOf(this.list));
        shallowList.replaceAll(x -> x == value ? replacement : x);       
        return new ImmutableList<T>(shallowList);
    }

    public ImmutableList<T> remove(T value) {
        List<T> shallowList = new ArrayList<T>(List.copyOf(this.list));
        shallowList.remove((Object) value);
        return new ImmutableList<T>(shallowList);
    }

    public ImmutableList<T> filter(Predicate<? super T> pred) {
        List<T> shallowList = new ArrayList<T>();
        for (T elements: this.list) {
            if (pred.test(elements)) {
                shallowList.add(elements);
            }
        }
        return new ImmutableList<T>(shallowList);
    }

    public <R> ImmutableList<R> map(Function<? super T, ? extends R> function) {

        List<R> shallowList = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            R element = function.apply(this.list.get(i));
            shallowList.add(element);
        }
        return new ImmutableList<R>(shallowList);
    }

    public ImmutableList<T> limit(int size) {
        List<T> shallowList = new ArrayList<T>();
        if (size < 0) {
            throw new IllegalArgumentException("limit size < 0");
        }
        for (int i = 0; i < size && i < this.list.size(); i++) {
            shallowList.add(this.list.get(i));
        }
        return new ImmutableList<T>(shallowList);
    }

    public <U extends Comparable<? super U>> ImmutableList<U> sorted() {

        for (T element: this.list) {
            if (!(element instanceof Comparable)) {
                throw new IllegalStateException("List elements do not implement Comparable");
            }

        }        
        @SuppressWarnings("unchecked")
        List<U> shallowList = new ArrayList<U>((List<U>)List.copyOf(this.list));       
        Collections.sort(shallowList);
        return new ImmutableList<U>(shallowList);
    }

    public ImmutableList<T> sorted(Comparator<T> comp) {
        List<T> shallowList = new ArrayList<T>(List.copyOf(this.list));
        if (comp == null) {
            throw new NullPointerException("Comparator is null");
        } else {
            Collections.sort(shallowList,comp);
        } 
        return new ImmutableList<T>(shallowList);
    }

    public Object toArray() {
        return this.list.toArray();
    }

    public <U> U[] toArray(U [] array) {
        try {
            this.list.toArray(array);
        } catch (java.lang.ArrayStoreException ex) {
            throw new ArrayStoreException("Cannot add element to array as it is the wrong type");
        } catch (java.lang.NullPointerException ex) {
            throw new NullPointerException("Input array cannot be null");
        }

        return this.list.toArray(array);
    }


}

