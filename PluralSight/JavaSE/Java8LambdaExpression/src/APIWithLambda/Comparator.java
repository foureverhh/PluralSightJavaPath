package APIWithLambda;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    static <T> Comparator<T> comparing(Function<T, Comparable> f) {
        return (p1,p2) -> f.apply(p1).compareTo(f.apply(p2));
    }

    default Comparator<T> thenComparing(Comparator<T> comparator){

        return (p1,p2) -> compare(p1,p2) == 0 ? comparator.compare(p1,p2) : compare(p1,p2);
    }

    default Comparator<T> thenComparing(Function<T,Comparable> f){
        //Comparator<T> cmp = comparing(f);
        return thenComparing(comparing(f));
    }

  /*  static Comparator<Person> comparing(Consumer<Person> f1) {
        return (p1,p2) -> Integer.compare(f1.accept(p1),f1.accept(p2));
    }*/
}
