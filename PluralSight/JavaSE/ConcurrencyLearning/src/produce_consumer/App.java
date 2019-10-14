package produce_consumer;

public class App {
    private static int[] buffer;
    private static int count;
    private static Object lock = new Object();

    static class Producer{
        void produce(){
            synchronized (lock) {
                if(isFull(buffer)){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[count++]=1;
                lock.notify();

            /*    while (isFull(buffer)) {
                    // buffer[count++] = num++;
                    buffer[count++] = 1;
                }*/
            }
        }

    }

    static class Consumer{
        void consume(){
            synchronized (lock) {
                if(isEmpty(buffer)){
                    try {
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[--count] = 0;
                lock.notify();
                /*
                while (isEmpty(buffer)) {
                    buffer[count--] = 0;
                    //buffer[count--] = num--;
                }
                */
            }
        }
    }

    static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            System.out.println("count in producer:");
            //System.out.println("num in producer:");
            for (int i = 0; i < 50 ; i++) {
               producer.produce();
                System.out.print(count+" ");

            }
            System.out.println();
            System.out.println("Done producing");
        };

        Runnable consumeTask = () -> {
            System.out.println("count in consumer:");
            //System.out.println("num in consumer:");
            for (int i = 0; i <50 ; i++) {
                consumer.consume();
                System.out.print(count+" ");
                //System.out.print(num+" ");
            }
            System.out.println();
            System.out.println("Done consuming");
        };

        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("Data in the buffer "+count);
    }
}
