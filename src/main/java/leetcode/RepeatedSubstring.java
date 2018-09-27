package leetcode;

public class RepeatedSubstring {

    public static void main(String[] args) {
        System.out.println(hasRepeatedSubString("abaababaab"));
    }


    static boolean hasRepeatedSubString(String str) {
        int i = 0;
        int subEnd = 0;
        boolean subEndSet = false;
        for (int j = 1; j < str.length(); j++) {
            if (str.charAt(j) == str.charAt(i)) {
                i++;
                if (!subEndSet) {
                    subEndSet = true;
                    subEnd = j - 1;
                    if (str.length() == 2 && j == 1) {
                        return true;
                    }
                } else if (i > subEnd) {
                    i = 0;
                }
            } else {
                i = 0;
                subEndSet = false;
                if (str.charAt(j) == str.charAt(i)) {
                    i++;
                    if (!subEndSet) {
                        subEndSet = true;
                        subEnd = j - 1;
                    }
                }
            }
        }
        if (i == 0) {
            return subEndSet;
        }
        return false;
    }

}
