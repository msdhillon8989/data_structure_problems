package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by maninder on 15/10/16.
 */
public class MinimumCost {
    public static void main1(String ar[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        int q = s.nextInt();
        while (q-- > 0) {
            int l = s.nextInt();
            int r = s.nextInt();
            int k = s.nextInt();

            int count = 0;
            for (int i = l - 1; i < r; i++) {
                if (arr[i] % k == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static int division(int x, int y) {
        /*int p = x;
        while(p<y) p<<=1;
        while(p>=x)
        {
            if(y>=p)
                y-=p;
            p>>=1;
        }
        */


        return x - y * (x / y);
    }

    public static void main2(String[] args) {
        int a = 9731;
        int b = 72;
        long start = System.nanoTime();
        int rem = getRemainderRecursive(a, b);
        long end = System.nanoTime();
        System.out.println("resursive "+(end-start)  );

        start = System.nanoTime();
        getRemainder(a,b);
        end = System.nanoTime();
        System.out.println("multiply "+(end-start) );

        start = System.nanoTime();
        int x=a%b;
        end = System.nanoTime();
        System.out.println("normal "+(end-start) );


        System.out.println(rem+" "+x);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cost[] = new int[n];
        int rs[] = new int[10001];
        String arr[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(arr[i]);
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String query[] = br.readLine().split(" ");
            int l = Integer.parseInt(query[0]);
            int r = Integer.parseInt(query[1]);
            int k = Integer.parseInt(query[2]);
            BigInteger kbig = new BigInteger(k + "");
            int num=0,pre=0;
            int count = 0;
            for (int i = l - 1; i < r; i++) {
                num = cost[i];
                pre=rs[num];
                if (pre==1) {
                    count++;
                } else if (pre==0) {

                    if (num%k == 0) {
                        rs[num]=1;
                        count++;
                    } else {
                        rs[num]=-1;
                    }

                }
            }
            System.out.println(count);
        }
    }

    static int  getRemainderRecursive(int x,int y)
    {
        if(x<y)
        {
            return x;
        }
        int m = getRemainderRecursive(x ,y<<1);
        if(m>=y)
           m=m-y;
        return m;
    }

    static int getRemainder(int num, int divisor) {
        int i = 1;
        int product = 0;
        while (product <= num) {
            product = divisor * i;
            i++;
        }
    return num - (product - divisor);
    }
}