import com.product.Product;
import com.product.ProductFixtures;
import com.product.ShoppingBasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        List<Product> products = new ArrayList<>();
        products.add(ProductFixtures.door);
        products.add(ProductFixtures.floorPanel);
        products.add(ProductFixtures.window);

        System.out.println(products);
        System.out.println();

        Collections.rotate(products,1);
        System.out.println(products);
        System.out.println();

        Collections.rotate(products,1);
        System.out.println(products);
        System.out.println();

        Collections.rotate(products,1);
        System.out.println(products);
        System.out.println();

        Collections.shuffle(products);
        System.out.println("Shuffled: "+products);

        //Collections.sort(products, Product.BY_NAME);
        products.sort(Product.BY_NAME);//This is better
        System.out.println("Sorted by name: "+products);
        System.out.println();

        //Collections.sort(products, Product.BY_WEIGHT);
        products.sort(Product.BY_WEIGHT); //This is better
        System.out.println("Sorted by weight: "+ products);
        */

        ShoppingBasket basket = new ShoppingBasket();
        basket.add(ProductFixtures.door);
        System.out.println(basket);

        basket.getItems().remove(ProductFixtures.window);//This add is out of the range of add function in Shopping basket
        System.out.println(basket);
    }
}
