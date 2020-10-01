package dynamic_proxy.cglib_dynamic;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import static_proxy.com.bjsxt.pojo.LaoZong;

import java.lang.reflect.Method;

public class DynamicProxy implements MethodInterceptor {
    //父类为被代理类，需要实际运行
    //o为子类对象，method为代理的方法，objects为代理的方法的参数，子类生成的对应的代理方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSimpleName() + "->预约时间啊");
        //invoke（）调用子类重写的方法
        Object result = methodProxy.invokeSuper(o,objects); //等同于 method.invoke(o,objects);
        System.out.println("备注啊");
        return result;
    }
}
