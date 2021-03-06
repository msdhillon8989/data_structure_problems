package demo;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by maninder on 26/12/16.
 */
public class JsoupExample {


    public static void getDataFronPlayStore() {
        ArrayList<String> names = new ArrayList<>();
        names.add("com.gggg.tier");
        System.out.println(getAppData(names).toString());
    }

    public static void main(String[] args) {
       // getDataFomAppStore();
        //getDataFronPlayStore();
        int i = 50000;
        while(i-->0) {
            try {
                getDataFromUrl("https://www.imdb.com/title/tt7690638/?ref_=india_t_up");
                Thread.sleep(10);
                System.out.println(i);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void getDataFomAppStore() {
        ArrayList<String> bundles = new ArrayList<>();
        bundles.add("com.dunyailetisim.samanyoluhaber");

        JSONArray result = readJsonFromUrl(bundles);
        System.out.println("result " + result);
    }

    private static JSONArray readJsonFromUrl(ArrayList<String> bundles) {

        JSONArray result = new JSONArray();
        String url = "http://itunes.apple.com/lookup?bundleId=";
        for (String bundle : bundles) {
            try {

                JSONObject jsonObject = readJsonFromUrl(url + bundle);

                if (jsonObject.get("resultCount").toString().equals("1")) {
                    JSONObject appData = new JSONObject();
                    appData.put("bundle_name", bundle);
                    JSONObject jsonAppData = jsonObject.getJSONArray("results").getJSONObject(0);
                    appData.put("app_title", jsonAppData.getString("trackCensoredName"));
                    appData.put("rating", jsonAppData.getString("trackContentRating"));
                    appData.put("category", jsonAppData.getString("primaryGenreName"));
                    appData.put("platform", "ios");
                    appData.put("user_rating", jsonAppData.getDouble("averageUserRating"));
                    result.put(appData);
                }
            } catch (Exception e) {
                System.out.println("Error while parsing " + e);
                e.printStackTrace();
            }
        }
        return result;
    }

    public static JSONArray getAppData(ArrayList<String> packages) {
        JSONArray insetData = new JSONArray();
        for (String appBundle : packages) {
            String url = "https://play.google.com/store/apps/details?id=" + appBundle;
            JSONObject appData = new JSONObject();
            try {

                Document doc= Jsoup.connect(url).get();

                appData.put("title", getValue(doc,"id-app-title"));
                appData.put("rating", getValue(doc,"itemprop","contentRating").replace("Rated for ",""));
                appData.put("category", getValue(doc,"itemprop", "genre"));
                appData.put("averageUserRating", getValue(doc,"score"));
                appData.put("platform","android");
                insetData.put(appData);

            } catch (Exception e) {
                System.out.println("Error "+e.getLocalizedMessage()+" "+url);
                e.printStackTrace();
            }
        }
        return insetData;
    }

    private  static String getValue(Document doc,String className)
    {
        Elements e = doc.getElementsByClass(className);
        if(e.isEmpty())
        {
            return "";
        }
        else
        {
            Element element = e.first();
            return element.html();
        }
    }
    private static String getValue(Document doc,String attrib,String value)
    {
        Elements e = doc.getElementsByAttributeValue(attrib, value);
        if(e.isEmpty())
        {
            return "";
        }
        else
        {
            Element element = e.first();
            return element.html();
        }
    }


    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {

            JSONObject json = new JSONObject(getDataFromUrl(url));
            return json;
        } finally {
            is.close();
        }
    }


    private static String getDataFromUrl(String url) throws IOException
    {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            return readAll(rd);
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
