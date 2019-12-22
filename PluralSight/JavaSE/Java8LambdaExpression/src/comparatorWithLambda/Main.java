package comparatorWithLambda;

import com.sun.codemodel.internal.JForEach;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] strings1 = {"asds","asdjfkl","as","kasdfljal;sdf","dsdsasf"};
        String[] strings2 = {"asds","asdjfkl","as","kasdfljal;sdf","dsdsasf"};
        Comparator<String> comparatorA = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        Arrays.sort(strings1,comparatorA);
        for(String string : strings1){
            System.out.print(string + " , ");
        }
        System.out.println();
        //Comparator<String> comparatorB = (String s1, String s2) -> {
        Comparator<String> comparatorB = (s1, s2) -> {
            System.out.println("This is inside comparator. s1-> " + s1 + " , s2-> " + s2);
            return Integer.compare(s1.length(),s2.length());
        };
        Arrays.sort(strings2,comparatorB);
        for(String string : strings2){
            System.out.print(string + " , ");
        }
    }

}
