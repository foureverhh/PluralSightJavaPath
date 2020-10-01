package bean;

public class SingletonLazy {
    private static SingletonLazy instance;
    //私有化构造器，使其他类不能访问构造器来创建实例
    private SingletonLazy(){
    }

    public static SingletonLazy getInstance(){
        //添加逻辑如果实例化过，直接返回
        if (instance == null)
            //多线程情况下，可能出现多个线程instance都为null，造成不同线程创建出不同的实例，因此对Singleton class加同步锁
            synchronized (SingletonLazy.class) {
                //每一个进入的线程先验证instance是否为null，如果不是则创建新的
                if(instance == null) {
                    instance = new SingletonLazy();
                }
            }
        return instance;
    }
}
