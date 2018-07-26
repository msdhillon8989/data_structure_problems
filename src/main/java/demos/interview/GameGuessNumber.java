package demos.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameGuessNumber {

    public static void main(String[] args) {
        Map<Integer,ArrayList<Integer>> entries = new HashMap<>();

        for(int i =0 ; i < 128;i++)
        {
            for(int bit = 0; bit<7;bit++) {
                int value =i;
                boolean isSet = ((value >> bit) & 1) != 0;
                if(isSet)
                {
                    ArrayList list = entries.get(bit);
                    if(list == null)
                    {
                        list = new ArrayList();
                        entries.put(bit,list);
                    }
                    list.add(i);
                }
            }
        }

        for(ArrayList<Integer> e : entries.values())
        {

            int colsize = (int)Math.sqrt(e.size());
            int items =0;
            for(int num : e)
            {

                System.out.print(num+"\t");
                items++;
                if(items%colsize==0)
                {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("--------------------------------");
        }

    }
}
