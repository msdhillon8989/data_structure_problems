package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BacteriaEvolution {

    static final int neighbours[][] = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0},           {1, 0},
            {-1, 1},  {0, 1},  {1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read first line for test cases
        Integer N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            //read second line for grid rows and columns
            String input[] = br.readLine().split(" ");
            int rows = Integer.parseInt(input[0]);
            int cols = Integer.parseInt(input[1]);
            byte bacteriaCurrentState[][] = new byte[rows][cols];
            byte bacteriaNextGenState[][] = new byte[rows][cols];
            //storing the input of bacteria state
            for (int row = 0; row < rows; row++) {
                String rowData = br.readLine();
                for (int col = 0; col < cols; col++) {
                    bacteriaCurrentState[row][col] = Byte.parseByte(rowData.charAt(col) + "");
                    bacteriaNextGenState[row][col] = Byte.parseByte(rowData.charAt(col) + "");
                }
            }

            //read the ji and jj limits
            input = br.readLine().split(" ");
            int j1 = Integer.parseInt(input[0]);
            int j2 = Integer.parseInt(input[1]);

            //read the ki and kj limits
            input = br.readLine().split(" ");
            int k1 = Integer.parseInt(input[0]);
            int k2 = Integer.parseInt(input[1]);

            //number of generations
            int G = Integer.parseInt(br.readLine());

            //Iterate for each generation
            while (G-- > 0) {
                /**
                 * Process the grid cell one by one
                 * and check the num of infected cells in the neighbour of current cell
                 *
                 * in a grid a cell(X,Y) can have at most 8 neighbours
                 * TOP          (X-1,Y+0) ,
                 * BOTTOM       (X+1,Y+0) ,
                 * LEFT         (X+0,Y-1) ,
                 * RIGHT        (X+0,Y+1)
                 * TOP-LEFT     (X-1,Y-1) ,
                 * TOP-RIGHT    (X-1,Y+1) ,
                 * BOTTOM-LEFT  (X+1,Y-1) ,
                 * BOTTOM-RIGHT (X+1,Y+1)
                 *
                 * NOTE: X is row number Y is column number
                 */
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        int infectedNeighbour = 0;
                        for (int neighbour[] : neighbours) {
                            int newx = row + neighbour[0];
                            int newy = col + neighbour[1];
                            if (newx >= 0 && newx < rows && newy >= 0 && newy < cols && bacteriaCurrentState[newx][newy] == 1) {
                                infectedNeighbour++;
                            }
                        }

                        bacteriaNextGenState[row][col] = bacteriaCurrentState[row][col];
                        if (bacteriaCurrentState[row][col] == 1) {
                            //if number of infected neighbours are not in limits then change the cell infection value in next generation
                            if (!(infectedNeighbour >= j1 && infectedNeighbour <= j2)) {
                                bacteriaNextGenState[row][col] = 0;
                            }
                        } else {

                            if (infectedNeighbour >= k1 && infectedNeighbour <= k2) {
                                bacteriaNextGenState[row][col] = 1;
                            }
                        }
                    }
                }
                //change the next gen to current gen
                byte temp[][] = bacteriaCurrentState;
                bacteriaCurrentState = bacteriaNextGenState;
                bacteriaNextGenState = temp;
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(bacteriaCurrentState[row][col]);
                }
                System.out.println();
            }
        }
    }
}
