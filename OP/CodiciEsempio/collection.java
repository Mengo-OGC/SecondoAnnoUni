public interface Iterable<T> {
    Iterator<T> iterator();
}
public interface Iterator<E> {
    E next();
    boolean hasNext();
    void remove();      // Praticonata.
}
public interface Collection<E> implements Iterable<E> {
    ...
}