import java.lang.reflect.Modifier;

public class AccountWorkerTwo implements Runnable,TaskWorker {

    BankAccount bankAccount;

    @Override
    public void setTarget(Object target) {
        if (BankAccount.class.isInstance(target)) {
            bankAccount = (BankAccount) target;

        } else {
            try {
                throw new IllegalAccessException("Access exception");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doWork() {
        Thread t = new Thread(HighVolumeAccount.class.isInstance(bankAccount)?
                (HighVolumeAccount)bankAccount:this);
        t.start();
    }

    @Override
    public void run() {
        if(BankAccount.class.isInstance(bankAccount))
            System.out.println(bankAccount.getClass()+" is BankAccount");
        else
            System.out.println(bankAccount.getClass());
    }
}
