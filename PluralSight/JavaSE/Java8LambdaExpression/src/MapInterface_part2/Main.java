package MapInterface_part2;

import APIWithLambda.Person;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<City, List<Person>> map1 = new HashMap<>();
        Map<City, List<Person>> map2 = new HashMap<>();

        Person p1 = new Person("Alice",23);
        Person p2 = new Person("Brian",56);
        Person p3 = new Person("Chelsea",46);
        Person p4 = new Person("David",28);
        Person p5 = new Person("Erica",37);
        Person p6 = new Person("Francisco",18);

        List<Person> people = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));

        people.forEach(System.out::println);
        //people.removeIf(person -> person.getAge() > 30);

     /*   System.out.println("\nPeople younger than 30:");
        people.forEach(System.out::println);*/
        System.out.println();
        people.replaceAll(person -> new Person(person.getFirstName().toUpperCase(),person.getAge() ));
        people.forEach(System.out::println);

        System.out.println();
        people.sort(Comparator.comparing(Person::getAge));
        people.forEach(System.out::println);

        System.out.println();
        people.sort(Comparator.comparing(Person::getAge).reversed());
        people.forEach(System.out::println);


        City newYork = new City("New York");
        City shangHai = new City("Shanghai");
        City paris = new City("Paris");

        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shangHai,city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shangHai,city -> new ArrayList<>()).add(p3);

        System.out.println("map1:");
        map1.forEach((city,person) -> System.out.println(city + " : " + person));

        map2.computeIfAbsent(shangHai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris,city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris,city -> new ArrayList<>()).add(p6);
        System.out.println("map2:");
        map2.forEach((city,person) -> System.out.println(city + " : " + person));
        map1.forEach
        (
                (
                        (key, value) -> map2.merge
                                (key,value,(exitingPeople, newPeople)->{
                                    exitingPeople.addAll(newPeople);
                                    return exitingPeople;
                                }
                        )
                )
        );
      /*  System.out.println("new map1:");
        map1.forEach((city,person) -> System.out.println(city + " : " + person));*/
        System.out.println("new map2:");
        map2.forEach((city,person) -> System.out.println(city + " : " + person));
    /*
        Map<City,List<Person>> map = new HashMap<>();
        map.putIfAbsent(paris,new ArrayList<>());
        //System.out.println("People from Paris: " + map.get(paris));
        System.out.println("People from Paris: " + map.getOrDefault(paris,Collections.EMPTY_LIST));
        System.out.println("People from Paris: " + map.get(paris));
        map.putIfAbsent(paris,new ArrayList<>(Arrays.asList(p1,p2)));
        System.out.println("People from Paris: " + map.get(paris));

        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);
        System.out.println("People from New York: " + map.get(newYork));*/


      /*  map2.forEach(
                (key ,value) -> map1.merge(key,value,(exitingPeople,newPeople) -> {
                    exitingPeople.addAll(newPeople);
                    return exitingPeople;
                })
        );*/
    }
}
