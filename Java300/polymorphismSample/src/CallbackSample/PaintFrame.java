package CallbackSample;

public class PaintFrame {
    public static void drawFrame(IMyFrame f){
        System.out.println("启动线程");
        System.out.println("增加循环");
        System.out.println("查看消息线");
        //画窗口
        f.paint();
        System.out.println("启动缓存，增加效率");
    }

    public static void main(String[] args) {
        IMyFrame frame1 = new GameFrame1();
        drawFrame(frame1);

        IMyFrame frame2 = new GameFrame2();
        drawFrame(frame2);

    }
}

class GameFrame1 implements IMyFrame{
    @Override
    public void paint() {
        System.out.println("Game Frame painting");
        System.out.println("画窗口");
    }
}

class GameFrame2 implements IMyFrame{

    @Override
    public void paint() {

    }
}