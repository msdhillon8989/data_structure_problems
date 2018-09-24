package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoastGuard {

    static public int area[][][];

    static int rows, cols, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(",");
        int[] array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();
        rows = array[0];
        cols = array[1];
        k = array[2];
        //init 3d array
        //K = number of boats
        area = new int[k][rows][cols];

        //for each boat populate the corresponding 2d array with the time in which boat can reach that grid
        for(int boat =0;boat<k;boat++)  {
            String[] cordinates = br.readLine().split(",");
            int y = Integer.parseInt(cordinates[0]);
            int x = Integer.parseInt(cordinates[1]);
            x = rows-x-1;

            //this function will go up and left recursively and populate the grid
            populateUpLeft(boat,x, y, 0);
            populateDownLeft(boat,x, y, 0);
            populateUpRight(boat,x,y,0);
            populateDownRight(boat,x+1,y+1,2);
        }



        int count =0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean unControlled = false;
                Set<Integer> time = new HashSet<>();
                for(int boat=0;boat<k;boat++) {
                    //for each grid, add the time take for each boat into time set
                    //if same time is already available then add function will return false
                    if(!time.add(area[boat][i][j]))
                    {
                        //cell is unControlled if more than one boat can reach there in same time
                        unControlled=true;
                        break;
                    }
                }
                if(unControlled)
                {
                    count++;
                }
            }
        }
       System.out.print(count);


       /* for(int boat=0;boat<k;boat++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(area[boat][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("----------------------");
        }*/
    }


    private static void populateUpLeft(int boat,int x, int y, int t) {
        if (x < 0 || y < 0) {
            return;
        }

        if (area[boat][x][y] == 0) {
            area[boat][x][y] = t;
            populateUpLeft(boat,x, y - 1, t + 1); //left
            populateUpLeft(boat,x - 1, y, t + 1); //up
        }
    }

    private static void populateDownLeft(int boat,int x, int y, int t) {
        if (x >= rows || y < 0) {
            return;
        }

        if (area[boat][x][y] == 0) {
            area[boat][x][y] = t;
            populateDownLeft(boat,x, y - 1, t + 1); //left
            populateDownLeft(boat,x + 1, y, t + 1);//down
        }
    }


    private static void populateUpRight(int boat,int x, int y, int t) {
        if (x < 0 || y >= cols) {
            return;
        }

        if (area[boat][x][y] == 0) {
            area[boat][x][y] = t;
            populateUpRight(boat,x, y + 1, t + 1); //right
            populateUpRight(boat,x - 1, y, t + 1); //up
        }
    }

    private static void populateDownRight(int boat,int x, int y, int t) {
        if (x >= rows || y >= cols) {
            return;
        }

        if (area[boat][x][y] == 0) {
            area[boat][x][y] = t;
            populateDownRight(boat,x, y + 1, t + 1); //right
            populateDownRight(boat,x + 1, y, t + 1);//down
        }
    }

}
