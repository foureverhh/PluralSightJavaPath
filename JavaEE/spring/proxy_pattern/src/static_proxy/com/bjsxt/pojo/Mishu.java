package static_proxy.com.bjsxt.pojo;

public class Mishu implements Gongneng{
    private LaoZong laoZong = new LaoZong("马云");

    @Override
    public void target() {
        System.out.println("马总到了");
        laoZong.target();
        System.out.println("秘书做了会议记录");
    }

    @Override
    public void chifan() {
        System.out.println("秘书安排饭局");
        laoZong.chifan();

    }
}
