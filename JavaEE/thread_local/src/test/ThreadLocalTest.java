package test;

public class ThreadLocalTest {
    public static void main(String[] args) {
        //ThreadLocal
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("测试");
        System.out.println(threadLocal.get());
        new Thread(()->{
            System.out.println("ThreadLocal 更换线程后，不能取到threadLocal中的object");
            System.out.println(Thread.currentThread().getName()+" ,"+threadLocal.get());
        },"worker").start();
    }
}
