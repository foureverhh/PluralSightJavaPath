package pojo.people_factory;

public class PeopleFactoryInstance {
    public People newInstance(){
        return new People(1,"spring instance");
    }

    public static People getInstance(){
        return new People(3,"static instance");
    }

}
