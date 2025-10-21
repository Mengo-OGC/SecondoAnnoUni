public interface Collection<E> extends Iterable<E> {
    int size();
    // Preferibile isEmpty().
    // Sempre O(1) secondo l'implementazione.
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<E> iterator();
    Object[] toArray();         // Non usare.
    <T> T[] toArray(T[] a);     // Non usare.

    boolean add(E e);
    boolean remove(Object<?> c);

    /**
     * Bulk Opeartion: containsAll, addAll, 
     * removeAll, retainAll
     * */ 

     void clear();

     // ...
}