package demos.interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatAndMissing {
    public static ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        long size = a.size();
        Long sum  = ((1+size) * size)/2;
        Set<Integer> nums = new HashSet<>();
        int A =0;
        int B =0;
        for(int n : a)
        {
            if(!nums.add(n))
            {
                A =n;
            }
            sum -=n;
        }
        sum+=A;
        B=sum.intValue();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(A);
        result.add(B);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(5);

        ArrayList<Integer> result  = repeatedNumber(list);
        System.out.println(result.get(0) + " "+result.get(1));
    }

}
