import java.util.List;
import java.util.ArrayList;
public class D{
    static <T> List<T> add(List<T> list, T item) {
        list.add(item);
        return list;
    }
    static <T> List<T> join(List<T> p, List<? extends T> q) {
        List<T> r = new ArrayList<>(p);
        if(p == q) {
            return p;
        } else {
            for(T items : q) {
                r.add(items);
            }
            return r;
        }
    }
}
