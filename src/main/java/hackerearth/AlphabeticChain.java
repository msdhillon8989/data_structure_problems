package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by maninder on 15/10/16.
 */

class A
{
    public int minLenght;
    public int pos;
    public A next = null;
    A(int pos)
    {
        this.pos = pos;
        minLenght = Integer.MAX_VALUE;
    }
}
public class AlphabeticChain
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        A start = null;

        while(n-->0)
        {
            HashMap<Character,ArrayList<A>> newPos = new HashMap<>();
            for(Character a = 'a'; a<='z' ; a++)
            {
                newPos.putIfAbsent(a,new ArrayList<>());
            }

            String string = br.readLine();
            for(int i=0;i<string.length();i++)
            {
                Character c = string.charAt(i);
                newPos.get(c).add(new A(i));
            }
            int min = Integer.MAX_VALUE;
            for(A current: newPos.get('a'))
            {
                int minChainLenght = findMinChainLenght('b', current, newPos);
                if(min > minChainLenght)
                {
                    min = minChainLenght;
                    start = current;
                }
            }
            System.out.println(min);
            while(true)
            {
                System.out.print(start.pos+ " ");
                start = start.next;
                if(start==null)
                {
                    break;
                }
            }
            System.out.println();


        }

    }

    private static int findMinChainLenght(char a, A a1, HashMap<Character, ArrayList<A>> newPos) {
        for(A current : newPos.get(a))
        {
           if(a == 'z' )
           {
               current.minLenght=0;
           }
           else if (current.minLenght==Integer.MAX_VALUE && a!='z')
           {
               current.minLenght = findMinChainLenght((char)(a+1),current,newPos);
           }
           int distFromPrevious =  a1.pos - current.pos;
           if(distFromPrevious<0)
           {
               distFromPrevious*=-1;
           }
           if(a1.minLenght>distFromPrevious+current.minLenght)
           {
               a1.next = current;
               a1.minLenght = distFromPrevious + current.minLenght;
           }
        }
        if(a1.minLenght==Integer.MAX_VALUE)return 0;
        return a1.minLenght;
    }
}
