package model;

import controller.ProductController;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
@Named
@ViewScoped
public class ProductDetails implements Serializable {
    private int id;
    private Product product;
    @Inject
    private ProductController controller;

    public void onLoad(){
        product = controller.findProductById(id);
        System.out.println(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
