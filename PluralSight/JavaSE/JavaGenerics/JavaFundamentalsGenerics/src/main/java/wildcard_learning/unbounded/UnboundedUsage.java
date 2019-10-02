package wildcard_learning.unbounded;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class UnboundedUsage {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Person("Don Draper",89));
        System.out.println(objects);
    }
}
