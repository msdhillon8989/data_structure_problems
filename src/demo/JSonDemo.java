package demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by maninder on 2/1/17.
 */
public class JSonDemo
{
    private static final Map<String, String> COL_MAP = new HashMap<>();

    static {
        COL_MAP.put("impressions","impressions");
        COL_MAP.put("revenue","balance");
        COL_MAP.put("clicks","clicks");
    }


    public static void jsonDemo()
    {
        String jsonString = "{\"name\" : \"Manninder\"}";
        try {
            JSONObject object  = new JSONObject(jsonString);
            
            System.out.println(object.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws JSONException {
        
       // jsonDemo();
        System.out.println(parseJsonAndGenReport().toString());

    }


    private static JSONArray transformDataToReport(JSONObject response , Map<String,String> params)
    {

        String appId = params.get("[APP_ID]");

        JSONArray report = new JSONArray();
        if (response.has("media"))
        {
            try {
                JSONObject media = response.getJSONObject("media");
                if(media.has(appId)) {
                    JSONObject appReport = media.getJSONObject(appId);
                    String application = appReport.getString("name");
                    String os = appReport.getString("os");
                    if(appReport.has("dailyActivities")) {
                        JSONObject dailyActivities = appReport.getJSONObject("dailyActivities");
                        Iterator<String> dates =  dailyActivities.keys();
                        while(dates.hasNext())
                        {
                            JSONObject totalObject = new JSONObject();
                            String date = dates.next();
                            JSONObject dateData = dailyActivities.getJSONObject(date);
                            Iterator<String> adUnits = dateData.keys();
                            while (adUnits.hasNext())
                            {
                                String adUnit = adUnits.next();
                                JSONObject adUnitData = dateData.getJSONObject(adUnit);

                                Iterator<String> countries = adUnitData.keys();
                                while (countries.hasNext())
                                {
                                    String country = countries.next();
                                    JSONObject countryData = adUnitData.getJSONObject(country);
                                    Iterator<String> metrics = countryData.keys();
                                    while(metrics.hasNext())
                                    {
                                        String metric = metrics.next();
                                        int data = countryData.getInt(metric);
                                        if(!totalObject.has(country))
                                        {
                                            totalObject.put(country,new JSONObject());
                                        }
                                        JSONObject totalCountryData = totalObject.getJSONObject(country);
                                        if(!totalCountryData.has(metric))
                                        {
                                            totalCountryData.put(metric,data);
                                        }
                                        else {
                                            int previousValue = totalCountryData.getInt(metric);
                                            totalCountryData.put(metric,previousValue+data);
                                        }
                                    }
                                }
                            }
                            Iterator<String> countries = totalObject.keys();

                            while (countries.hasNext())
                            {
                                String country = countries.next();
                                JSONObject countryObject = totalObject.getJSONObject(country);
                                JSONObject reportData = new JSONObject();
                                reportData.put("date", date);
                                reportData.put("application", application);
                                reportData.put("os", os);
                                reportData.put("package_name", "NA");
                                reportData.put("country",country);

                                for (Map.Entry<String, String> entry : COL_MAP.entrySet()) {
                                    if (countryObject.has(entry.getValue())) {
                                        reportData.put(entry.getKey(), countryObject.getInt(entry.getValue()));
                                    } else if (!reportData.has(entry.getKey())) {
                                        reportData.put(entry.getValue(), "0");
                                    }

                                }
                                if (reportData.has("impressions") && (reportData.getInt("impressions")!=0 )) {
                                    double ecpm = (1000 * reportData.getDouble("revenue")) / reportData.getDouble("impressions");
                                    reportData.put("ecpm", ecpm);
                                    double ctr = (100 * reportData.getLong("clicks")) / reportData.getLong("impressions");
                                    reportData.put("ctr", ctr);
                                } else {
                                    reportData.put("ecpm", 0);
                                    reportData.put("ctr", 0);
                                }
                                report.put(reportData);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return report;
    }



    private static JSONArray parseJsonAndGenReport() throws JSONException {
        String jsonString = "{" +
                "\"media\": {" +
                "\"58c2609c1d1f4e1a0d3895ae\": {" +
                "\"name\": \"SampleApp\"," +
                "\"os\": \"android\"," +
                "\"dailyActivities\": {" +
                "\"2017-04-12\": {" +
                "\"fullscreen\": {" +
                  "}," +
                "\"banner\": {" +
                "\"IN\": {" +
                "\"impressions\": 3," +
                "\"clicks\": 2," +
                "\"balance\": 1" +
                "}," +
                "\"GB\": {" +
                "\"impressions\": 6," +
                "\"clicks\": 5," +
                "\"balance\": 49" +
                "}" +
                "}" +
                "}," +
                "\"2017-04-13\": {" +
                "\"fullscreen\": {" +
                "\"SB\": {" +
                "\"impressions\": 1," +
                "\"clicks\": 2," +
                "\"balance\": 3" +
                "}," +
                "\"XY\": {" +
                "\"impressions\": 4," +
                "\"clicks\": 5" +
                "}" +
                "}," +
                "\"banner\": {" +
                "\"SB\": {" +
                "\"impressions\": 3," +
                "\"clicks\": 2," +
                "\"balance\": 1" +
                "}," +
                "\"XY\": {" +
                "\"impressions\": 6," +
                "\"balance\": 49" +
                "}" +
                "}" +
                "}" +
                "}" +
                "}" +
                "}," +
                "\"err\": null" +
                "}";
        Map<String,String> params = new HashMap<>();
        params.put("[APP_ID]","58c2609c1d1f4e1a0d3895ae");
        JSONObject object = new JSONObject(jsonString);
        return  transformDataToReport(object,params);
    }
    



}
