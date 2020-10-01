package controller;

import model.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("productController")
@SessionScoped
public class ProductController implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Product> products;
    private Product chosenProduct;

    public Product getChosenProduct() {
        return chosenProduct;
    }

    public void setChosenProduct(Product chosenProduct) {
        this.chosenProduct = chosenProduct;
    }

    public ProductController() {
    }

    @PostConstruct
    public void inti(){
        populateProducts();
    }
    private void populateProducts() {
        products = new ArrayList<Product>();
        products.add(new Product(1,"Product1","Product1 description"));
        products.add(new Product(2,"Product2","Product2 description"));
    }

    public Product findProductById(int id){
        Product p =null;
       for(Product product : products){
           if(product.getId() == id){
               p = product;
               break;
           }
       }
       return p;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
