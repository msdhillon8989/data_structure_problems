package demo;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by maninder on 21/11/16.
 */
class LatestQueue
{
    Stack<Integer> s1;
    Stack<Integer> s2;
    public LatestQueue()
    {
        s1= new Stack<>();
        s2 = new Stack<>();
    }

    public void add(int item)
    {
        s1.push(item);
    }

    public Integer poll()
    {
        if(s2.isEmpty())
        {
            fillS2();
        }
        if(s2.empty())
        {
            return null;
        }
        else
        {
            return s2.pop();
        }
    }

    private void fillS2()
    {
        while(!s1.empty())
        {
            s2.push(s1.pop());
        }
    }


    public boolean isEmpty()
    {
        return s1.isEmpty()&&s2.empty();
    }
}
public class QueueWithStack
{



    public static void main(String[] args) {
        LatestQueue queue = new LatestQueue();
        queue.add(2);
        queue.add(4);
        queue.add(6);
        queue.add(1);
        queue.add(5);

        while(!queue.isEmpty())
        {
            System.out.println(queue.poll());
        }

    }

}
