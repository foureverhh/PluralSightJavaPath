public class HighVolumeAccount extends BankAccount implements Runnable {

    public HighVolumeAccount(String id){
        super(id);
    }

    public HighVolumeAccount(String id, int balance){
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
        for(int depositAmount : readDailyDeposits()){
            deposit(depositAmount);
        }
        for(int withdrawalAmount : readDailyWithdrawals()){
            withdrawal(withdrawalAmount);
        }
    }

    void classInfo(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName());

        Class<?> superClass = theClass.getSuperclass();
        System.out.println(superClass.getSimpleName());

        Class<?>[] interfaces = theClass.getInterfaces();
        for(Class<?> interfaceItem:interfaces){
            System.out.println(interfaceItem.isInterface());
            System.out.println(interfaceItem.getSimpleName());
        }
    }


}
