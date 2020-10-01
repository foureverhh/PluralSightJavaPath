package pojo.people_factory;

public class PeopleFactoryStatic {
    public static People getInstance(){
        return new People(2,"Static factory instance");
    }
}
