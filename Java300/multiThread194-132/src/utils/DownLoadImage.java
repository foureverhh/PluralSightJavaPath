package utils;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class DownLoadImage implements Runnable {
    private String urlLocation;
    private String fileName;

    public DownLoadImage(String urlLocation, String fileName) {
        this.urlLocation = urlLocation;
        this.fileName = fileName;
    }

    void downloadImage(String urlLocation, String fileName){
        URL url = null;
        URLConnection connection = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            url = new URL(urlLocation);
            connection = url.openConnection();
            connection.setRequestProperty("method","GET");
            connection.setRequestProperty("User-agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Mobile Safari/537.36");
            is = connection.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(fileName));
            byte[] buffer = new byte[1024*6];
            int len = 0;
            while ((len = is.read(buffer))!=-1){
                bos.write(buffer,0,len);
                bos.flush();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           if(bos!=null){
               try {
                   bos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(is!=null){
               try {
                   is.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    @Override
    public void run() {
        downloadImage(urlLocation,fileName);
    }
}
