package demo_all.demo01_atomic;

public class LongWrapper {
    private Object key = new Object();
    //volatile can not garantee atomic of i++,so synchronized is the right solution
    private volatile long l;
    //private long l;

    public LongWrapper(long l){
        this.l = l;
    }

    public long getValue() {
        //The read of value should synchronized as well
        synchronized (key) {
            return l;
        }
    }

    public void increaseValue(){
      synchronized (key){
            l = l+1;
      }
    }
}
