package interfaceExample;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class App {
    public static void main(String[] args) {
        Flyable man = new Man();
        Flyable plane = new Plane();

        man.fly();
        plane.fly();
    }

}
