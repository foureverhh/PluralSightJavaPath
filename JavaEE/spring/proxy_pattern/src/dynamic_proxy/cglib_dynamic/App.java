package dynamic_proxy.cglib_dynamic;

import net.sf.cglib.proxy.Enhancer;

public class App {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Laozong.class);
        //Callback是一个接口，这里是加载一个代理类的实例
        enhancer.setCallback(new DynamicProxy());
        Laozong laozong = (Laozong) enhancer.create();
        laozong.chifan();
        laozong.mubiao();
    }
}
