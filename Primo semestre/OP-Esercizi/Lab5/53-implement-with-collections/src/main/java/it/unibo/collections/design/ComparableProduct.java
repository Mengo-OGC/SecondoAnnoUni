package it.unibo.collections.design;

import it.unibo.collections.design.api.Product;

public class ComparableProduct extends ProductImpl implements Comparable<Product> {

    public ComparableProduct(String name, double Quantity) {
        super(name, Quantity);
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }

}
