public class FirstRunnable {
    public static void main(String[] args) {
        Runnable runnable = ()->{

            String thread = Thread.currentThread().getName();
            System.out.println("I am running in "+thread);
        };
        Thread t = new Thread(runnable);
        t.setName("My thead");
        t.start();
    }
}
