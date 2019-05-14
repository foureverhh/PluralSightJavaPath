public class Hello {
    public static void main(String[] args){
        ReverseString testString = new ReverseString("Hello");
        System.out.println(testString.getOriginString());
        System.out.println(testString.reverse());
    }
}
