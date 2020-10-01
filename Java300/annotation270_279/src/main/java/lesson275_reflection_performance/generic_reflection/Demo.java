package lesson275_reflection_performance.generic_reflection;

import utils.model.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Demo {
    public void test01(Map<String, User> map, List<User> list){
        System.out.println("Demo.test01");
    }

    public Map<Integer, User> test02(){
        System.out.println("Demo04.test02()");
        return null;
    }

    public static void main(String[] args) {
        try {
            //获得指定方法的 参数泛型 信息
            Method m_test01 = Demo.class.getDeclaredMethod("test01", Map.class,List.class);
            Type[] t = m_test01.getGenericParameterTypes();
            for(Type paramType : t){
                System.out.println("#参数泛型" + paramType);
                if(paramType instanceof ParameterizedType){
                    Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for(Type genericType : genericTypes){
                        System.out.println("泛型类型" + genericType);
                    }
                }
            }
            //获得指定方法的 返回泛型 信息
            Method m_test02 = Demo.class.getDeclaredMethod("test02",null);
            Type type = m_test02.getGenericReturnType();
            System.out.println("#返回值泛型： " + type);
            if(type instanceof ParameterizedType){
                Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                for(Type t_type : types){
                    System.out.println("泛型类型： " + t_type);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
