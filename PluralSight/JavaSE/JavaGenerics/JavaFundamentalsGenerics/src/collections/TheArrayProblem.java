package collections;

import model.Person;

import java.util.Arrays;

public class TheArrayProblem {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper",89);
        Person peggyOlson = new Person("Peggy Olson",65);

        Person[] madMan = {donDraper, peggyOlson};
        System.out.println(Arrays.toString(madMan));

        Person bertCooper = new Person("Bert Cooper",110);
        madMan = add(bertCooper, madMan);
        madMan[2] = bertCooper;
        System.out.println(madMan);
    }

    private static Person[] add(final Person person, Person[] array) {
        final int length= array.length;
        array = Arrays.copyOf(array,array.length+1);
        array[length] = person;
        return array;
    }
}
