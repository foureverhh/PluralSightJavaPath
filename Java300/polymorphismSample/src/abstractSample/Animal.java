package abstractSample;

public abstract class Animal {
    public abstract void run();
    public void breathe(){
        run();
        System.out.println(this.getClass().getSimpleName()+" needs to breathe!");
    }
    public Animal(){
        System.out.println("Construct an animal!");
    }
}

class Cat extends Animal{

    @Override
    public void run() {
        System.out.println("Cat runs");
    }
}

class Dog extends Animal{

    @Override
    public void run() {
        System.out.println("Dog runs");
    }

    public void dogBark(){
        System.out.println("Wang Wang");
    }
}
