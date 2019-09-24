import com.li.finance.AccountGroup;
import com.li.finance.BankAccount;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        /*
        BankAccount account = new BankAccount("1234", 500);
        account.deposit(250);
        saveAccount(account,"account.bat");
        BankAccount newAccount = loadAccount("account.bat");
        System.out.println(newAccount.getId()+" : "+newAccount.getBalance()+" TxType: "+newAccount.getLastTxType());

        BankAccount account1 = new BankAccount("9876",500);
        saveAccount(account1,"account1.dat");
        */
        BankAccount acct1 = new BankAccount("1234",500);
        BankAccount acct2 = new BankAccount("9876",750);

        AccountGroup group = new AccountGroup();
        group.addAccount(acct1);
        group.addAccount(acct2);
        saveGroup(group,"group.dat");
        AccountGroup testGroup = loadGroup("group.dat");
        System.out.println(testGroup.getTotalBalance());

    }

    static void saveAccount(BankAccount bankAccount, String fileName)  {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))){
            outputStream.writeObject(bankAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BankAccount loadAccount(String fileName){
        BankAccount bankAccount = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))){
           bankAccount = (BankAccount) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bankAccount;
    }

    static void saveGroup(AccountGroup group, String file) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(file)))) {
            outputStream.writeObject(group);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static AccountGroup loadGroup(String file) {
        AccountGroup group = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(file)))) {
            group = (AccountGroup) inputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return group;
    }
}
