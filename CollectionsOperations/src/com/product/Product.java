package com.product;

import java.util.Comparator;

public class Product {
    public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);
    public static final Comparator<Product> BY_WEIGHT = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    };

    private int id;
    private int weight;
    private String name;

    public Product(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public Product(int id, String name, int weight) {
        this.id = id;
        this.weight = weight;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{id=\'"+id+"\',"+"name=\'"+name+"\', weight=\'"+weight+"\'";
    }
}
