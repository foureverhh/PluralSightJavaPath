package web12306;
/*
*多个线程，共享资源，发生并发问题（必须确保线程安全！！）
* */
public class Web12306 implements Runnable {
    private int ticketNums = 99;
    @Override
    public void run() {
        while(true){
            if(ticketNums<0)
                break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+": "+ticketNums--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web,"threadA").start();
        new Thread(web,"threadB").start();
        new Thread(web,"threadC").start();
    }
}
