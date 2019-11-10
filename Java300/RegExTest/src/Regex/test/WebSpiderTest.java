package Regex.test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpiderTest {
    public static void main(String[] args) throws IOException {
        String content = getURLContent("https://www.163.com","gbk");
       // Pattern getAnchor = Pattern.compile("<a href=\"(.+)\">.+<\\/a>");
        //get anchor all info
        /*
        Matcher anchorMatcher = getAnchor.matcher(content);
        Pattern getAnchor = Pattern.compile("<a[\\s\\S]+?<\\/a>");
        while (anchorMatcher.find()){
            System.out.println(anchorMatcher.group());
        }
        */
        //Pattern getHref = Pattern.compile("href=\"(.+?)\"");
        Pattern getHref = Pattern.compile("href=\"([\\w\\s./:]+?)\"");
        Matcher hrefMatcher = getHref.matcher(content);
        Set<String> urls = new HashSet<>();
        while (hrefMatcher.find()){
            //System.out.println(hrefMatcher.group(1));
            //if(hrefMatcher.group(1).trim().startsWith("http")) {
                urls.add(hrefMatcher.group(1).trim());
            //}
        }

        for(String url : urls){
            System.out.println(url);
        }

    }


    static void crawler(){

    }

    static String getURLContent(String url,String charset){
        //Get html in www.163.com
        URL webNet = null;
        BufferedReader reader = null;
            StringBuilder sb = new StringBuilder();

        try {
            webNet = new URL(url);
            InputStream is = webNet.openStream();
            reader = new BufferedReader(new InputStreamReader(is, Charset.forName(charset)));

            String content=null;
            while((content=reader.readLine())!=null){
                sb.append(content+"\n");
            }
            //System.out.println(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    /*static void getURLContent(String url){
        //Get html in www.163.com
        URL webNet = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            webNet = new URL(url);
            InputStream is = webNet.openStream();
            reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            writer = new BufferedWriter(new FileWriter("163.html"));
            String content=null;
        while((content=reader.readLine())!=null){
            writer.write(content+"\n");
            writer.flush();
        }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
