package circleForLife;

class Solution {
    private final char J_PIECE = 'O';

    public static void main(String[] args) {
        String input[] = {"............",
                        "............",
                "............",
                "............",
                "..X.X...X...",
                "............",
                "..X.X.XXX...",
                ".....X......",
                "..X.X.XXX...",
                "............",
                "....X.X.....",
                ".....O......"
        };



        Solution s = new Solution();


        System.out.println(s.solution(input));

    }

    public int solution(String[] B) {

        char[][] arr = new char[B.length][B.length];
        int jX=0,jY=0;
        for(int i=0;i<B.length;i++)
        {
            arr[i] = B[i].toCharArray();
            if(B[i].contains(J_PIECE+""))
            {
                jX = i;
                jY = B[i].indexOf(J_PIECE);
            }
        }

        int getMaxBeat = getMaxBeat(arr,jX,jY,0);




        return getMaxBeat;
    }

    private int getMaxBeat(char[][] arr, int jX, int jY, int i) {
        if(jX>=0 && jY>=0 && jY<arr.length)
        {
            int maxLeft =i;
            if(jX-1 > 0 && jY-1>0  && arr[jX-1][jY-1] == 'X' && arr[jX-2][jY-2] == '.')
            {
                maxLeft = getMaxBeat(arr, jX - 2, jY - 2, i + 1);
            }
            int maxRyt = i;
            if(jX-1 > 0 && jY+2<arr.length && arr[jX-1][jY+1] == 'X' && arr[jX-2][jY+2] == '.') {
                maxRyt = getMaxBeat(arr, jX - 2, jY + 2, i + 1);
            }

            return Math.max(maxLeft,maxRyt);
        }
        else{
            return i;
        }

    }
}