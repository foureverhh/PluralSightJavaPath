package Queue;

public class Customer {
    private String name;
    public static final Customer JACK = new Customer("Jack");
    public static final Customer JILL = new Customer("Jill");
    public static final Customer MARY = new Customer("Mary");

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public void reply(String message){
        System.out.printf("%s: %s\n",name,message);
    }
}
