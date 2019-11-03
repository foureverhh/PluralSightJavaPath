package foureverhh.upd.ip_port_url;

import java.io.*;
import java.net.URL;

public class SpiderTest01 {
    public static void main(String[] args) {
        try {
            //Obtain URL
            URL jd = new URL("https://www.jd.com");
            URL dp = new URL("https://www.dianping.com");
            //Download URL
            //Get binary stream from URL by openStream()
            //InputStream is = jd.openStream();
            InputStream is = dp.openStream();
            //BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("jd.html"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("dp.html"));
            String msg = null;
            while ((msg=br.readLine())!=null){
                System.out.println(msg);
                writer.write(msg+"\n");
            }
            writer.flush();
            writer.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
