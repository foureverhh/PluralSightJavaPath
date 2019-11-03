package foureverhh.concurrent_upd.talk_one_by_one;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TalkTeacher {
    public static void main(String[] args) {
        //Teacher receives on port 7777, send to student 6666
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

        Thread teacherReceive = new Thread(new TalkReceive("Student",6666));

        Thread teacherSend = new Thread(new TalkSend(9999,8888));
        teacherReceive.start();
        teacherSend.start();
    }
}
