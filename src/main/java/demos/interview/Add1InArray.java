package demos.interview;

import java.util.ArrayList;

public class Add1InArray {

   static ArrayList<Integer> addOne(ArrayList<Integer> A)
    {
        ArrayList<Integer> newList = new ArrayList<Integer>();

        boolean carry =true;
        int last = 0;
        for(int i=A.size()-1;i>=0&&carry ;i--)
        {
            int current = A.get(i);
                if (current == 9) {
                    newList.add(0);
                } else {
                    newList.add(0,current+1);
                    carry=false;
                    last = i;
                }
        }
        if(carry)
        {
            newList.add(0,1);
            return newList;
        }
        else {

            int nonZero = 0;
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) != 0) {
                    nonZero = i;
                    break;
                }
            }

            for (int i = last-1; i >= nonZero; i--) {
                newList.add(0,A.get(i));
            }

        }

        return newList;
    }

    public static void main(String[] args) {
       ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(9);
        A.add(9);
        A.add(9);
        A.add(9);
        A.add(9);
        A.add(9);

        for(int i : A)
        {
            System.out.print(i+"");
        }
        System.out.println();
        A = addOne(A);

        for(int i : A)
        {
            System.out.print(i+"");
        }
        System.out.println();

    }
}
