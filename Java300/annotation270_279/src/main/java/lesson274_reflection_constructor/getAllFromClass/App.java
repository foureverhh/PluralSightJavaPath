package lesson274_reflection_constructor.getAllFromClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
* 应该用Reflection API，获取类的所有信息,属性、方法、构造器
*
* */
public class App {
    public static void main(String[] args) {
        String path = "utils.model.User";
        try {
            Class<?> userClz = Class.forName(path);
            System.out.println(userClz);

            //获得属性
            Field[] getFields = userClz.getFields(); //getFields（）只能获得public属性
            System.out.println(getFields.length);
            Field[] getDeclaredFields = userClz.getDeclaredFields(); //getDeclaredFields()可以获得所有属性
            if(getDeclaredFields.length > 0){
                System.out.println("Get declared fields: " + getDeclaredFields.length);
                for(Field field : getDeclaredFields){
                    System.out.println(field.getName());
                }
            }

            Field uname = userClz.getDeclaredField("uname");
            System.out.println("uname filed: "+uname.getName());

            //获得方法
            Method[] getMethods = userClz.getMethods();//只能获得public 的方法
            Method[] getDeclaredMethods = userClz.getDeclaredMethods();//所有方法
            System.out.print(Arrays.toString(getMethods) + "  ||  ");
            System.out.println();

            System.out.print(Arrays.toString(getDeclaredMethods) + " || ");
            System.out.println();

            Method getName = userClz.getMethod("getName",null);
            System.out.println("getName method: " + getName );

            Method setNameWithParam = userClz.getMethod("setName", String.class);//需要写明参数的class类型，因为有重载
            System.out.println("setName method: " + setNameWithParam);


            Method setName = userClz.getMethod("setName", null);//需要写明参数的class类型，因为有重载
            System.out.println("setName method: " + setName);


            //获得构造器

            Constructor<?>[] getConstructors = userClz.getConstructors();
            if(getConstructors.length > 0){
                    System.out.println("Constructor(public):");
                for (Constructor<?> constructor : getConstructors){
                    System.out.println(constructor);
                }
            }
            System.out.println();
            Constructor<?>[] getDeclaredConstructors = userClz.getDeclaredConstructors();
            if(getConstructors.length > 0){
                System.out.println("Constructor(public):");
                for (Constructor<?> constructor : getDeclaredConstructors){
                    System.out.println(constructor);
                }
            }
            System.out.println();
            System.out.println("获取无参构造器");
            Constructor<?> constructorWithNoParam = userClz.getConstructor(null);
            System.out.println(constructorWithNoParam);
            System.out.println();
            System.out.println("获取有参构造器");
            Constructor<?> constructorWithParam = userClz.getConstructor(int.class,int.class,String.class);
            System.out.println(constructorWithParam);




        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
