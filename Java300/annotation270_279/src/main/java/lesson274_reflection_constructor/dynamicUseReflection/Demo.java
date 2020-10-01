package lesson274_reflection_constructor.dynamicUseReflection;

import utils.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) {
        String path = "utils.model.User";
        try {
            Class<?> userClz = Class.forName(path);
            User mike = (User) userClz.getConstructor(int.class,int.class,String.class).newInstance(1,24,"Mike");
            System.out.println(mike);
            User defaultUser = (User) userClz.getConstructor().newInstance();
            System.out.println(defaultUser);

            //动态通过反射调用方法
            Method  setName = userClz.getDeclaredMethod("setName",String.class);
            User u3 = (User) userClz.getConstructor().newInstance();
            User u4 = (User) userClz.getConstructor().newInstance();
            setName.invoke(u3,"U3_NAME");
            System.out.println(u3.getName());

            //动态，通过反射操作属性
            Field uname_u4 = userClz.getDeclaredField("uname");
            //通过getDeclaredField可以修改private的field，但是不能访问，需要修改权限
            uname_u4.setAccessible(true);
            //java.lang.IllegalAccessException: class lesson274_reflection_constructor.dynamicUseReflection.
            // Demo cannot access a member of class utils.model.User with modifiers "private"
            uname_u4.set(u4,"U4_name");
            System.out.println(u4.getName());
            //通过反射调用u4的uname属性
            System.out.println(uname_u4.get(u4));

            //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
