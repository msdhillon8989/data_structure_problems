package demo;

public class StringPermutation {

    public static void main(String[] args) {
        permutation("ABC",0,2);
    }

    static private void permutation(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                permutation(s, l + 1, r);
                s = swap(s, l, i);
            }

        }
    }

    static private String swap(String s, int l, int i) {
        char[] tempArr = s.toCharArray();
        char c = tempArr[l];
        tempArr[l] = tempArr[i];
        tempArr[i] = c;
        return String.valueOf(tempArr);
    }

}
