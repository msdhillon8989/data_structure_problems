package HeloDoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;


/**
 * number A in decimal format is represented as (An An-1 An-2 .... A2 A1)
 * eg Number A = 3456
 * here n =4
 * A4 = 3
 * A3 = 4
 * A2 = 5
 * A1 = 6
 * <p>
 * PowerSum(A) = [2^(n-1) x An]  + [2^(n-2) x An-1]  ...... [2^1 x A2]  + [2^0 x A1]
 * PowerSum(3456) =  [2^3 * 3]  +  [2^2 * 4]  +  [2^1 * 5]  +  [2^0 *6]
 * 24          +   16         +  10        +  6 =   56
 * <p>
 * Print count of number from 0 to N having PowerSum <= PowerSum(K)
 * <p>
 * Input
 * First line Integer T = total test cases
 * Next T lines contains K and N
 */

public class PowerSum {
    private static HashMap<Long, Long> powerSumValue = new HashMap<>();
    private static HashMap<Long, Long> powerValueMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        populatePowerValueMap();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] inp = br.readLine().split(" ");
            long K = Long.parseLong(inp[0]);
            long N = Long.parseLong(inp[1]);
            long out_ = solve(K, N);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }


    private static void populatePowerValueMap() {
        long powerValue = 1;
        powerValueMap.put(0L, 1L);
        for (long i = 1; i < 17; i++) {
            powerValue = powerValue << 1;
            powerValueMap.put(i, powerValue);
        }
    }

    static long getPowerSum(long a) {
        if (powerSumValue.containsKey(a)) {
            return powerSumValue.get(a);
        }
        long n = 0;
        long key = a;

        long powerSum = 0;
        while (a > 0) {
            long pValue = powerValueMap.get(n);
            int digit = (int) (a % 10);
            a = a / 10;
            n++;
            powerSum += pValue * digit;
        }
        powerSumValue.put(key, powerSum);
        return powerSum;
    }

    static long solve(long K, long N) {
        long kPowerSum = getPowerSum(K);

        long count = 0;
        for (long i = 0; i <= N; i++) {
            if (getPowerSum(i) <= kPowerSum) {
                count++;
            }
        }
        return count;
    }
}