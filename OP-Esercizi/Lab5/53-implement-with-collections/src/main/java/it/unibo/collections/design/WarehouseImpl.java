package it.unibo.collections.design;

import java.util.Set;

import it.unibo.collections.design.api.Product;
import it.unibo.collections.design.api.Warehouse;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class WarehouseImpl implements Warehouse{
    protected final Set<Product> products;

    public WarehouseImpl (){
        this.products = new LinkedHashSet<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public Set<String> allNames() {
        Set<String> names = new LinkedHashSet<>();
        for (Product p : products) {
            names.add(p.getName());
        }
        return names;
    }

    public Set<Product> allProducts() {
        return new LinkedHashSet<>(Set.copyOf(this.products));
    }

    public boolean containsProduct(Product p) {
        return products.contains(p);
    }

    public double getQuantity(String name) {
        for (Product p : products) {
            if (p.getName() == name) {
                return p.getQuantity();
            }
        }
        return -1;
    }
}
