import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

        //Test getMethods() and getDeclaredMethods()
        System.out.println();
        account2.methodInfo(account2);


        System.out.println();
        System.out.println("callGetId");
        account1.callGetId(account1);
        System.out.println();
        System.out.println("callDeposit");
        account1.callDeposit(account1, 200);
        System.out.println(account1.getBalance());

        callGetId(account1);
        callDeposit(account1,50);
        System.out.println(account1.getBalance());
    }

    static void callGetId(Object object){
        Class<?> theClass = object.getClass();
        try {
            Method m = theClass.getMethod("getId");
            Object result = m.invoke(object);
            System.out.println("Result: "+result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    static void callDeposit(Object object, int amount){
        Class<?> theClass = object.getClass();
        try {
            Method method = theClass.getMethod("deposit",int.class);
            method.invoke(object, amount);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static void startWorker(String workerTypeName, Object workerTarget){
        try {
            //Get class for workerType
            Class<?> workerType = Class.forName(workerTypeName);

            //Make an instance of workerType
            Class<?> targetType = workerTarget.getClass();
            Constructor constructor = workerType.getConstructor(targetType);
            Object worker = constructor.newInstance(workerTarget);

            //Invoke a special method on the instance
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
