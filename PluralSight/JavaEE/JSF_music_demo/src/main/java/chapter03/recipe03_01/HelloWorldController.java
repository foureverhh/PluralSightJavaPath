package chapter03.recipe03_01;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "helloWorldController")
@RequestScoped
public class HelloWorldController {
    private String hello;

    public HelloWorldController() {
        System.out.println("Instantiated helloWorldController");
       /* hello = "hello world";*/
    }

    public HelloWorldController(String hello) {

    }

    @PostConstruct
    public void init() {
        System.out.println("Instantiated helloWorldController");
        hello = "hello world!!";
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
