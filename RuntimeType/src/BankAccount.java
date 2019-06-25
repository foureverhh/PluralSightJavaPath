import java.lang.reflect.Field;
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

    void printFieldItems(Field[] fields){
        for(Field field : fields){
            System.out.println(field.getName()+" : "+field.getType());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println();
        }
    }
}
