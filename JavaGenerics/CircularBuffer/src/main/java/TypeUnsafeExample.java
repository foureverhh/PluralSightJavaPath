public class TypeUnsafeExample {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        buffer.offer(1);

        String value = concatenate(buffer);
        System.out.println(value);
    }

    public static String concatenate(CircularBuffer buffer){
        StringBuffer result = new StringBuffer();
        String value;
        while((value=(String)buffer.poll())!=null){
            result.append(value);
        }
        return result.toString();
    }
}
