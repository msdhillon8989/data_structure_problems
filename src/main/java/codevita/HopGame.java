package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HopGame {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Read first line for total number of stones . One can use this number to init the array for storing stones values but m not using that
        Integer N = Integer.parseInt(br.readLine());
        //Read next line for values fo stones
        String arr[] = br.readLine().split(",");
        int[] array = Arrays.asList(arr).stream().map(Integer::parseInt).mapToInt(i -> i).toArray();
        //above code is reading the string line then converting into string array and finally into integer array

        long maxValue = findMaxValue(0, array, false).getSum();
        System.out.println(maxValue);

    }

    /**
     * Recursive function to calculate max value.
     * It will return the data type object.
     * Data class is static class declared in same class
     */
    private static Data findMaxValue(int i, int[] array, boolean doubleUsed) {
        Data noJump = new Data();
        if (i >= array.length) {
            return noJump;
        }

        //find the max stone value from next stone and add the current stone value
        noJump = findMaxValue(i + 1, array, doubleUsed).incrementSum(array[i]);

        Data singleJump = null;
        //skip the ith stone and find the max value from 1+2th stone then add the double value of i+1 stone
        if (i < array.length - 1) {
            singleJump = findMaxValue(i + 2, array, doubleUsed || noJump.doubleUsed).incrementSum(2 * array[i + 1]);
        }

        Data doubleJump = null;
        //skip the ith and i+1 stone and find the max value from 1+3th stone then add the triple value of i+2 stone
        //this double jump can be used for once only
        //so use the doubleUsed boolean to make sure that.
        if (i < array.length - 2 && !doubleUsed && !singleJump.doubleUsed) {
            doubleJump = findMaxValue(i + 3, array, true).incrementSum(3 * array[i + 2]);
            doubleJump.setDoubleUsed(true);

        }

        //find the max value among no jump , single jump and double jump and return
        Data maxData = noJump;
        if (singleJump != null) {
            maxData = singleJump.getSum() > noJump.getSum() ? singleJump : noJump;
        }

        if (doubleJump != null) {
            maxData = doubleJump.getSum() > maxData.getSum() ? doubleJump : maxData;
        }



        return maxData;

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
