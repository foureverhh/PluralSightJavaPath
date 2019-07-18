package com.product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private final List<Product> items = new ArrayList<>();
    private int totalWeight = 0;

    public void add(Product product){
        items.add(product);
        totalWeight += product.getWeight();
    }

    public List<Product> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Shopping Basket of \n" + items + "\nwith weight: "+ totalWeight;
    }
}

