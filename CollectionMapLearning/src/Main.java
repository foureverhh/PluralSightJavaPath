import lookup.pack.LookupTableComparison;
import lookup.pack.MapProductLookupTable;
import lookup.pack.NaiveProductLookupTable;
import product.pack.Product;
import product.pack.ProductFixtures;
import java.util.*;

import static product.pack.ProductFixtures.*;

public class Main {

    public static void main(String[] args) {

        //comparePerformance();
        //mapOverview();
        final Product defaultProduct = new Product(-1,"Whatever the customer wants",100);
        final Map<Integer, Product> productMap = new HashMap<>();

        productMap.put(1, door);
        productMap.put(2,floorPanel);
        productMap.put(3,window);

        System.out.println(productMap);
        productMap.forEach((key,value) ->
                System.out.println(key + " -> " + value));
        /*
        //getOrDefault test
        Product result = productMap.getOrDefault(10,defaultProduct);
        System.out.println(result);                  //It will print the old value
        System.out.println(productMap.get(10));      //It will print the new value
         */

        /*
        //replace test
        Product result = productMap.replace(1,new Product(1,"Big Door",50));
        System.out.println(result);
        System.out.println(productMap.get(1));
        */
        /*
        System.out.println(productMap);
        //replaceAll() test
        productMap.replaceAll((id, oldProduct)->
                new Product(id, oldProduct.getName(),oldProduct.getWeight()+10)
                );
        System.out.println(productMap);

        //computeIfAbsent(); test
        Product result = productMap.computeIfAbsent(10, (id)-> new Product(id,"Custom product", 10));
        System.out.println(result);
        */


    }

    static void comparePerformance(){
        LookupTableComparison comparison = new LookupTableComparison();
        comparison.runLookups(new NaiveProductLookupTable());
        comparison.runLookups(new MapProductLookupTable());
    }

    static void mapOverview(){
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1,ProductFixtures.door);
        idToProduct.put(2,ProductFixtures.floorPanel);
        idToProduct.put(3,ProductFixtures.window);
        System.out.println(idToProduct);
        System.out.println();
        Set<Integer> ids = idToProduct.keySet();
        System.out.println(ids);

        //remove an item in the key Set will delete the item in the value collection as well
        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToProduct);
        System.out.println();

        //id.add(4) will not work

        Collection<Product> products = idToProduct.values();
        System.out.println(products);
        System.out.println();

        //remove the item in the value collection  will delete an item in the key Set as well
        products.remove(ProductFixtures.floorPanel);
        System.out.println(products);
        System.out.println(idToProduct);
        System.out.println();

        //products.add(ProductFixtures.floorPanel); will not work

        Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
        for(Map.Entry entry : entries){
            int key = (int) entry.getKey();
            //Product product = (Product) entry.getValue();
            entry.setValue(ProductFixtures.floorPanel);
            System.out.println(key+"=> "+entry.getValue());
        }
        System.out.println();

        Iterator<Map.Entry<Integer,Product>> it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Product> entry = it.next();
            int key = entry.getKey();
            Product product = entry.getValue();

            System.out.println(key+" -> "+ entry.getValue());
        }

    }

}


