import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public interface TypeCaster<S,T> {
    public T cast(S obj);
}
public class ToString<S> implements TypeCaster<S,String> {
    @Override
    public String cast(S obj) {
        return obj.toString();
    }
}
public class Round implements TypeCaster<Double,Integer> {
    @Override
    public Integer cast(Double obj) {
        return (int) Math.round(obj);
    }
}
public class ToList<T> implements TypeCaster<T[], List<T>> {
    @Override
    public List<T> cast(T[] obj) {
        return Arrays.asList(obj);
    }
}

public class ListCaster{
    static <S,T> List<T> castList(List<S> obj, TypeCaster<? super S,? extends T> caster) {
        List<T> list = new ArrayList<>();
        for(S items: obj) {
            list.add(caster.cast(items));
        }
        return list;
    }
}

