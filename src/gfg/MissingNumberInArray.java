package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by maninder on 2/8/17.
 */
public class MissingNumberInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());

            String arr[] = br.readLine().split(" ");
            int[] array = Arrays.stream(arr).map(Integer::parseInt).mapToInt(i -> i).toArray();

            int sum =   (n*(n+1))/2;
            for (int i = 0; i < array.length; i++) {
                sum-=array[i];
            }
            System.out.println(sum);
        }

    }

}
