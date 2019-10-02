package covariance_contravariance;


    class Fruit {}
    class Apple extends Fruit {}
    class Jonathan extends Apple {}
    class Orange extends Fruit {}

    public class CovariantArrays {
        public static void main(String[] args) {
            Fruit[] fruit = new Apple[10];
            fruit[0] = new Apple();
            fruit[1] = new Jonathan();
            System.out.println(fruit[0].getClass().getSimpleName());
            System.out.println(fruit[1].getClass().getSimpleName());
            try {
                fruit[0] = new Fruit();
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                fruit[0] = new Orange();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

