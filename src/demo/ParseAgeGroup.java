package demo;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by maninder on 11/11/16.
 */
public class ParseAgeGroup
{
    public static void main(String[] args) {
        String ageGroup = "18-24";
        String ageRange = ageGroup.substring(ageGroup.lastIndexOf("_")+1);
        int year = 0;
        int age = 0;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");
        ZonedDateTime today = ZonedDateTime.now(ZoneId.of(ZoneOffset.UTC.getId()));
        try {
            if (ageRange.contains("-")) {
                String limits[] = ageRange.split("-");

                int from = Integer.parseInt(limits[0]);
                int to = Integer.parseInt(limits[1]);
                age = from + (to - from) / 2;

            } else {
                if (ageRange.contains("+")) {
                    ageRange = ageRange.substring(0, ageRange.indexOf("+"));
                }
                age = Integer.parseInt(ageRange);
            }
            year = (Integer.parseInt(today.format(dateTimeFormatter)) - age);
        }
        catch (Exception e)
        {
            System.out.println("Invalid age group");

        }

        System.out.println(age+"  "+year);

    }
}
