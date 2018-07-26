package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by maninder on 16/11/16.
 */
public class StackFindMaxSignal
{
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            String arrs[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = Integer.parseInt(arrs[i]);
            }
            for(int i=0;i<n;i++)
            {
                if(s.isEmpty())
                {
                    s.push(i);
                }
                else
                {
                    int topIndex = s.peek();
                    if(arr[i]<arr[topIndex])
                    {
                        s.push(i);
                    }
                    else
                    {
                        while(!s.empty()  && arr[topIndex]<arr[i] )
                        {
                            int topElement = s.pop();
                            if(s.empty())
                            {
                                topIndex=-1;
                            }
                            else
                            {
                                topIndex=s.peek();
                            }

                            arr[topElement]=topElement-topIndex;
                        }
                        s.push(i);

                    }
                }
            }
            int topIndex;
            while(!s.empty())
            {

                int topElement = s.pop();
                if(s.empty())
                {
                    topIndex=-1;
                }
                else
                {
                    topIndex=s.peek();
                }
                arr[topElement]=topElement-topIndex;
            }

           for(int i=0;i<n;i++)
           {
               sb.append(arr[i]+" ");
           }
           sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
