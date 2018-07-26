package HackerEarth;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by maninder on 19/10/16.
 */
public class Waiter {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        int q = s.nextInt();

        Stack<Integer> A[] = new Stack[2];
        Stack<Integer> B[] = new Stack[q];
        A[0] = new Stack<>();
        A[1] = new Stack<>();
        for (int i = 0; i < q; i++) {
            B[i] = new Stack<>();
        }
        int primes[] = getPrimes(q);




    }

    static int[] getPrimes(int n) {
        int prime[] = new int[n];
        prime[0] = 2;
        if (n == 1) {
            return prime;
        } else {
            int num = 3;
            int status=1;
            for (int i = 1 ; i < n; ) {
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        status = 0;
                        break;
                    }
                }
                if (status != 0) {
                    prime[i]=num;
                    i++;
                }
                status = 1;
                num++;
            }
        }
        return prime;
    }


}



