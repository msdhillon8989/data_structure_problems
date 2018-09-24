package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WanderPaths {

    static int M, N, K;

    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(",");
        int[] array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();

        M = array[0];
        N = array[1];
        K = array[2];
        //read start and endd point
        arr = br.readLine().split(",");
        array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();

        int x1 = array[0];
        int y1 = array[1];
        int x2 = array[2];
        int y2 = array[3];


        // recursive function to find the path between to points with length limit
        findTotalPaths(x1, y1, x2, y2, 0);
        System.out.println(total);

    }

    private static void findTotalPaths(int x1, int y1, int x2, int y2, int currentLength) {

        if(x1>=0 && x1<=N && y1>=0 && y1<=M)
        {
            //current length is equals to given length then and x1 and y1 are equal to destination point
            // then increase the counter
            if (currentLength == K) {
                if (x1 == x2 && y1 == y2) {
                    total++;
                }

            } else if (currentLength < K) {
                //increment the length by 1 and find path in all four directions recursively.
                findTotalPaths(x1 + 1, y1, x2, y2, currentLength + 1);
                findTotalPaths(x1 - 1, y1, x2, y2, currentLength + 1);
                findTotalPaths(x1, y1 + 1, x2, y2, currentLength + 1);
                findTotalPaths(x1, y1 - 1, x2, y2, currentLength + 1);
            }
        }
    }
}
