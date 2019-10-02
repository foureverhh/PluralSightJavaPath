package wildcard_learning.bounded;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {

    private final RandomAccessFile file;

    public PersonLoader(final java.io.File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file,"rw");
    }
    public Person load() throws IOException {

        try {
            final String className = file.readUTF();
            final String personName = file.readUTF();
            final int age = file.readInt();

            final Class<?> personClass = Class.forName(className);
            System.out.println(className);
            final Constructor<?> constructor = personClass.getConstructor(String.class,int.class);
            System.out.println("constructor is: "+constructor);

            return (Person) constructor.newInstance(personName,age);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

    }

    //public void loadAll(final List<Person> people) throws IOException {
    public void loadAll(final List<? super Person> people) throws IOException {
        Person person;
        while((person = load())!=null) {
            people.add(person);
        }
    }
}
