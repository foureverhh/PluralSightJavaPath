package wildcard_learning.bounded;

import java.io.*;

public class PersonLoader {

    private final RandomAccessFile file;

    public PersonLoader(final java.io.File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file,"rw");
    }
    public Person load() throws IOException {

        String className = file.readUTF();
        String personName = file.readUTF();
        int age = file.readInt();
        return new Person(personName,age);
    }
}
