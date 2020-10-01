package lesson275_reflection_performance.performance_compare;

import utils.model.User;

import java.lang.reflect.Method;

public class Demo {
    public static void test01(){
        User u = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L ; i++) {
            u.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用，执行10亿次，耗时" + (endTime - startTime) + "ms");
    }

    public static void test02(){
        User u = new User();
        try {
            Class<?> userClass = Class.forName("utils.model.User");
            Method getUserName = userClass.getDeclaredMethod("getName",null);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000000L ; i++) {
                getUserName.invoke(u,null);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("反射调用，执行安全检查，执行10亿次，耗时" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test03(){
        User u = new User();
        Class<?> userClass = u.getClass();
        try {
            Method method = userClass.getDeclaredMethod("getName",null);
            method.setAccessible(true);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000000L ; i++) {
                method.invoke(u,null);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("反射调用，跳过安全检查setAccessible(true)，执行10亿次，耗时" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //普通最快，跳过安全检查的次之，需要安全检查的最慢
        test03();
        test02();
        test01();
    }
}
