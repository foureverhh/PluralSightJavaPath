package sorting;

import model.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(final Person person1, final Person person2) {
        return Integer.compare(person1.getAge(),person2.getAge());
    }
}
