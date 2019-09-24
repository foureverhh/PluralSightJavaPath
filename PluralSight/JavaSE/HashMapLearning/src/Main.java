import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        //testMutableKey();
        Console console = System.console();
        testMutableKey();
    }

    static void testMutableKey(){
        Map<MutableString, String> brokenMap = new HashMap<>();
        String value = "abc";
        MutableString key = new MutableString(value);
        brokenMap.put(key,value);

        System.out.println(brokenMap.get(key));
        System.out.println(brokenMap);

        key.set("def");

        System.out.println(brokenMap.get(key));
        System.out.println(brokenMap);
    }
}

class MutableString{
    private String value;

    public MutableString(String value){
        set(value);
    }

    public void set(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    String get(){
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj == null || this.getClass()!=obj.getClass()) return false;
        MutableString str = (MutableString) obj;
        return value.equals(str.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
