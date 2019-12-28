package functionsWithLambda;

import APIWithLambda.Person;
import functionsWithLambda.predicate.Predicate;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Client {
    public static void main(String[] args) {
        //Predicate in JDK7 way
        Predicate<String> p_7 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 20;
            }
        };

        //Predicate in Lambda
        Predicate<String> p_8 = s -> s.length() < 5;
        System.out.println(p_7.test("Hello world"));
        System.out.println(p_8.test("Hello world"));

        //Consumer functional interface
        Consumer<String> printer= System.out::println;
        printer.accept("Hello world");
        printer =  s ->{
            s = s + ", this is printer";
            System.out.println(s);
        };
        printer.accept("hahaha  ");

        //Supplier functional interface
        //Supplier with String
        Supplier<String> supplier = () -> "I am supplier";
        //Supplier with Person
        Supplier<Person> personDavid = () -> new Person("David","Svensson",42);
                         //personSupplier = Person::new;

        //Test BiConsumer
        BiConsumer<Person,Integer> personIntegerBiConsumer = (person,age) -> System.out.println(person.getLastName() + age);
        personIntegerBiConsumer.accept(personDavid.get(),personDavid.get().getAge());

        //Functions
    }
}
