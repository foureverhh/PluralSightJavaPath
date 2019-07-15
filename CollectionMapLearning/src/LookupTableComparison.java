import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LookupTableComparison {

    private static final int ITERATION = 5;
    private static final int NUMBER_OF_PRODUCTS = 20_000;

    private static final List<Product> products = generateProducts();

    private static List<Product> generateProducts() {
        List<Product> products = new ArrayList<>();
        Random weightGenerator = new Random();
        for(int i=0; i<NUMBER_OF_PRODUCTS;i++){
            products.add(new Product(i,"Product "+i,10+weightGenerator.nextInt(10)));
        }
        Collections.shuffle(products);
        Collections.shuffle(products);
        return products;
    }

    public void runLookups(ProductLookupTable lookupTable){
        List<Product> products = LookupTableComparison.products;
        System.out.println("Running lookups with " + lookupTable.getClass().getSimpleName());
        for(int i = 0; i < ITERATION; i++){
            long startTime = System.currentTimeMillis();
            for(Product product : products){
                lookupTable.addProduct(product);
            }
            for(Product product : products){
                Product result = lookupTable.lookupById(product.getId());
                if(result != product){
                    throw new IllegalStateException("Lookup Table returned wrong result for " + product);
                }
            }
            lookupTable.clear();
            System.out.println(System.currentTimeMillis() - startTime + " ms..,");
        }
    }
}
