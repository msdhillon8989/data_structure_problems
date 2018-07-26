package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by maninder on 25/5/17.
 *
 */
public class ArrayPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = br.readLine().split(" ");
        int[] array= Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i->i).toArray();
        arr=null;
        int count =0;
        for(int i=0;i<n-1;i++)
        {
            int currentMax=array[i];
            for(int j=i+1;j<n;j++)
            {
                if(currentMax<array[j])
                {
                    currentMax=array[j];
                }
                if(array[i]*array[j]<=currentMax)
                {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
