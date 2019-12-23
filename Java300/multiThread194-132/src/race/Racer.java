package race;

public class Racer implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            if(Thread.currentThread().getName().equals("Rabbit") && steps%10==0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(Thread.currentThread().getName().equals("Turtle")) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            if(gameOver(steps))
                break;
        }
    }

    private boolean gameOver(int steps){
        if(winner!=null){
            return true;
        }else {
            if(steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner --->"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"Turtle").start();
        new Thread(racer,"Rabbit").start();
    }
}
