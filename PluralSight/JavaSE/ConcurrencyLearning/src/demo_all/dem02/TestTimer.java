package demo_all.dem02;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) throws InterruptedException {

       Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("I am from timer");
                System.out.println("Timer "+Thread.currentThread().getName());
            }
        },1000);
        System.out.println("Main "+Thread.currentThread().getName());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Sleep 2 sec in"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        System.out.println("Main "+Thread.currentThread().getName());
    }
}
