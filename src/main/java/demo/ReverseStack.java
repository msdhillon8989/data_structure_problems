package demo;

import java.util.Stack;

/**
 * Created by maninder on 14/11/16.
 */
public class ReverseStack
{
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {

        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        reverseStack();

        while(!stack.empty())
        {
            System.out.println(stack.pop());
        }

    }

    private static void reverseStack()
    {
        if(!stack.empty())
        {
            int current = stack.pop();
            reverseStack();
            insetAtBottom(current);
        }
    }

    private static void insetAtBottom(int current)
    {
        if(stack.empty())
        {
            stack.push(current);
        }
        else
        {
            int temp = stack.pop();
            insetAtBottom(current);
            stack.push(temp);
        }
    }

}
