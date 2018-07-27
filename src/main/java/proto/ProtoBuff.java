package proto;

/*
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;
import models.protobuf.tracker.DMPBean;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;

*//**
 * Created by maninder on 20/3/17.
 *//*
public class ProtoBuff {
    private static JsonFormat format = new JsonFormat();
    private static byte[] getDmpProtoBufBytes(String line) {

        line = line.trim();
        Message.Builder builder = DMPBean.newBuilder();
        try {

            format.merge(line, ExtensionRegistry.newInstance(), builder);
            Message build = builder.build();
            if (build != null) {
                return build.toByteArray();
            }else{
                System.out.println("Null proto-buff bytes for DMP {}"+ line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args)
    {
        try {
            JSONArray locationEvents = new JSONArray();
             JSONObject locationEvent = new JSONObject();
            locationEvent.put("latitude", 3.14);
            locationEvent.put("longitude", 2.34);

            locationEvents.put(locationEvent);


            JSONObject device = new JSONObject();
            device.put("deviceId", "device2");


            JSONObject eventObject = new JSONObject();
            eventObject.put("device", device);
            eventObject.put("locationEventList", locationEvents);



            JSONArray events = new JSONArray();
            events.put(eventObject);


            JSONObject data = new JSONObject();
            data.put("appBundleId", "com.example.mani");
            data.put("events", events);

            JSONObject dmpData = new JSONObject();
            dmpData.put("end_point_url", "endpointURL");
            dmpData.put("request_header", "application/json");
            dmpData.put("request_body", data.toString());

            String buffData = new String(getDmpProtoBufBytes(dmpData.toString()));

            System.out.print(buffData);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }*/
//}
