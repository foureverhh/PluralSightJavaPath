public class TransactionWorker implements Runnable {
    protected BankAccount account;
    protected char txType; //'w'-> withdraw, 'd'-> deposit
    protected int amount;

    public TransactionWorker(BankAccount account, char txType, int amount) {
        this.account = account;
        this.txType = txType;
        this.amount = amount;

    }

    @Override
    public void run() {
        switch (txType){
            case 'w':
                account.deposit(amount);
                break;
            case 'd':
                account.withdraw(amount);
                break;
            default:
                break;
        }
    }
}
