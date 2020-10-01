package test;
import bean.SingletonHunger;
import bean.SingletonLazy;
import bean.SingletonInnerClass;

public class Test {
    public static void main(String[] args) {
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy3 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1);
        System.out.println(singletonLazy2);
        System.out.println(singletonLazy3);

        SingletonInnerClass singletonInnerClass1 = SingletonInnerClass.getInstance();
        SingletonInnerClass singletonInnerClass2 = SingletonInnerClass.getInstance();
        SingletonInnerClass singletonInnerClass3 = SingletonInnerClass.getInstance();
        System.out.println(singletonInnerClass1);
        System.out.println(singletonInnerClass2);
        System.out.println(singletonInnerClass3);

        SingletonHunger singletonHunger1 = SingletonHunger.getInstance();
        SingletonHunger singletonHunger2 = SingletonHunger.getInstance();
        SingletonHunger singletonHunger3 = SingletonHunger.getInstance();
        System.out.println(singletonHunger1);
        System.out.println(singletonHunger2);
        System.out.println(singletonHunger3);
    }
}
