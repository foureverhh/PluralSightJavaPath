package static_proxy.com.bjsxt.pojo;

public class LaoZong implements Gongneng{
    private String name;
    @Override
    public void target(){
        System.out.println("lao zong set target!");
    }

    @Override
    public void chifan() {
        System.out.println("老总出席饭局");
    }

    public LaoZong() {
    }

    public LaoZong(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
