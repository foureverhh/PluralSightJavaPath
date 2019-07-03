import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BankAccount implements Serializable {
    private final String id;
    private int balance = 0;

    public BankAccount(String id){
        this.id = id;
    }

    public BankAccount(String id, int balance){
        this.id = id;
        this.balance = balance;
    }

    // other members elided
    void deposit(int amount){
        balance += amount;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }
}
