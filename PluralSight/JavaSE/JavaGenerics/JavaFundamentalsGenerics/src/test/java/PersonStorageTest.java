import org.junit.Assert;

import org.junit.Test;
import wildcard_learning.bounded.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class PersonStorageTest {
    private Partner donDraper = new Partner("Don Draper",89);
    private Partner bertCooper = new Partner("Bert Cooper",100);
    private Employee peggyOlson = new Employee("Peggy Olson",65);

    private File file = new File("generics.txt");
    private PersonSaver saver = new PersonSaver(file);
    private PersonLoader loader = new PersonLoader(file);

    public PersonStorageTest() throws FileNotFoundException {
    }

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
        persons.add(bertCooper);
        saver.saveAll(persons);
        Assert.assertEquals(donDraper,loader.load());
        Assert.assertEquals(bertCooper,loader.load());
    }


    @Test
    public void loadsListOfPeople() throws IOException {
        saver.save(donDraper);
        saver.save(peggyOlson);
        //List<Person> people = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        loader.loadAll(people);
        assertEquals(donDraper,people.get(0));
        assertEquals(peggyOlson,people.get(1));
    }
}
