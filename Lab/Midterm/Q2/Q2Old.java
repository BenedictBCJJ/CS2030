public interface TypeCaster<S,T> {
    public T cast(S obj);
}
public class ToString<S> implements TypeCaster<S,String> {
    @Override
    public String cast(S obj) {
        return obj.toString();
    }
}
public class Round<Double> implements TypeCaster<Double,Integer> {
    @Override
    public Integer cast(Double obj) {
        return Math.round(obj);
    }
}
public class ToList<T> implements TypeCaster<List<T>,Array<T>> {
    @Override
    public Array<T> cast(List<T> obj) {
        return obj.toArray(T[] a);
    }
}
public class ListCaster<Double> implements TypeCaster<Double,Integer> {
    @Override
    public Integer cast(Double obj) {
        return Math.round(obj);
    }
}
