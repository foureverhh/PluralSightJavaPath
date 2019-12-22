package APIWithLambda;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    static Comparator<Person> comparing(Function<Person, Comparable> f) {
        return (p1,p2) -> f.apply(p1).compareTo(f.apply(p2));
    }


  /*  static Comparator<Person> comparing(Consumer<Person> f1) {
        return (p1,p2) -> Integer.compare(f1.accept(p1),f1.accept(p2));
    }*/
}
