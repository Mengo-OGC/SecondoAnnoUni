package it.unibo.collections.comparators;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Double.compare(Double.parseDouble(o1), Double.parseDouble(o2));
    }

}