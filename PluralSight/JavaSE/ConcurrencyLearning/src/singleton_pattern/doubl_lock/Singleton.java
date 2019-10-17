package singleton_pattern.doubl_lock;

public class Singleton {
    //make instance volatile visible
    private static volatile Singleton instance;
    private static final Object key = new Object();

    private  Singleton(){

    }
    /*
    //Use synchronized to realize (Only works so nice on a mono-core system)
    //The other of cores of a multi-core system have to want and only one thread
    //can use the instance because of synchronized key word
    public static synchronized Singleton getInstance(){
        if(null == instance){
            return instance = new Singleton();
        }
        else
            return instance;
    }
    */

    //Double check locking
    public static Singleton getInstance(){
        // the read part is not synchronized or volatile, it is buggy
        if(instance != null){
            return instance;
        }
        //The write part is synchronized
        synchronized (key){
            if(null==instance){
                instance = new Singleton();
            }
            return instance;
        }
    }
}
