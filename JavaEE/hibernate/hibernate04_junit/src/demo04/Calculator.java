package demo04;

public class Calculator {
    public Integer add(Integer a, Integer b){
        if(a == null || b == null)
            return null;
        return a+b;
    }
}
