package produce_consumer;

import java.io.ObjectOutputStream;

public class Producer {
    private Object lock;
    int[] buffer = new int[1024];
    int counter = 0;
    protected void produce(){
        synchronized (lock){
            while (counter<buffer.length){
                buffer[counter++] = 1;
            }
        }
    }
  /*
    //Do not work as it lock the instance it self
    public synchronized void produce(){
        while (counter<buffer.length){
            buffer[counter++]=1;
        }
    }*/
}
