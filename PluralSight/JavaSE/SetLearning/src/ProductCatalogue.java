import java.util.*;


public class ProductCatalogue implements Iterable<Product> {

    //private final Set<Product> products = new HashSet<>();
    //private final Set<Product> products = new TreeSet<Product>(Product.BY_NAME);
    private final SortedSet<Product> products = new TreeSet<>(Product.BY_SIZE);


    public void isSuppliedBy(Supplier supplier) {
        products.addAll(supplier.products());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public Set<Product> lightVanProducts(){
        Product heaviesLightVanProduct = findHeaviestLightVanProduct();
        return products.headSet(heaviesLightVanProduct);
    }

    public Set<Product> heavyVanProducts(){
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.tailSet(heaviestLightVanProduct);
    }

    private Product findHeaviestLightVanProduct() {
        for(Product product:products){
            if(product.getSize() >20){
                return product;
            }
        }
        return  products.last();
    }
}
