package pojo.people_factory;

public class PeopleFactory {
    public People createPeople(String type){
        switch (type){
            case "A":
                return new A();
            case "B":
                return new B();
            default:
                return null;
        }
    }
}
