package it.unibo.collections.design;

import java.util.Objects;

import it.unibo.collections.design.api.Product;

public class ProductImpl implements Product {
    private final String name;
    private final double Quantity;

    public ProductImpl (final String name, final double Quantity) {
        this.name = name;
        this.Quantity = Quantity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getQuantity() {
        return this.Quantity;
    }

    @Override
    public boolean equals(final Object o) {
        Product p = (Product)o;
        if (p.getName() == this.name) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.Quantity);
    }
}
