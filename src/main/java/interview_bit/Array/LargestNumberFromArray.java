package interview_bit.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumberFromArray {

    static public String largestNumber(final List<Integer> A) {
        Comparator<Integer> comparator = (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            char[] ar1 = s1.toCharArray();
            char[] ar2 = s2.toCharArray();
            for (int i = 0; i < ar1.length; i++) {
                if (ar1[i] == ar2[i]) {
                    continue;
                }
                if (ar1[i] > ar2[i]) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;

        };


        A.sort(comparator);
        StringBuilder sb = new StringBuilder();
        for (Integer a : A) {
            if (!(a == 0 && sb.length() == 0))
                sb.append(a);
        }
        if (sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(101);
        arrayList.add(1);



        System.out.println(largestNumber(arrayList));
    }
}
