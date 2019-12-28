package comparisonBetweenComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //Laptop with Comparable<T> interface
        List<LaptopA> laptopAs = new ArrayList<>();
        laptopAs.add(new LaptopA("Dell",16,800));
        laptopAs.add(new LaptopA("Apple",8,1200));
        laptopAs.add(new LaptopA("Acer",12,700));

        Collections.sort(laptopAs);
        System.out.println("Comparable interface");
        System.out.println(laptopAs);

        //Laptop with Comparator interface
        List<LaptopB> laptopBs = new ArrayList<>();
        laptopBs.add(new LaptopB("Dell",16,800));
        laptopBs.add(new LaptopB("Apple",8,1200));
        laptopBs.add(new LaptopB("Acer",12,700));
        //Collections.sort(laptopBs, (laptopB1,laptopB2) -> laptopB1.getRam() - laptopB2.getRam());
        Collections.sort(laptopBs, Comparator.comparing(LaptopB::getBrand));
        System.out.println("Comparator interface");
        System.out.println(laptopBs);
    }
}
