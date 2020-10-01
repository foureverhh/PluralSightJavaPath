package controller;

import Dao.CartInterface;
import DaoImpl.CartBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {
    private List<String> cart;
    private int counter;

    @EJB
    private CartInterface cartInterface;

    public CartController() {
    }

    @PostConstruct
    public void init(){
        cart = cartInterface.getCart();
        cart.add("product1");
        cart.add("product2");
        counter = 2;
    }
    public List<String> getCart() {
        return cart;
    }

    public void setCart(List<String> cart) {
        this.cart = cart;
    }

    public void addProduct(){
        counter++;
        cartInterface.addCart("product" + counter);
    }

}
