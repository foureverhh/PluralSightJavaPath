package thread_demo;

import utils.DownLoadImage;

//198.......

public class StartThread extends Thread {
    public static void main(String[] args) {
        DownLoadImage purple = new DownLoadImage("https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?cs=srgb&dl=nature-red-love-romantic-67636.jpg&fm=jpg","purple.jpg");
        DownLoadImage red = new DownLoadImage("https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?cs=srgb&dl=bloom-blossom-dahlia-60597.jpg&fm=jpg","red.jpg");
        DownLoadImage pink = new DownLoadImage("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?cs=srgb&dl=flor-flower-garden-736230.jpg&fm=jpg","pink.jpg");
        Thread thread = new Thread(purple);
        thread.start();

        thread = new Thread(red);
        thread.start();

        thread = new Thread(pink);
        thread.start();
  /*      Thread thread = new StartThread();
        //start() 不能保证线程立刻开始
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("Coding");
        }
        */
        //
    }
    @Override
    public void run() {
        /*for (int i = 0; i <20 ; i++) {
            System.out.println("Listening to music");
        }*/
    }
}
