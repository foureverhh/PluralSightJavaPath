package sorting;

import model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {
    public static void main(String[] args) {
        /*
        //Sort descending
         final Comparator<Person> descendingAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.getAge(),o2.getAge());
            }
        };


        Person donDraper = new Person("Don Draper",89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        System.out.println(madMen);
        //Sort ascending
        Comparator<Person> ascendingComparator = new AgeComparator();
        Collections.sort(madMen,ascendingComparator);
        System.out.println();
        System.out.println("Ascending order");
        System.out.println(madMen);
        //Sort descending
        ReverseComparator<Person> descendingComparator = new ReverseComparator<>(ascendingComparator);
        //Collections.sort(madMen,descendingAge);
        Collections.sort(madMen,descendingComparator);
        System.out.println();
        System.out.println("Descending order");
        System.out.println(madMen);

         */
    }

}
