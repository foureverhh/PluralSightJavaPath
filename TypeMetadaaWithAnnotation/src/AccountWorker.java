@WorkHandler(useThreadPool = false)

public class AccountWorker implements Runnable,TaskWorker {

    BankAccount ba;

    @Override
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target))
            ba = (BankAccount)target;
        else
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void doWork() {
        Thread t = new Thread(HighVolumeAccount.class.isInstance(ba) ? (HighVolumeAccount) ba : this);
        t.start();
    }

    @Override
    public void run() {
        if(BankAccount.class.isInstance(ba))
            System.out.println(ba.getClass()+" is BankAccount");
        else
            System.out.println(ba.getClass());
    }
}
