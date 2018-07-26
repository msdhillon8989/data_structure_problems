package demo;



import org.json.JSONObject;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by maninder on 21/2/17.
 */

public class MapStringConversion {
    public static void main(String[] args) {

        String predistionDataString = "{" +
                "\"8654_100125_APPNAME_US\" : {" +
                "\"event_0\":1," +
                "\"event_4\":1," +
                "\"event_6\":1," +
                "\"event_9\":1," +
                "\"event_17\":1," +
                "\"event_16\":1 " +
                "}," +
                "\"8655_100125_APPNAME_US\" : {" +
                "\"event_0\":2," +
                "\"event_4\":2," +
                "\"event_6\":3," +
                "\"event_9\":4," +
                "\"event_17\":5," +
                "\"event_16\":6" +
                "}\n" +
                "}";


        String predata = "{1001525_8208_adam.dragoneggcracker_thailand={event_16=1, event_17=1}, 1001525_8208_adam.dragoneggcracker_vietnam={event_0=6, event_16=24, event_17=14}, 1001525_8208_air.a3reelretro_vietnam={event_0=3, event_16=13, event_17=10}, 1001525_8208_air.air.make.city.idle.build.game_vietnam={event_0=1, event_16=1}, 1001525_8208_air.android.balletschool_vietnam={event_0=2, event_16=2}, 1001525_8208_air.android.princesssupercosygath_vietnam={event_16=2, event_17=2}}";
        try{
            JSONObject json  = new JSONObject(predata);
            Iterator<String> keys = json.keys();
            while (keys.hasNext())
            {
                String currentKey = keys.next();
                String  offerId = currentKey.split("_")[1];
                System.out.println(offerId+"  "+json.get(currentKey).toString());

            }

        }catch (Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
