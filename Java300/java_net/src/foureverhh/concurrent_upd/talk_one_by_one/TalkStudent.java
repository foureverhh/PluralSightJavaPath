package foureverhh.concurrent_upd.talk_one_by_one;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class TalkStudent {
    public static void main(String[] args) {
        //Student receive on port 6666, send to teacher 7777





        Thread studentSend = new Thread(new TalkSend(7777,6666));

        studentSend.start();

        Thread studentReceive = new Thread(new TalkReceive("Teacher",8888));
        studentReceive.start();

    }
}
