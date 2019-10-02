package covariance_contravariance;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
     /*
        List<? extends Fruit> flist = new ArrayList<Apple>();
        flist.add(new Apple());  // 编译错误
        flist.add(new Fruit());  // 编译错误
        flist.add(new Object());  // 编译错误
        //As ? extends means the upper(highest) class would be Fruit, so a Orange type is also ok
        //So no classes can be added
        */
    }
}
