package flipkart;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    private static int X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(" ");
        int[] array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();
        X = array[1];
        Y = array[2];
        Z = array[0];
        int n = Integer.parseInt(br.readLine());
        boolean parking[][][] = new boolean[Z][X][Y];
        while (n-- > 0) {
            String s = br.readLine();
            if (s.trim().equals("1")) {
                printParkingSpace(parking);
            } else {
                arr = s.split(" ");
                array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();
                int z1 = array[1], x1 = array[2], y1 = array[3];
                parking[z1][x1][y1] = false;
            }
        }
    }

    private static void printParkingSpace(boolean[][][] parking) {

        int maxSteps = X>Y?X:Y;

        loop1:
        for(int i=0;i<Z;i++)//Floor
        {

            for(int j=0;j<maxSteps;j++)
            {
                int x1=0,y1=j;

                while(x1<X && y1>=0)
                {
                    if(x1<X || y1<Y)
                    {
                        if(!parking[i][x1][y1])
                        {
                            parking[i][x1][y1]=true;
                            System.out.println(
                                    i+" "+x1+" "+y1
                            );
                            break loop1;
                        }
                       else
                        {
                            x1++;
                            y1--;
                        }
                    }
                    else if(y1>=Y)
                    {
                        y1=Y-1;
                        x1=y1;
                    }
                }
            }
        }
    }

}
