package demos.reoccure;

/*import com.google.ical.compat.jodatime.LocalDateIteratorFactory;
import org.joda.time.LocalDate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;*/


import com.google.ical.compat.jodatime.LocalDateIteratorFactory;
import org.joda.time.LocalDate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static demos.test.CommonUtils.getCurrentUTCDate;


public class ReoccurrenceDates {


    /**
  /*   * print the first 13 Friday the 13ths in the 3rd millenium AD.
     */
    private static void print13FridayOn13th() throws java.text.ParseException {
        LocalDate start = new LocalDate(2018, 2, 22);

        // Every friday the thirteenth.
        String ical = "RRULE:FREQ=DAILY"
                + ";BYDAY=FR"  // every Friday
                //  + ";BYMONTHDAY=13"  // that occurs on the 13th of the month
                + ";COUNT=13";  // stop after 13 occurences

        // Print out each date in the series.
        for (LocalDate date :
                LocalDateIteratorFactory.createLocalDateIterable(ical, start, false)) {
            System.out.println(date);
        }
    }


    public static void main(String[] args) throws Exception {

       // print13FridayOn13th();

        printSeries();


    }

    private static  void printSeries() throws Exception
    {
           Series series = new Series();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

        series.setStartDate(fm.parse("2018-04-05"));
        series.setEndDate(fm.parse("2018-04-07"));

        series.setStartTime("25:59");
        series.setEndTime("08:13");

        series.setFrequency("DAILY");
        series.setDaysOfWeek("MO,TU,WE,TH,FR");
        //series.setWeekOfMonth("2");
        //series.setDayOfMonth("-1");
        //series.setMonthOfYear("11");
        series.setoCount(15);

        System.out.println(validStartDate(series));

       // printOccurrence(series);
    }

    private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    private static boolean validStartDate(Series series) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date  = dateFormat.format(series.getStartDate()) + " " +series.getStartTime()+":00";
        long MILLIS_IN_5_MINS = 300000;
        try {
           if(!series.getStartTime().matches(TIME24HOURS_PATTERN))
            {
                System.out.println("Time format does not match 24 hour format . Please use HH:mm format");
            }
            Date startDate = dateTimeFormat.parse(date);

            Date currentUtcDate = getCurrentUTCDate();

            System.out.println(startDate +"   "+currentUtcDate);



            if(startDate.before(currentUtcDate))
            {
                System.out.println("start date is before current date");
                return false;
            }
            else if ((startDate.getTime() - currentUtcDate.getTime())<MILLIS_IN_5_MINS)
            {
                System.out.println("SET START time 5 mins ahead of current time");
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }

    private static void printOccurrence(Series series) throws ParseException {
        StringBuilder rule = new StringBuilder();
        final String freq = series.getFrequency();

        rule.append("RRULE:FREQ=").append(freq).append(";");
        if (series.getDaysOfWeek() != null) {
            rule.append("BYDAY=").append(series.getDaysOfWeek()).append(";");
            rule.append("INTERVAL=2").append(";");
        }
        if (series.getWeekOfMonth() != null) {
            rule.append("BYWEEKNO=").append(series.getWeekOfMonth()).append(";");
        }

        if (series.getMonthOfYear() != null) {
            rule.append("BYMONTH=").append(series.getMonthOfYear()).append(";");

        }

        if (series.getDayOfMonth() != null) {
            rule.append("BYMONTHDAY=").append(series.getDayOfMonth()).append(";");
        }

        if (series.getoCount() != null) {
            rule.append("COUNT=").append(series.getoCount()).append(";");
        }

        LocalDate startDate = new LocalDate(series.getStartDate());
        if (series.getEndDate() == null) {
            for (LocalDate date :
                    LocalDateIteratorFactory.createLocalDateIterable(rule.toString(), startDate, true)) {
                System.out.println(date);
            }
        } else {
            String dateTime = new SimpleDateFormat("yyyyMMdd'T'HHmmss").format(series.getEndDate());
            rule.append("UNTIL=").append(dateTime).append(";");
            for (LocalDate date :
                    LocalDateIteratorFactory.createLocalDateIterable(rule.toString(), startDate, true)) {
                System.out.println(date);
            }
        }


    }
}
