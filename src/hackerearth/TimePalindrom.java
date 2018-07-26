package HackerEarth;

/**
 * Created by maninder on 16/10/16.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class TimePalindrom
{
    private  static ArrayList<String> possible =  new ArrayList<String>();
    static {
        possible.add("0000");
        possible.add("0110");
        possible.add("0220");
        possible.add("0330");
        possible.add("0440");
        possible.add("0550");
        possible.add("1001");
        possible.add("1111");
        possible.add("1221");
        possible.add("1331");
        possible.add("1441");
        possible.add("1551");
        possible.add("2002");
        possible.add("2112");
        possible.add("2222");
        possible.add("2332");

    }
    public static void main(String[] args)
    {
            Scanner s = new Scanner(System.in);
             int n = s.nextInt();
            while(n-->0)
            {
                int startTime = s.nextInt();
                int endTime = s.nextInt();
               System.out.println(getAllPossibleCount(startTime   , endTime));
            }
    }

    private static int getAllPossibleCount(int start, int end)
    {
        int count = 0;
        for(String palindrom : possible)
        {
            int pal = Integer.parseInt(palindrom);
            if(pal>=start && pal<=end)
            {
                count++;
            }
        }
        return count;
    }
}
