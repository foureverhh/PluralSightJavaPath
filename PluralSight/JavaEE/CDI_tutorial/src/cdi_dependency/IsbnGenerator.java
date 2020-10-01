package cdi_dependency;

import java.util.Random;
@ISBN
public class IsbnGenerator implements LabelGenerator {

    @Override
    public String generateLabel() {
        return "ISBN-13-84356-" + Math.abs(new Random().nextInt());
    }
}
