package test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Airport;
import pojo.ioc_property.Property;
import pojo.people_factory.People;
import pojo.people_factory.PeopleFactory;
import service.AirportService;
import service.impl.AirportServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
     /*   People people = ac.getBean("peo", People.class);
        System.out.println(people);*/
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

     /*   //实例工厂，先创建工厂，才能生产对象
        //传统方式
        PeopleFactory factory = new PeopleFactory();
        People p1 = factory.createPeople("A");
        System.out.println(p1.getClass().getSimpleName());
        System.out.println("Spring instance factory");
        //spring ioc方式 bean id=factory and bean id=peo1
        People peo1= ac.getBean("peo1",People.class);
        System.out.println(peo1);

        //静态工厂，不需创建工厂，就可以创建对象
        People peo2 = ac.getBean("peo2",People.class);
        System.out.println(peo2);
        People peo3 = ac.getBean("peo3",People.class);
        System.out.println(peo3);

        //赋值property
        Property property1 = ac.getBean("property1",Property.class);
        System.out.println(property1);
        System.out.println(property1.getStrings().length);
        System.out.println(property1.getWords().size());*/

        AirportService service = ac.getBean("airportService", AirportServiceImpl.class);
        List<Airport> airports = service.showAll();
        for (Airport airport: airports) {
            System.out.println(airport);
        }


    }
}
