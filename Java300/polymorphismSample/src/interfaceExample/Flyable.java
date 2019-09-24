package interfaceExample;

public interface Flyable {
    int MAX_SPEED = 100;
    int MIN_HEIGHT =1;

    void fly();
}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("Fly by engine");
    }
}

class Man implements Flyable{

    @Override
    public void fly() {
        System.out.println("Fly by jumping");
    }
}
