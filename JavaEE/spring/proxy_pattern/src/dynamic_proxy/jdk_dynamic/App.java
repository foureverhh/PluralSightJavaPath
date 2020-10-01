package dynamic_proxy.jdk_dynamic;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        //jdk动态代理只能通过接口来实现动态代理，动态代理类需要调用invocationHandler接口，同时通过Proxy.newProxyInstance()来创建动态代理类实例
        Laozong laozong = new Laozong("马云");
        DynamicProxy dynamicProxy = new DynamicProxy(laozong);
        GongNeng p =(GongNeng) Proxy.newProxyInstance(GongNeng.class.getClassLoader(),laozong.getClass().getInterfaces(),dynamicProxy);
        p.chifan();
        p.mubiao();

    }
}
