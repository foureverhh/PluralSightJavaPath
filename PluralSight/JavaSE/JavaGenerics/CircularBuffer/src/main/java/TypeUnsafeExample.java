public class TypeUnsafeExample {
    public static void main(String[] args) {
        CircularBuffer<String> buffer = new CircularBuffer<String>(10);
        //StringCircularBuffer buffer = new StringCircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        //buffer.offer(1);

        String value = concatenate(buffer);
        System.out.println(value);
    }

    public static String concatenate(CircularBuffer<String> buffer){
        StringBuffer result = new StringBuffer();
        String value;
        //while((value=(String)buffer.poll())!=null){
        while((value = buffer.poll())!=null){
            result.append(value);
        }
        return result.toString();
    }
}
