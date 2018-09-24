package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxArea {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int matrix[][]=new int[10000][10000];
        int maxValue = 0;
        int maxArea = 0;

        //Numner of rectangles
        while(n-->0)
        {
            String arr[] = br.readLine().split(" ");
            int[] array= Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i->i).toArray();

            //cordinates of rectangle and value
            int x1 =array[0],y1=array[1],x2=array[2],y2=array[3],value=array[4];

            for(int r=y1;r<y2;r++)
            {
                for (int c=x1;c<x2;c++)
                {
                    // populate the matrix with rectangle area
                    matrix[r][c]+=value;

                    int currentValue = matrix[r][c];

                    // in case current value is more than maxValue
                    // update maxArea count to 1
                    if(currentValue>maxValue)
                    {
                        maxArea = 1;
                        maxValue =currentValue;
                    }
                    else if(currentValue==maxValue)
                    {
                        maxArea++;
                    }
                }
            }
        }


        System.out.print(maxArea);

    }
}
