package collections;

import model.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExamples {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper",89);
        Person peggyOlson = new Person("Peggy Olson",65);
        Person bertCooper = new Person("Bert Cooper",100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(donDraper);

        System.out.println("Person in list:");
        for(Person person:madMen){
            System.out.println(person);
        }

        System.out.println();

        System.out.println("Person in set:");
        Set<Person> personSet = new HashSet<>();
        personSet.add(donDraper);
        personSet.add(peggyOlson);
        personSet.add(donDraper);
        for(Person person:personSet){
            System.out.println(person);
        }

        System.out.println(personSet.contains(donDraper));
        System.out.println(personSet.contains(bertCooper));
    }
}
