package demos.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CommonUtils {
    public static final SimpleDateFormat utcDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    static {
        utcDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static Date getCurrentUTCDate() {
        try {
            SimpleDateFormat local = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

           return local.parse(utcDateFormat.format(new Date()));
        } catch (Exception e) {
            return new Date();
        }
    }


    public static Date getDateWithUTC(String date) {
        if (date != null)
        {
            try {
                return utcDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return getCurrentUTCDate();
    }

    public static Date convertUTCtoCurrent(String date) {
        try {
            SimpleDateFormat local = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return local.parse(local.format(getDateWithUTC(date)));
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

}
