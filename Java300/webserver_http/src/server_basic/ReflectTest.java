package server_basic;

import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //Three ways to get Class
        //1.get class from a instance
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        System.out.println(clz);
        //2.get class Class direct
        clz = Iphone.class;
        System.out.println(clz);
        //3. forClass("package.class")
        try {
            clz = Class.forName("server_basic.Iphone");
            System.out.println(clz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Iphone myIphone = (Iphone) clz.getConstructor().newInstance();
        System.out.println(myIphone);
    }
}

class Iphone{
    private String model;
    public Iphone(){
        model = "Iphone X";
    }

    @Override
    public String toString() {
        return "New iPhone with model "+model;
    }
}
