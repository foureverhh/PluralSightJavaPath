import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Shipment implements Iterable<Product>{
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private final List<Product> products = new ArrayList<>();
    public static final int PRODUCT_NOT_PRESENT = -1;

    public void add(Product product){
        products.add(product);
    }

    public void replace(Product oldProduct, Product newProduct){

        int index = products.indexOf(oldProduct);
        if(index != PRODUCT_NOT_PRESENT)
            products.set(index,newProduct);
    }

    public void prepare(){

    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    @Override
    public void forEach(Consumer<? super Product> action) {

    }

    @Override
    public Spliterator<Product> spliterator() {
        return null;
    }

    public List<Product> getHeavyVanProducts(){
        return null;
    }

    public List<Product> getLightVanProducts(){
        return null;
    }
}
