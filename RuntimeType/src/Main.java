public class Main {

    public static void main(String[] args) {
        //Test Class<T> class
        BankAccount account1 = new BankAccount("1234");
        BankAccount account2 = new BankAccount("5678", 100);

        Class<?> c1 = BankAccount.class;
        System.out.println("c1: "+c1.getSimpleName());

        try{
            Class<?> c2 = Class.forName("BankAccount");
            System.out.println("c2: "+c2.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<BankAccount> c3 = BankAccount.class;
        System.out.println("c3: "+c3.getSimpleName());

        String c4 = account1.getClass().getSimpleName();
        System.out.println("c4: "+c4);

        //Test interface and class
        HighVolumeAccount highVolumeAccount = new HighVolumeAccount("1234",100);
        highVolumeAccount.classInfo(highVolumeAccount);

        //Test modifiers
        LowVolumeAccount lowVolumeAccount = new LowVolumeAccount("4567");
        lowVolumeAccount.typeModifiers(lowVolumeAccount);

        //Test getFields() and getDeclaredFields()
        System.out.println();
        account2.fieldInfo(account2);
    }
}
