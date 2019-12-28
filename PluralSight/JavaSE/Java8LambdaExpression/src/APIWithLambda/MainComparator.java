package APIWithLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainComparator {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jame","King",42));
        personList.add(new Person("Lars","Svensson",32));
        personList.add(new Person("Adam","Smith",67));

        Person[] people = {
                           new Person("Jame","King",42),
                           new Person("Lars","Svensson",32),
                           new Person("Adam","Smith",67)
                           };
        Comparator<Person> cmpAge = (p1, p2)-> Integer.compare(p1.getAge(),p2.getAge());
        Comparator<Person> cmpFirstName = (p1, p2)-> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2)-> p1.getLastName().compareTo(p2.getLastName());

        Function<Person, Integer> f1 = person -> person.getAge();
        //Consumer<Person> f1 = Person::getAge;

        Function<Person, String> f2 = person -> person.getFirstName();
        Function<Person, String> f3 = person -> person.getLastName();

        //Comparator<Person> compPerson = Comparator.comparing(f1);
        Comparator<Person> compPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> compPersonFirstName = Comparator.comparing(Person::getFirstName);
        Comparator<Person> compPersonLastName = Comparator.comparing(Person::getLastName);

        Comparator<Person> cmp = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getAge)
                .thenComparing(Person::getFirstName);
                //compPersonAge.thenComparing(f1);
    }
}
