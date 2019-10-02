package wildcard_learning.bounded;

import java.util.Objects;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        Objects.requireNonNull(name);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
       /* if(obj == null || getClass()!= obj.getClass())
            return false;*/
        Person another = (Person) obj;
        return name.equals(another.getName()) && age == Integer.valueOf(another.getAge());
    }
}
