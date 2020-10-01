package interface_dependency;

import java.util.Random;

public class IsbnGenerator implements LabelGenerator {

    @Override
    public String generateLabel() {
        return "ISBN-13-84356-" + Math.abs(new Random().nextInt());
    }
}
