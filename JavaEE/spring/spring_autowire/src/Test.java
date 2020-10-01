import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
        People people = ac.getBean("people",People.class);
        People people1 = ac.getBean("people1",People.class);
        System.out.println(people);
        System.out.println(people1);
        */
        /*
        //bean标签对应的对象，默认是单例的
        Teacher teacher1_1 = ac.getBean("teacher1",Teacher.class);
        Teacher teacher1_2 = ac.getBean("teacher1",Teacher.class);
        System.out.println(teacher1_1==teacher1_2);
        */
    }
}
