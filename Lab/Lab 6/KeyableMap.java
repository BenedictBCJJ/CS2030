import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class KeyableMap<T, K, V extends Keyable<K>> implements Keyable<T> {
    private T key;
    private Map<K, V> map = new HashMap<>();
    private Optional<Map<K, V>> optional = Optional.of(map);

    public KeyableMap(T key) {
        this.key = key;
    }

    @Override
    public T getKey() {
        return this.key;
    }

    public KeyableMap<T,K,V> put(V item) {
        map.put(item.getKey(), item);
        return this;
    }

    public Optional<V> get(K key) {
        return optional.map(map -> map.get(key));
    }

    @Override
    public String toString() {
        return (this.key + ": " + map.values()).replace("[","{").replace("]","}");
    }
}
