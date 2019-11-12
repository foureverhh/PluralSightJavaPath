package server_basic.web;

public class Entity {
    private String name;
    private String clz;

    public Entity() {
    }

    public Entity(String name, String clz) {
        this.name = name;
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public String getClz() {
        return clz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    @Override
    public String toString() {
        return name+" "+clz;
    }
}
