package covariance_contravariance;

import java.util.ArrayList;
import java.util.List;

public class SuperClassWildCard {
    public static void main(String[] args) {
        List<? super Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new Orange());
        fruits.add(new Jonathan());
    }
    //lower bound the list accepts the most base class would be Fruit type
    //So all subclasses of Fruit could be added
}
