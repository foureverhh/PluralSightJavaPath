public class Doer {

    private String name;

    public Doer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Deprecated
    void doItThisWay(){
        System.out.println(this.getName() + " is doing it this way!");
    }

    void doItThisNewWay(){
        System.out.println(this.getName() + " is doing it this new way!");
    }
}
