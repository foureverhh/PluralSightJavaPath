package lookup.pack;

import product.pack.Product;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable  implements ProductLookupTable {

    private Map<Integer, Product> idToProduct = new HashMap<>();

    @Override
    public Product lookupById(int id) {
        return idToProduct.get(id);
    }

    @Override
    public void addProduct(Product productToAdd) {
        if(idToProduct.containsKey(productToAdd.getId())){
            throw new IllegalArgumentException("Unable to add product, duplicate id for "+productToAdd);
        }
        idToProduct.put(productToAdd.getId(),productToAdd);
    }

    @Override
    public void clear() {
        idToProduct.clear();
    }
}
