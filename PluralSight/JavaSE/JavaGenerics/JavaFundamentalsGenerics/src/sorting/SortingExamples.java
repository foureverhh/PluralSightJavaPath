package sorting;

import model.Person;

import java.util.*;

public class SortingExamples<T,S> {

    public static void main(String[] args) {

        Person donDraper = new Person("Don Draper",89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        final Person youngestCastMember = min(madMen, new AgeComparator());
        System.out.println(youngestCastMember);

        /*
        //Sort descending
         final Comparator<Person> descendingAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.getAge(),o2.getAge());
            }
        };




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

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println(min(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        }));
    }

   public static <T> T min(List<T> values,Comparator<T> comparator){

        if( Objects.isNull(values) || values.isEmpty()){
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }

        T lowestElement = values.get(0);
        for(int i = 1;i<values.size();i++){
            final T element = values.get(i);
            if(comparator.compare(element,lowestElement)<0){
                lowestElement = element;
            }
        }
        return lowestElement;
   }



}
