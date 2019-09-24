import java.lang.reflect.Modifier;

public final class LowVolumeAccount extends BankAccount implements Runnable {

    public LowVolumeAccount(String id) {
        super(id);
    }

    public LowVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    private int[] readDailyDeposits(){
        return new int[]{100, 200, 300};
    }

    private int[] readDailyWithdrawals(){
        return new int[]{10, 20 ,30};
    }

    @Override
    public void run() {
        for(int depositAmount: readDailyDeposits()){
            deposit(depositAmount);
        }
        for(int withdrawalAmount: readDailyWithdrawals()){
            withdrawal(withdrawalAmount);
        }
    }

    void typeModifiers(Object obj){
        Class<?> theClass = obj.getClass();
        int modifiers = theClass.getModifiers();
        if((modifiers & Modifier.FINAL) > 0)
            System.out.println("bitwise check - final");
        if(Modifier.isFinal(modifiers))
            System.out.println("method check - final");
        else if(Modifier.isProtected(modifiers))
            System.out.println("method check - protected");
        else if(Modifier.isPublic(modifiers))
            System.out.println("method check - public");
        System.out.println(Modifier.toString(modifiers));
    }
}
