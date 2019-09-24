import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BankAccount {
    private final String id ;
    private int balance = 0;

    public BankAccount(String id) {
        this.id = id;
    }

    public BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId(){
        return id;
    }

    public synchronized int getBalance(){
        return balance;
    }

    public synchronized void deposit(int amount){
        balance += amount;
    }

    public synchronized void withdrawal (int amount){
        balance -= amount;
    }

    void fieldInfo(Object obj){
        Class<?> theClass = obj.getClass();
        Field[] fields = theClass.getFields();
        Field[] declaredFields = theClass.getDeclaredFields();
        System.out.println("getFields:");
        printFieldItems(fields);
        System.out.println();
        System.out.println("get DeclaredFields");
        printFieldItems(declaredFields);

    }

    private void printFieldItems(Field[] fields){
        for(Field field : fields){
            System.out.println(field.getName()+" : "+field.getType());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println();
        }
    }

    void methodInfo(Object obj){
        Class<?> theClass = obj.getClass();

        System.out.println("getMethods:");
        Method[] methods = theClass.getMethods();
        printMethodItems(methods);
        System.out.println("getDeclaredMethods:");
        Method[] declaredMethods = theClass.getDeclaredMethods();
        printMethodItems(declaredMethods);

    }

    private void printMethodItems(Method[] methods){
        for(Method method:methods){
            System.out.println(method.getName() + " has modifiers: "+ Modifier.toString(method.getModifiers()));
            System.out.println(method.getName()+ " has parameter type: " + method.getTypeParameters());
            System.out.println(method.getName()+ " has return type: "+ method.getReturnType());
            System.out.println();
        }
    }

    void callGetId(Object object){
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

    void callDeposit(Object object, int amount){
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
}
