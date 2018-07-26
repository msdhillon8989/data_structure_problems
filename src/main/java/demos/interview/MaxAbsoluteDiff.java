package demos.interview;

import java.util.ArrayList;


public class MaxAbsoluteDiff {

    public static int maxArr(ArrayList<Integer> A) {
        int maxi =Integer.MIN_VALUE;
        int minj =Integer.MAX_VALUE;


        int I=0,J=0;

        int i2 =0;
        int j2 =0;
        for(int i=0;i<A.size();i++)
        {
            int n = A.get(i);
            if(n<=minj)
            {
                if(n<minj)
                {
                    J=i;
                }
                minj =n;
                j2=i;
            }

            if(n>=maxi)
            {
                if(n>maxi)
                {
                    I=i;
                }
                maxi=n;
                i2=i;
            }

        }

        int diff1= diff(I,j2);
        int diff2 = diff(J,i2);

        return (maxi - minj) + (diff1>diff2?diff1:diff2);

    }

    static int diff(int I,int J)
    {
        return I>J?I-J:J-I;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(55);
        list.add(-8);
        list.add(43);
        list.add(52);
        list.add(8);
        list.add(59);
        list.add(-91);
        list.add(-79);
        list.add(-18);
        list.add(-94);


        System.out.println(maxArr(list));
    }
}
