import java.util.List;

public class Supplier {
    private String supplierName;
    private List<Product> products;

    public Supplier(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public List<Product> products(){
        return products;
    }


}
