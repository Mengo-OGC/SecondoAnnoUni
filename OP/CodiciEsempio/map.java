public interface Map<K,V> {
    ...
    Set<Map.Entry<K, V>> entrySet();
    interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
    }
}