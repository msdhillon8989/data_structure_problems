package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeVitaObstacleGame {


    static final int neighbours[][] = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0}, {1, 0},
            {-1, 1}, {0, 1}, {1, 1}
    };
    static private Set<String> OBSTACLES = new HashSet<>();

    public static void main(String[] args) throws IOException {
        OBSTACLES.add("L");
        OBSTACLES.add("S");
        OBSTACLES.add("S");
        OBSTACLES.add("T");
        OBSTACLES.add("W");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String[][] area = new String[N][N];
        //populate the grid
        for (int i = 0; i < N; i++) {
            area[i] = br.readLine().split(" ");
        }

        // processArea(0, 0, area);
        int startX = 0;
        int startY = 0;

        boolean routeFound = false;
        //[0,0] is A starting point
        //Find first R Route in grid in the neighbour of [0,0]
        if (area[1][0].equals("R")) {
            startX = 1;
            startY = 0;
            routeFound=true;
        } else if (area[1][1].equals("R")) {
            startX = 1;
            startY = 1;
            routeFound=true;
        } else if (area[0][1].equals("R")) {
            startX = 0;
            startY = 1;
            routeFound=true;
        }


        //If R not found then find D Destination
        if(!routeFound)
        {
            if (area[1][0].equals("D")) {
                startX = 1;
                startY = 0;

            } else if (area[1][1].equals("D")) {
                startX = 1;
                startY = 1;

            } else if (area[0][1].equals("D")) {
                startX = 0;
                startY = 1;

            }
        }

        //Start the process to print the Obstacles on the route
        processArea(startX, startY, area);

    }

    private static void processArea(int x, int y, String[][] area) {
        List<String> obstacleFound = new ArrayList<>();
        int nextX = -1;
        int nextY = -1;

        if (area[x][y].equals("D")) {
            System.out.println("DESTINATION");
        } else if (area[x][y].equals("R")) {
            //update cell value to M to not process that again
            area[x][y] = "M";

            //Process all the neighbour of current cell and save all the obstacles in list
            //change the nextX and NextY if R of D is found
            for (int neighbour[] : neighbours) {
                int newx = x + neighbour[0];
                int newy = y + neighbour[1];
                if (newx >= 0 && newx < area.length && newy >= 0 && newy < area.length) {
                    if (OBSTACLES.contains(area[newx][newy])) {
                        obstacleFound.add(area[newx][newy]);
                    } else if (area[newx][newy].equals("R") || area[newx][newy].equals("D")) {
                        nextX = newx;
                        nextY = newy;
                    }
                }
            }

            if (obstacleFound.size() == 0) {
                System.out.println("NO HURDLES");
            } else {
                Collections.sort(obstacleFound);

                for (String s : obstacleFound) {
                    System.out.print(s + " ");
                }
                System.out.println();
                //Process area for next route or destination
                processArea(nextX, nextY, area);
            }
        }
    }


}
