package it.unibo.collections.sets;

import static it.unibo.collections.test.Assertions.*;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
        Set<String> ss = new TreeSet<>();
        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        for (int i = 1; i <= ELEMS; i++) {
            ss.add(Integer.toString(i));
        }
        /*
         * 3) Prints its content
         */
        System.err.println(ss);
        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        Set<String> copy = Set.copyOf(ss);
        for (String s : copy) {
            if (Integer.parseInt(s) % 3 == 0) {
                ss.remove(s);
            }
        }
        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        for (String s : ss) {
            System.err.println(s);
        }
        /*
         * 6) Verifies whether all the numbers left in the set are even
         */
        assertContentEqualsInAnyOrder(Set.of(2,4,8,10,14,16,20), ss);

    }
}
