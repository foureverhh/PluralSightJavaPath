public class WorkerWithManualLock implements Runnable{

    private BankAccountWithManualLock account;

    public  WorkerWithManualLock(BankAccountWithManualLock account)
    {
     this.account = account;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            int startBalance = account.getBalance();
            synchronized (account) {
                account.deposit(10);
            }
            int endBalance = account.getBalance();
            System.out.println("Start balance: "+ startBalance + ". End balance: " + endBalance + ". Worker: "+
                    Thread.currentThread().getName());
        }
    }
}
