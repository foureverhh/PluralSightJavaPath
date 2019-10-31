package foureverhh.ip_port_url;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class SpiderTest02_simulate_browser {
    public static void main(String[] args) {
        try {
            //Obtain URL
            URL dp = new URL("https://www.dianping.com");
            //Download URL
            //Get binary stream from URL by openStream()
            //InputStream is = dp.openStream();
            //模拟浏览器
            HttpsURLConnection connection = (HttpsURLConnection) dp.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Mobile Safari/537.36");
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
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
