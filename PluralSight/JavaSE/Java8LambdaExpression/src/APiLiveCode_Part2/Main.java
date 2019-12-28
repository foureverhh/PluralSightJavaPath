package APiLiveCode_Part2;

public class Main {
    public static void main(String[] args) {
        MyPredicate<String> p1 = s -> s.length() < 20;
        System.out.println(p1.test("hha"));

        MyPredicate<String> p2 = s -> s.length() > 5;
        MyPredicate<String> p3 = p1.and(p2);
        System.out.println(p3.test("123"));

        MyPredicate<String> p4 = p1.or(p2);
        System.out.println("p4: " + p4.test("345"));

        MyPredicate<String> p5 = MyPredicate.isEqualTo("Hello");
        System.out.println(p5.test("hello!"));
    }
}
