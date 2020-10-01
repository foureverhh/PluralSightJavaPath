package lesson273_Class_intro;

public class App {
    public static void main(String[] args) {
        String path =  "utils.model.User";
        try {
            Class<?> userClz1 = Class.forName(path);
            System.out.println(userClz1 + ", with hashcode: " + userClz1.hashCode());

            Class<?> userClz2 = Class.forName(path);
            System.out.println(userClz2 + ", with hashcode: " + userClz2.hashCode());

            //一个类的Class对象只会加载一次，所以static修饰的filed会天然的线程安全
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
