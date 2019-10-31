package foureverhh.upd.udp_obj;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name "+name+" and id "+id;
    }
}
