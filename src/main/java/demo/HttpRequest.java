package demo;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

/**
 * Created by maninder on 2/2/17.
 */
public class HttpRequest {

    static CookieManager cookieManager = new CookieManager();

    public static String getResult(String apiUrl) throws Exception
    {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(true);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept","text/html,application/json");
        //connection.setRequestProperty("Accept-Encoding","gzip, deflate, sdch, br");
        connection.setRequestProperty("Accept-Language","en-US;q=0.8");
        connection.setRequestProperty("API_KEY","$2y$10$XeeRaPKbLMaQTdcPMvORZ.CGJXlvjhKEOorhWVmbToJvvEosE.lGW");
        connection.setRequestProperty("Upgrade-Insecure-Requests","1");
        connection.setRequestProperty("Connection","keep-alive");
        //connection.setRequestProperty("API_KEY",headers.getOrDefault("[API_KEY]","NA"))
        connection.setRequestProperty("User-Agent", "Mozilla");
        //connection.setRequestProperty("Cache-Control", "no-cache");
        //connection.setRequestProperty("Content-Type", "application/json");
        //connection.setRequestProperty("Host","admin-api.fusepowered.com");
        connection.addRequestProperty("Referer", "google.com");
        /**
         * Cache-Control:max-age=0
         Connection:keep-alive
         Host:admin-api.fusepowered.com
         */
        connection.connect();
        int responseCode = connection.getResponseCode();
        //loggingConsumer.accept(MessageSupplier.get("Rresponse code is {}",responseCode));
        System.out.println("response code  = "+responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK)
        {

            String response  =  getHttpResponse(connection);
            return  response;

        }
        else if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP)
        {

            String newurl = connection.getHeaderField("location");

            return  getResult(newurl);

        }


        return "empty";
    }

    public static void main(String[] args) {
        try{
           // CookieHandler.setDefault(cookieManager);

            //https://pub-reports.nativex.com/v1?apiKey=c14323f0cd614c6c9822072060ad2910&start=2017-01-24&end2017-02-02&by=country
            //https://admin-api.fusepowered.com/v1.0/report?group_by=date,app,country&start_date=2017-01-29&end_date=2017-02-02
            //http://gameads-admin.applifier.com/stats/monetization-api?apikey=260a0920a6f0130eef0197744053d12961d688795c4d2c1e47a723fb597ab53b&start=-1&end=0&splitBy=source,country&scale=all
            //System.out.println(getResult("https://admin-api.fusepowered.com/v1.0/report?group_by=date,app,country&start_date=2017-01-29&end_date=2017-02-02"));
            //System.out.println(sendPost("http://vdo.pokkt.com/cluster/redis/set/myname/4000","ManinderSinghFromJava"));

            String userName  = "kanchan@pokkt.com";
            String secretKey = "6a0c918a78662508d98f3110a9d5fd61";

            String token  = TEst.base64(userName,secretKey);
            String url =  "https://platform.ironsrc.com/partners/publisher/mediation/applications/v3/stats?startDate=2017-02-01&endDate=2017-02-04&appId=5e35812d";
                url ="https://platform.ironsrc.com/partners/publisher/applications?appId=5e35812d";
            String headers[][] = {{"Authorization","Basic "+token}};
            System.out.println(get(url,headers));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String get(String apiUrl,String headers[][]) throws Exception
    {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(true);

        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        //connection.setRequestProperty( "Content-Type", "text/plain");

        for(String []header : headers)
        {
            connection.setRequestProperty( header[0], header[1]);
        }
        connection.connect();
        int responseCode = connection.getResponseCode();
        //loggingConsumer.accept(MessageSupplier.get("Rresponse code is {}",responseCode));
        System.out.println("response code  = "+responseCode);


        String response  =  getHttpResponse(connection);
        return  response;




    }

    public static String sendPost(String apiUrl,String data) throws Exception
    {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(true);

        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty( "Content-Type", "text/plain");
//        connection.setRequestProperty( "charset", "utf-8");
        connection.setRequestProperty("Content-Length", data.length()+"");
        System.out.println(data.length());

        OutputStream pwd = connection.getOutputStream();
        pwd.write(data.getBytes());

        connection.connect();
        int responseCode = connection.getResponseCode();
        //loggingConsumer.accept(MessageSupplier.get("Rresponse code is {}",responseCode));
        System.out.println("response code  = "+responseCode);


            String response  =  getHttpResponse(connection);
            return  response;




    }



    public static String getHttpResponse(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append("\n");
        }
        rd.close();
        return response.toString();
    }
}
