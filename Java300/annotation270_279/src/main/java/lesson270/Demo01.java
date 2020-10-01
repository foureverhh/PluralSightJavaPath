package lesson270;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    public static void main(String[] args) {
        deprecatedMethod();//引用时会有中划线
        normalMethod();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @SuppressWarnings("all")
    @Deprecated
    public static void deprecatedMethod(){
        System.out.println("This is a deprecated method");
    }

    @SuppressWarnings("all") //使List上提示错误的底色消失,压制错误提示
    public static void test02(){
        List list1 = new ArrayList<>();
        List list2 = new ArrayList<>();
    }

    public static void normalMethod(){
        System.out.println("this is normal method");
        deprecatedMethod();
    }
}
