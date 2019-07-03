import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class Main {

    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        MyWorker worker = new MyWorker();
        worker.doDoubleWork();
        BankAccount account = new BankAccount("1234");
        try {
            startWork("AccountWorker",account);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Class<?> awClass = AccountWorker.class;
        if(awClass.isAnnotationPresent(WorkHandler.class)){
            Annotation workHandlerSample = awClass.getAnnotation(WorkHandler.class);
            System.out.println(workHandlerSample);
        }

        try {
            startWork("AccountWorker",account);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startWork(String workerTypeName, Object workerTarget) throws Exception{

        Class<?> workerType = Class.forName(workerTypeName);
        TaskWorker worker = (TaskWorker) workerType.newInstance();
        worker.setTarget(workerTarget);
        //Initialize an instance from annotation
        WorkHandler workHandler= workerType.getAnnotation(WorkHandler.class);
        if(workHandler == null){
            throw new Exception("Error");
        }
        if(workHandler.value()){//useThreadPool()){
            pool.submit(()->{
                System.out.println("Multi-thread triggered");
                worker.doWork();
            });
        }else
            worker.doWork();
    }

    public static void startWorkSelfContained(Object workerTarget) throws IllegalAccessException,
            InstantiationException {
        Class<?> targetType = workerTarget.getClass();
        ProcessedBy pb = targetType.getAnnotation(ProcessedBy.class);
        Class<?> workType = pb.value();
        TaskWorker worker = (TaskWorker) workType.newInstance();
        worker.doWork();
    }

}
