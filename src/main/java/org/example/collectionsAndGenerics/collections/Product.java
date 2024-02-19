package org.example.collectionsAndGenerics.collections;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private Integer id;

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + id;
        return hash;
    }

    @Override
    public int compareTo(Product o) { // So here we have natural order
        return id.compareTo(o.id);
    }
}
