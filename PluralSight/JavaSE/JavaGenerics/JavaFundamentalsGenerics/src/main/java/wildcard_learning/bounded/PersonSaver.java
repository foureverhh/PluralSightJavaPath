package wildcard_learning.bounded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {
    private final RandomAccessFile file;

    public PersonSaver (final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file,"rw");
    }

    public void save(Person person) throws IOException {

        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeInt(person.getAge());

    }

    //public void saveAll(Person[] people) throws IOException {
    //public void saveAll(List<? extends Person> people) throws IOException {
    public <T extends Person> void saveAll(List<T> people) throws IOException {
       for(Person person : people){
           save(person);
       }
    }
}
