import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);
        Thread[] workers = new Thread[5];
        for(int i = 0; i < 5; i++){
            workers[i] = new Thread(new Worker(account));

            es.submit(workers[i]);
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Worker worker = new Worker(account);
        //es.submit(workers);
        es.shutdown();

    }
}
