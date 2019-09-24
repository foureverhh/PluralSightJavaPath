public class AccountWorker implements Runnable{

    BankAccount bankAccount;
    HighVolumeAccount highVolumeAccount;

    public AccountWorker(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    public AccountWorker(HighVolumeAccount highVolumeAccount){
        this.highVolumeAccount = highVolumeAccount;
    }

    public void doWork(){
        Thread t = new Thread(highVolumeAccount != null ? highVolumeAccount : this);
        t.start();
    }


    @Override
    public void run() {
       if(highVolumeAccount != null)
           highVolumeAccount.deposit(100);
       else
           bankAccount.deposit(100);
    }


}
