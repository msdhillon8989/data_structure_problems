package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AddTwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String arr[] = br.readLine().split(" ");
        int[] array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();

        arr = br.readLine().split(" ");
        int[] array2 = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();

        StringBuilder sb = new StringBuilder();
        sb.append(array[0]+array2[0]);
        for(int i=0;i<array.length;i++)
        {
            sb.append(" ").append(array[i]+array2[i]);
        }
        System.out.println(sb.toString());

    }
}
