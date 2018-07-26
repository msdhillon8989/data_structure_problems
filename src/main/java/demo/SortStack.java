package demo;

import java.util.Stack;

/**
 * Created by maninder on 21/11/16.
 */
public class SortStack
{
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(7);
        s.push(2);
        s.push(2);
        s = sortStack(s);
        while (!s.empty())
        {
            System.out.println(s.pop());
        }
    }
    private static Stack<Integer> sortStack(Stack<Integer> s)
    {
        Stack<Integer> p = new Stack<>();
        while(!s.empty())
        {
            int topElement = s.pop();
            while(!p.isEmpty() && p.peek()<topElement)
            {
                s.push(p.pop());
            }
           p.push(topElement);
        }
        return p;
    }
}
