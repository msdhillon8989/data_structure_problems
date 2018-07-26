package demos.interview;

import java.util.ArrayList;
import java.util.List;

public class MaxSumOfSubArray {


    private static int getMaxSum(List<Integer> a)
    {
        int maxS= Integer.MIN_VALUE;
        int currentSum =0;



        for(int n : a)
        {
            currentSum+=n;

            if(maxS<n)
            {
                maxS = n;
            }
            if(currentSum<n)
            {
                currentSum =n;

            }
            else {
                if(maxS<currentSum)
                {
                   maxS = currentSum;

                }
            }
        }
        return maxS;
    }
    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<Integer>();
        /*list.add(7);
        list.add(2);
        list.add(-10);
        list.add(5);
        list.add(31);
        list.add(-9);
        list.add(-7);
        list.add(16);
        list.add(-20);
        list.add(-16);
        list.add(35);
        list.add(-30);
        list.add(7);
        list.add(-2);
        list.add(10);
        list.add(-2);
        list.add(-4);
        list.add(-6);
        list.add(30);*/
       list.add(-4);
       list.add(-4);
       list.add(-3);
       list.add(-5);
       /*list.add(-1);
       list.add(2);
       list.add(1);
       list.add(-5);
       list.add(4);
*/
        System.out.println(getMaxSum(list));
    }
}
