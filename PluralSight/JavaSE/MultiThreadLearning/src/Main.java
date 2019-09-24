import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        String[] inFiles = {
                "data1.txt",
                "data2.txt",
                "data3.txt",
                "data4.txt",
                "data5.txt",
                "data6.txt"
        };

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];
        for( int i=0;i<inFiles.length;i++){
            Adder adder = new Adder(inFiles[i]);
            try {
                results[i] = es.submit(adder);

                //System.out.println("Total in "+inFiles[i]+" is "+adder.call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
        for(Future<Integer> result: results){
            try {
                int value = result.get();
                System.out.println("Total: "+value);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e2) {
                Throwable adderEx = e2.getCause();

            }
        }

    }
}
