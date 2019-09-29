package collections;

import model.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExamples {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper",89);
        Person peggyOlson = new Person("Peggy Olson",65);
        Person bertCooper = new Person("Bert Cooper",100);

        Map<String, Person> madMen = new HashMap<String, Person>();
        madMen.put(donDraper.getName(),donDraper);
        madMen.put(peggyOlson.getName(),peggyOlson);
        madMen.put(bertCooper.getName(),bertCooper);


        System.out.println(madMen.get("Don Draper"));
        System.out.println(madMen);
        System.out.println();
        //Iteration of set

        //1. for-loop and keySet
        System.out.println();
        System.out.println("Iteration by keySet()");
        for(String key: madMen.keySet()){
            System.out.println(madMen.get(key));
        }

        //2. for-loop and values
        System.out.println();
        System.out.println("Iteration by values()");
        for(Person person : madMen.values()){
            System.out.println(person);
        }

        //3. iterator with Map.Entry<K,V>
        System.out.println();
        System.out.println("Iteration by iterator and Map.Entry<K,V>");
        Iterator<Map.Entry<String,Person>> iterator = madMen.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Person> entry = iterator.next();
            System.out.println("Key: "+entry.getKey()+" , Value: "+entry.getValue());
        }

        //4. for-loop with Map.Entry<K,V>
        System.out.println();
        System.out.println("Iteration by for-loop and Map.Entry<K,V>");
        for(Map.Entry<String,Person> entry: madMen.entrySet()){
            System.out.println("Key: "+entry.getKey()+" , Value: "+entry.getValue());
        }
    }

}
