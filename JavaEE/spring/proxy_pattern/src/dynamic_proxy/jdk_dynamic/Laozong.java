package dynamic_proxy.jdk_dynamic;

public class Laozong implements GongNeng{
    private String name;

    public Laozong() {
    }

    public Laozong(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void chifan() {
        System.out.println(name+"老总吃饭");
    }

    @Override
    public void mubiao() {
        System.out.println(name+"老总设定目标");
    }
}
