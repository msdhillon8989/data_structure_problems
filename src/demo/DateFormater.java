package demo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by maninder on 30/11/16.
 */
public class DateFormater
{
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static final DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");

    static  final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws ParseException {
        ZonedDateTime today = ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0);

       /* ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime sevenHourBack = now.minus(7, ChronoUnit.HOURS).withMinute(0).withSecond(0);
        ZonedDateTime oneHourBack = now.minus(1, ChronoUnit.HOURS).withMinute(0).withSecond(0);

        String sevenHourBackDateString = sevenHourBack.format(dateTimeFormatter);
        Date sevenHourBackDate = format.parse(sevenHourBackDateString);

        String oneHourBackDateString = oneHourBack.format(dateTimeFormatter);
        Date oneHourBackDate = format.parse(oneHourBackDateString);

        String sss = "2017-06-14 12:30:00";
        Date date1 =  format.parse(sss);
        Date date2 =  format.parse(sss);

        System.out.println(date1.before(date2) +"   "+date2.before(date1));

        String dates[] = {"2017-06-14 12:30:00","2017-06-14 13:30:00","2017-06-14 10:30:00","2017-06-14 09:30:00","2017-06-14 01:30:00"};

        System.out.println(sevenHourBackDate.getTime() +"  "+oneHourBackDate.getTime());
        for(String date : dates)
        {
            Date d = format.parse(date);

            if(d.before(sevenHourBackDate) )
            {
                System.out.println(date+ "    older than last 6 hours");
            }
            else if(d.after(sevenHourBackDate) && d.before(oneHourBackDate))
            {
                System.out.println(date+ "    between last 6 hours");
            }
            else{
                System.out.println(date+ "    current hours");
            }
        }*/

        Long ad_request_count =4L;
        long total_requests=568732;
        double filledRequests = 100 * (((double) ad_request_count) / total_requests);
        DecimalFormat PRECISION4 = new DecimalFormat("##.######");


        System.out.println(PRECISION4.format(filledRequests));

        ZonedDateTime fromDate = today.withDayOfMonth(1).minus(1, ChronoUnit.MONTHS).withHour(0).withMinute(0).withSecond(0);
        ZonedDateTime toDate = today.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).minus(1, ChronoUnit.SECONDS);

        System.out.println(fromDate );
        System.out.println(toDate);





      /*  for(int day = from ; day>=to;day--)
        {
            ZonedDateTime fromDateTime = today.minus(day, ChronoUnit.DAYS).withHour(0).withMinute(0).withSecond(0);
            ZonedDateTime toDateTime = today.minus(day, ChronoUnit.DAYS).withHour(23).withMinute(59).withSecond(59);
            String fromDate = fromDateTime.format(dateTimeFormatter);
            String toDate = toDateTime.format(dateTimeFormatter);
           // System.out.println(fromDate +"  "+toDate);


        }

        ZonedDateTime fromDAte = today.minus(1,ChronoUnit.WEEKS).withHour(0).withMinute(0).withSecond(0);

       System.out.println(today.format(monthFormatter) +"  "+fromDAte.format(dateTimeFormatter));
        System.out.println(fromDAte.format(monthFormatter) +"  "+fromDAte.format(dateTimeFormatter));

        System.out.println(today.getMonth().getValue());
        System.out.println(fromDAte.getMonth().getValue());



        String target = "2017-01-11";
      *//*  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("MMddy");
        Date result =  df.parse(target);
        System.out.println(df2.format(result));*//*
        LocalDate date =
                LocalDate.parse(
                        target,
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ZonedDateTime zdt = date.atStartOfDay(ZoneOffset.UTC);

       // System.out.print(zdt.plusDays(2).format(dateTimeFormatter));
        System.out.println(today.format(dateTimeFormatter));
*/

    }
}
