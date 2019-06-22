public class TxPromoWorker extends TransactionWorker {

    public TxPromoWorker(BankAccount account, char txType, int amount) {
        super(account, txType, amount);
    }

    @Override
    public void run() {

        switch (txType){
            case 'w':
                account.withdraw(amount);
                break;
            case 'd':
                synchronized (account) {
                    account.deposit(amount);
                    if (account.getBalance() > 500) {
                        int bonus = (int) ((account.getBalance() - 500) * 0.1);
                        account.deposit(bonus);
                    }
                }
                break;
            default:
                break;
        }
    }
}
