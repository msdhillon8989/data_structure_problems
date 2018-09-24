package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GemsGame {
    static final private Map<String, Data> memory = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String arr[] = br.readLine().split(" ");
            int[] array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();

            long maxValue = findMaxValue(0, array, true);
            System.out.println(maxValue);
        }

    }

    private static int findMaxValue(int i, int[] array, boolean superCard) {


        if (i >= array.length) {
            return 0;
        }

        int next = i+2;
        if(superCard)
        {
            next=i+1;

        }
        int max = findMaxValue(next, array, false) + (array[i]);

        int secondMax = findMaxValue(i + 1, array, true);
        if (secondMax > max)
            max = secondMax;


        secondMax = findMaxValue(i + 3, array, true) + array[i];
        if (secondMax > max)
            max = secondMax;

        int thirtMax = 0;
        if (i < array.length - 3) {
            thirtMax = array[i + 3] + findMaxValue(i + 4, array,true);
            if (thirtMax > max) {
                max = thirtMax;
            }
        }
        return max;
    }

    static class Data {
        private long sum;
        private boolean doubleUsed;

        public Data() {
            sum = 0;
            doubleUsed = false;
        }

        public long getSum() {
            return sum;
        }

        public void setSum(long sum) {
            this.sum = sum;
        }

        public boolean isDoubleUsed() {
            return doubleUsed;
        }

        public void setDoubleUsed(boolean doubleUsed) {
            this.doubleUsed = doubleUsed;
        }

        public Data incrementSum(int increment) {
            sum += increment;
            return this;
        }
    }
}
