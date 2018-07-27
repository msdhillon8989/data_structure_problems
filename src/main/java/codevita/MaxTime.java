package codevita;

import java.util.HashMap;
import java.util.Map;

/**
 *  The objective is to form the maximum possible time in the HH:MM:SS format using any six of nine given single digits (not necessarily distinct)
 *  Given a set of nine single (not necessarily distinct) digits, say 0,0,1,3,4,6,7,8,9
 *  it is possible to form many distinct times in a 24 hour time format HH:MM:SS, such as 17:36:40 or 10:30:41 by using each of the digits only once
 *
 */

public class MaxTime {

    static Map<Integer, Integer> digits;
    public static void main(String[] args) {
        String input = "2,1,4,4,6,5,7,8,9,2,3";
        String maxTime = getMaxTime(input);

        System.out.println(maxTime == null ?"Impossible" : maxTime);
    }

    private static String getMaxTime(String input) {
        digits = new HashMap<>();
        String _digits[] = input.split(",");
        for(String digit : _digits)
        {
            Integer d = Integer.parseInt(digit.trim());
            increment(d);
        }

        String maxHour = getMaxHour();

        if(maxHour == null)
        {
            return null;
        }

        String maxMin = getMinutes();
        if(maxMin == null)
        {
            return null;
        }

        String maxSec = getSeconds();
        if(maxSec == null)
        {
            return null;
        }

        return maxHour+":"+maxMin+":"+maxSec;




    }

    private static String getMaxHour( )
    {
        Integer onePalceDigit;
        Integer _10PlaceDigit = getMaxValuDigit(2);
        if(_10PlaceDigit ==-1)
        {
            return null;
        }
        else if(_10PlaceDigit == 2)
        {
            onePalceDigit = getMaxValuDigit(3);
            if(onePalceDigit == -1)
            {
                return null;
            }
        }
        else {
            onePalceDigit = getMaxValuDigit(9);
            if(onePalceDigit ==-1)
            {
                return null;
            }
        }
        return _10PlaceDigit+""+onePalceDigit;
    }


    private static String getMinutes( )
    {
        return getMax();
    }

    private static String getSeconds( )
    {
        return getMax();
    }


    private static String getMax() {
        int limits[] = {5,9};
        StringBuilder sb = new StringBuilder();
        for(int limit: limits)
       {
           Integer maxValueDigit  = getMaxValuDigit(limit);
           if(maxValueDigit ==null)
           {
               return null;
           }
           sb.append(maxValueDigit);
       }
        return sb.toString();
    }

    private static void increment(Integer digit)
    {
        digits.merge(digit, 1, (a, b) -> a + b);
    }

    private static void decrement(Integer digit)
    {
        digits.merge(digit, 1, (a, b) -> a - b);
    }


    private static Integer getMaxValuDigit(int maxLimit) {
        for( ; maxLimit>=0;maxLimit--)
        {
            Integer digitCount = digits.get(maxLimit);
            if(digitCount != null && digitCount!=0)
            {
                decrement(maxLimit);
                return maxLimit;
            }
        }
        return -1;
    }
}
