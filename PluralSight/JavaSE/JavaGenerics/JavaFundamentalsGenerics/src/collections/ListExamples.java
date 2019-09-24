package collections;

import model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListExamples {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper",89);
        Person peggyOlson = new Person("Peggy Olson",65);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);

        System.out.println(madMen);

        madMen.add(new Person("Bert Cooper", 100));
        System.out.println(madMen);

        Iterator<Person> iterator = madMen.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            if (person.equals(new Person("Bert Cooper", 100))){
                iterator.remove();
            }
            System.out.println(person);
        }

        System.out.println(madMen.size());

    }
}
