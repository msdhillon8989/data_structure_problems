package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by maninder on 15/11/16.
 */
public class ArrayRangeQuery
{
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String params[] = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int q = Integer.parseInt(params[1]);
        String arr[] =  br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++)
        {
            String query[] = br.readLine().split(" ");
            if(query[0].equals("0"))
            {
                int index= Integer.parseInt(query[2])-1;
                if(arr[index].equals("0"))
                {
                   sb.append("EVEN\n");
                }
                else
                {
                    sb.append("ODD\n");
                }
            }
            else
            {
                int index = Integer.parseInt(query[1])-1;
                arr[index]=arr[index].equals("0")?"1":"0";

            }
            }
        System.out.println(sb.toString());
        }
    }

