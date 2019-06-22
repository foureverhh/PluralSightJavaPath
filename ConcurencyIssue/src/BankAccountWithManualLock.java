public class BankAccountWithManualLock {
    private int balance;

    public BankAccountWithManualLock(int balance) {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }
}
