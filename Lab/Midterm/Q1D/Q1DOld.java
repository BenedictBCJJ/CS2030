public class D{
    static <T> List<T> add(List<T> list, T item) {
        list.add(item);
        return list;
    }
    static <T> List <T> join(List<T> p, List<U> q) {
        if(p == q) {
            return p;
        } else {
            for(U items : q) {
                p.add(items);
            }
            return p;
        }
    }
}
