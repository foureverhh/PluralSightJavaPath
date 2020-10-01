package common_dependency;

import java.util.Random;

public class IsbnGenerator {
    public String generateNumber(){
        return "13-84356-" + Math.abs(new Random().nextInt());
    }
}
