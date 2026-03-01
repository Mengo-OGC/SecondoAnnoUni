package it.unibo.collections.design;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import it.unibo.collections.design.api.Product;

public class OrderedWarehouse extends WarehouseImpl {
    @Override
    public Set<Product> allProducts() {
        return new TreeSet<Product>(super.allProducts());
    }
}
