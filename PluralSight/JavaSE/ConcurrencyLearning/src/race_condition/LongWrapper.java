package race_condition;

public class LongWrapper {
    private Object key = new Object();
    private long l;
    public LongWrapper(long l){
        this.l = l;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }

    public void increaseValue(){
        synchronized (key){
            l = l + 1;
        }
    }
}
