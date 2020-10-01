package DaoImpl;

import Dao.CartInterface;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartBean implements CartInterface {
    private List<String> cartList = new ArrayList<>();

    @Override
    public List<String> getCart() {
        return cartList;
    }

    @Override
    public void addCart(String product) {
        cartList.add(product);
    }

    public List<String> getCartList() {
        return cartList;
    }

    public void setCartList(List<String> cartList) {
        this.cartList = cartList;
    }
}
