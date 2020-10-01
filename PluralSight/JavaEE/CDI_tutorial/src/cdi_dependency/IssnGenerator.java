package cdi_dependency;

import java.util.Random;

public class IssnGenerator implements LabelGenerator {
    @Override
    public String generateLabel() {
        return "ISSN-13-84356-" + Math.abs(new Random().nextInt());
    }
}
