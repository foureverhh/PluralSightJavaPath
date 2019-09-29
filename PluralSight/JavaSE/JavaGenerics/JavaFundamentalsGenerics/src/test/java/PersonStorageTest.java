import org.junit.Assert;
import org.junit.Test;
import wildcard_learning.bounded.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonStorageTest {
    private Partner donDraper = new Partner("Don Draper",89);
    private Partner bertCooper = new Partner("Bert Cooper",100);
    private Employee peggyOlson = new Employee("Peggy Olson",65);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Test
    public void savesAndLoadsPerson() throws IOException {
        Person person = new Person("Bob",20);
        saver.save(person);
        Assert.assertEquals(person,loader.load());
    }

    @Test
    public void savesAndLoadsArraysOfPeople() throws IOException {
       /*
        Person[] persons = new Person[2];
        persons[0] = donDraper;
        persons[1] = bertCooper;
        */
        List<Person> persons = new ArrayList<>();
        persons.add(donDraper);
        persons.add(bertCooper)
        saver.saveAll(persons);
        Assert.assertEquals(donDraper,loader.load());
        Assert.assertEquals(bertCooper,loader.load());
    }
}
