public interface Iterable<T> {
    /**
     * Genera e restituisce un oggetto che
     * implementa Iterator<T>.
     * */
    Iterator<T> iterator();
}
public interface Iterator<E> {
    /* Definisce quale' il prossimio elemento. */
    E next();
    /* Dice se c'e' un prossimo elemento. */
    boolean hasNext();
    /* Praticonata. */
    void remove();
}