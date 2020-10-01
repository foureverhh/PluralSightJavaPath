package bean;

public class SingletonInnerClass {

    private SingletonInnerClass(){

    }
    private static class SingletonClassHelper{
        private static SingletonInnerClass instance = new SingletonInnerClass();
    }
    public static SingletonInnerClass getInstance(){
        return SingletonClassHelper.instance;
    }
}
