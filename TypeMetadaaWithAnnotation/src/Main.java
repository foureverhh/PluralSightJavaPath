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
        if(workHandler.useThreadPool()){
            pool.submit(()->{
                worker.doWork();
            });
        }else
            worker.doWork();
    }
}
