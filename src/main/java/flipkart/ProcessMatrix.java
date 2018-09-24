package flipkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProcessMatrix {
    private static int X, Y, Z;

    static int  matrix[][];
    public static void main(String[] args) throws IOException {

        X = 5;
        Y = 3;
        Z = 1;
        matrix = new int[X][Y];
        processMatrix();
    }

    private static void processMatrix() {

        int maxSteps = X + Y - 2 ;


        for (int i = 0; i < Z; i++)//Floor
        {

            for (int j = 0; j <= maxSteps; j++) {
                int x1 = 0, y1 = j;

                while (x1 < X && y1 >= 0) {
                    if (x1 < X && y1 < Y) {

                        matrix[x1][y1]=j;
                       /* System.out.print(
                                "(" + x1 + "," + y1 +")"+" "
                        );*/



                        x1++;
                        y1--;

                    } else if (y1 >= Y) {
                        x1 = y1-Y+1;
                        y1 = Y - 1;
                    }
                }
              //  System.out.println( );
            }
        }

        for(int i=0;i<X;i++)
        {
            for(int j=0;j<Y;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
