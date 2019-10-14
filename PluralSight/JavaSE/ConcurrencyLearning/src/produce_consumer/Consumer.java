package produce_consumer;

public class Consumer {
    private Object lock;
    int[] buffer = new int[1024];
    int counter = buffer.length;

    public void consume(){
        synchronized (lock){
            while (counter>0){
                buffer[--counter] = 0;
            }
        }
    }
/*
    public synchronized void consumer(){
        while(counter>0){
            buffer[--counter] = 0;
        }
    }
*/


}
