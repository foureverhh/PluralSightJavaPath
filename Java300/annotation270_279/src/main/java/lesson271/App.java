package lesson271;

public class App {
    public static void main(String[] args) {

    }

    @MyAnnotation(age=19,studentName = "小明",schools={"北航","上交"})
    public static void test(){
        System.out.println("For test");
    }
}
