package race_condition;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper = new LongWrapper(0L);
        Runnable r = () -> {
            for (int i = 0; i <1000 ; i++) {
                longWrapper.increaseValue();
            }
        };
        Thread[] threads = new Thread[1000];
        for (int i = 0; i <threads.length ; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }
        /*
        Thread t = new Thread(r);
        //Thread.sleep(2000);
        t.join(); //The same effect as Thread.sleep(2000) to make current thread blocks to finish runnable
        t.start();
        */
        for (int i = 0; i <threads.length ; i++) {
            threads[i].join();
        }
        System.out.println("value ="+longWrapper.getL());
    }
}
