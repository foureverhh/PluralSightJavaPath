package IOObjectStream.demo;

import IOObjectStream.Employee;

import java.io.*;

public class demo01 {
    public static void main(String[] args) {
        serializable("textFiles/ObjectStreamSample.txt");
        Employee e = deserializable("textFiles/ObjectStreamSample.txt");
        System.out.println(e);
    }

    public static void serializable(String filePath){
        Employee employee = new Employee("employee",1000);

        try {
            ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
            dos.writeObject(employee);
            dos.flush();
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Employee deserializable(String filePath){
        Employee employee = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)));
            employee = (Employee) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
