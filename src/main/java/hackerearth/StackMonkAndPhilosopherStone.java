package HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by maninder on 16/11/16.
 */
public class StackMonkAndPhilosopherStone
{
    public static void main(String[] args) throws  Exception
    {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        Stack<Integer> hs = new Stack<>();
        String arrs[] = br.readLine().split(" ");

        for(int i=n-1;i>=0;i--)
        {
           hs.push(Integer.parseInt(arrs[i]));
        }
        String query[] = br.readLine().split(" ");
        int calls = Integer.parseInt(query[0]);
        int x = Integer.parseInt(query[1]);
        int maxValue=0;
        int coinFromHarry=0;
        while(calls-->0)
        {
            String turn = br.readLine();
            if(turn.equals("Harry"))
            {
                if(hs.empty())
                {
                    System.out.println("-1");
                    break;
                }
                else
                {
                    coinFromHarry = hs.pop();
                }

                maxValue+=coinFromHarry;

                if (maxValue==x)
                {
                    System.out.println(s.size()+1);
                    break;
                }

                s.push(maxValue);
            }
            else
            {
                if(!s.empty())
                {
                    s.pop();
                    maxValue=s.peek();
                }

            }
        }
       if (calls==-1 && maxValue!=x)
        {
            System.out.println("-1");
        }

    }
}
