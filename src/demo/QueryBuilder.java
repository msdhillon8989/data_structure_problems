package demo;

import java.util.StringJoiner;

/**
 * Created by maninder on 22/12/16.
 'offer_id' => $offer,
 'total_revenue' => $revenue_pokkt,
 'impressions' => $impression_vdo,
 'success_count' => $success_vdo,
 'complete_count' => $complete,
 'firstQuartile_count' => $firstQuartile_count,
 'midpoint_count' => $midpoint_count,
 'thirdQuartile_count' => $thirdQuartile_count,
 'companion_clicks' => $companion_clicks,
 'linear_clicks' => $linear_clicks,
 'end_date' => $date,
 'start_date' => $date,
 'insert_date_time' => date("Y-m-d h:i:s", time()),
 'update_date_time' => date("Y-m-d h:i:s", time())
 */
public class QueryBuilder
{
    public static void main(String[] args) {
         String TABLE_NAME = "app_profile";
         String[] ALL_FIELDS = {"request_date", "app_title", "country", "city",
                "os_type",
                "brand",
                "device_model",
                "carrier_name",
                "crc_composite_key",
                "created",
                "region",
                "count"};  String query = buildQuery(TABLE_NAME,ALL_FIELDS);

        System.out.println(query);
    }

    private static String buildQuery(String table, String[] allAttrib) {

        StringBuilder update = new StringBuilder();
        StringBuilder values = new StringBuilder();
        String attribs = String.join(",",allAttrib);
        //`request_date` = VALUES(request_date),
        for(String attrib : allAttrib)
        {
            values.append("?,");
            update.append(String.join("","`",attrib,"`"," = ","VALUES(",attrib,"),"));
        }
        values.setLength(values.length()-1);
        update.setLength(update.length()-1);

        return String.join("","INSERT INTO ",table,"(",attribs,") VALUES (",
                values.toString(),") ON DUPLICATE KEY UPDATE ",update.toString());


    }
}
