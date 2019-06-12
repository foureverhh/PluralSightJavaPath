public class MyClass {
    private String label, value;

    public MyClass(){

    }

    public MyClass(String label,String value){
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    //Make MyClass to find object by value not label
    public boolean equals(Object o){
        MyClass other = (MyClass) o;
        return getValue().equalsIgnoreCase(other.getValue());
    }
}
