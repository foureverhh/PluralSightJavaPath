package Dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartInterface {
    List<String> getCart();
    void addCart(String product);
}
