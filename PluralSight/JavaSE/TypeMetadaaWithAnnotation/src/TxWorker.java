public class TxWorker implements Runnable{

    protected BankAccount account;
    protected char txType;
    protected int amount;

    public TxWorker(BankAccount account, char txType, int amount) {
        this.account = account;
        this.txType = txType;
        this.amount = amount;
    }

    @Override
    public void run(){
        if(txType == 'w') {
            account.withdrawal(amount);
        }else if(txType == 'd'){
            account.deposit(amount);
        }
    }

}
