package gfg;

public class Knapsack {
    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSackMemory(W, wt, val, n));

        System.out.println(knapSackRecursive(W,wt,val,n));
    }

    private static int knapSackMemory(int W, int[] wt, int[] val, int N) {
        int K[][] = new int[N+1][W+1];


        for(int i=0;i<=N;i++)
        {
            for (int w = 0; w <= W; w++) {
                if(i==0 || w==0)
                {
                    K[i][w] =0;
                }
                else if(wt[i-1]<=w)
                {
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],K[i-1][w]);
                }
                else{

                    K[i][w] = K[i-1][w];
                }
            }
        }
return K[N][W];

    }

    private static int max(int i, int i1) {
     return i>i1?i:i1;

    }

    private static int knapSackRecursive(int w, int[] wt, int[] val, int i) {

                if(i==0 || w<=0)
                {
                    return 0;
                }
                else if(wt[i-1]<=w)
                {
                    return max(knapSackRecursive(w-wt[i-1],wt,val,i-1)+val[i-1]
                            ,knapSackRecursive(w,wt,val,i-1));
                }
                else{

                    return knapSackRecursive(w,wt,val,i-1);
                }
    }
}
