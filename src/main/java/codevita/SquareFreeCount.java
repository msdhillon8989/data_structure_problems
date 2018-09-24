package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SquareFreeCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //get all factors fo a number
        Set<Integer> factors = getFactors(n);

        int count = 0;
        //Process all factors one by one
        for (int i : factors) {
            //not squareFree number so skip
            if (i == 1 || i == n) {
                continue;
            }
             // factor is perfect square then its not square free number , so skip
            if (isPerfectSquare(i)) {
                continue;
            }

            // if any of the factor of I is perfect square then its not square free
            boolean isSquareFree = true;
            Set<Integer> ff = getFactors(i);
            for (int f : ff) {
                if (isPerfectSquare(f)) {
                    isSquareFree = false;
                }
            }
            if (isSquareFree) {
                count++;
            }
        }

        System.out.print(count);


    }

    private static boolean isPerfectSquare(int f) {
        if (f == 1) return false;

        double sr = Math.sqrt(f);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }

    static Set<Integer> getFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }
        return factors;
    }


}
