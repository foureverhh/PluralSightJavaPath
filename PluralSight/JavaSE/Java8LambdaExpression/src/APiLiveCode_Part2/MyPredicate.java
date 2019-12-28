package APiLiveCode_Part2;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);

    default MyPredicate<T> and(MyPredicate<T> otherMyPredicate){
        return t -> this.test(t) && otherMyPredicate.test(t);
    }

    default MyPredicate<T>  or(MyPredicate<T> p2){
        return t-> this.test(t) || p2.test(t);
    }

    static <U> MyPredicate<U> isEqualTo(U u){
        return s -> s.equals(u);
    }
}
