import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window",10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        //for each loop creates ConcurrentModificationException
        for(Product product:products){
            if(product.getSize() >20){
                System.out.println(product);
            }else{
                products.remove(product);
            }
        }


/*
        System.out.println(products);
        System.out.println();
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            Product product =iterator.next();
            if(product.getSize()>20){
                System.out.println(product);
            }else {
                iterator.remove();
            }
        }

 */


        /*
        System.out.println(products);
        System.out.println();
        System.out.println("For each loop:");
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println(products.size());
        System.out.println(products.contains(window));
        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(window);
        otherProducts.add(door);

        products.removeAll(otherProducts);
        System.out.println(products);
        */

    }
}
