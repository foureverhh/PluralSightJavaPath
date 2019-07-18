package com.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingBasket {
    private final List<Product> items = new ArrayList<>();
    private int totalWeight = 0;

    public void add(Product product){
        items.add(product);
        totalWeight += product.getWeight();
    }

    public List<Product> getItems() {
        //By adding Collections.unmodifiableList(items)  make the list can not invoke List.api functions
        return  Collections.unmodifiableList(items);
    }

    @Override
    public String toString() {
        return "Shopping Basket of \n" + items + "\nwith weight: "+ totalWeight;
    }
}

