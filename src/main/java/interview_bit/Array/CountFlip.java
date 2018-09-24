package interview_bit.Array;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/flip/
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
 * <p>
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 * <p>
 * Notes:
 * <p>
 * Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 * For example,
 * <p>
 * S = 010
 * <p>
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | 110
 * [1 2]          | 100
 * [1 3]          | 101
 * [2 2]          | 000
 * [2 3]          | 001
 * <p>
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [
 */
public class CountFlip {

    public static void main(String[] args) {
        ArrayList<Integer> flip = new CountFlip().flip("010");
        for (Integer o : flip) {
            System.out.println(o);
        }
    }

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A.indexOf("0") == -1) return list;

        Stack<Integer> flips = new Stack<>();
        int max = 0;

        int maxStart = 0;
        int maxEnd = 0;

        int currentStart = 0;

        boolean clear = true;

        for (int i = 1; i <= A.length(); i++) {
            if (A.charAt(i - 1) == '1') {
                if (flips.empty()) {
                    clear = true;
                    continue;
                }
                flips.pop();

            } else {
                if (flips.empty() && clear) {

                    currentStart = i;
                    clear = false;
                }
                flips.push(i);
                if (flips.size() > max) {
                    max = flips.size();
                    maxStart = currentStart;
                    maxEnd = i;
                }
            }
        }

        list.add(maxStart);
        list.add(maxEnd);

        return list;
    }
}
