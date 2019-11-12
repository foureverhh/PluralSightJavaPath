package demo_all.dem02;

import java.util.Timer;
import java.util.TimerTask;

public class Worker extends Thread{
    private final Object key = new Object();
    private volatile boolean quittingTime = false;

    public void run(){
        while(!quittingTime){
            working();
            System.out.println("Still working..."+Thread.currentThread().getName());

        }
        System.out.println("Coffee is good !"+Thread.currentThread().getName());
    }

    private void working(){
        try {
            Thread.sleep(300);
        }catch (Exception e){

        }
    }

    synchronized void quit() throws InterruptedException {
        System.out.println("Quit "+Thread.currentThread().getName());
        System.out.println("Quit outside: "+Thread.holdsLock(this));
        System.out.println("Quit outside: "+Thread.holdsLock(key));
        synchronized (key) {
            quittingTime = true;
            System.out.println("Calling join");
            System.out.println("Quit inside "+Thread.currentThread().getName());
            System.out.println("Quit inside: "+Thread.holdsLock(this));
            System.out.println("Quit inside: "+Thread.holdsLock(key));
            join();//join would call wait(0) and lost its key
            System.out.println("Back from join");
        }
    }

    synchronized void keepWorking()  {
        System.out.println("kod is here");
        System.out.println("keepWorking ends here!!! " + Thread.currentThread().getName());
        System.out.println("keep working outside: "+Thread.holdsLock(this));
        System.out.println("keep working outside: "+Thread.holdsLock(key));
        synchronized (key) {
            System.out.println("keep working inside: "+Thread.holdsLock(this));
            System.out.println("keep working inside: "+Thread.holdsLock(key));
            quittingTime = false;
            System.out.println("!!!!Keep working...");

        }
        System.out.println("!!!kod is also here");
    }

    public static void main(String[] args) throws InterruptedException {
        final Worker w = new Worker();
        w.start();

        Timer t = new Timer(true);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                w.keepWorking();
                System.out.println("!!!Timer "+Thread.currentThread().getName());
            }
        },500);

        Thread.sleep(400);
        System.out.println("main "+Thread.currentThread().getName());
        w.quit();
    }
}
