package APIWithLambda;

import java.util.function.Consumer;
import java.util.function.Function;

public class MainComparator {
    public static void main(String[] args) {
        Comparator<Person> cmpAge = (p1, p2)-> Integer.compare(p1.getAge(),p2.getAge());
        Comparator<Person> cmpFirstName = (p1, p2)-> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2)-> p1.getLastName().compareTo(p2.getLastName());

        Function<Person, Integer> f1 = person -> person.getAge();
        //Consumer<Person> f1 = Person::getAge;

        Function<Person, String> f2 = person -> person.getFirstName();
        Function<Person, String> f3 = person -> person.getLastName();

        //Comparator<Person> compPerson = Comparator.comparing(f1);
        Comparator<Person> compPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> compPersonFirstName = Comparator.comparing(Person::getAge);
        Comparator<Person> compPersonLastName = Comparator.comparing(Person::getAge);
    }
}
