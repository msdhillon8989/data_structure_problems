package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Summation {
	
	public static void main(String args[] ) throws Exception {
	       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int sum=0;
        Stack s = new Stack<Integer>();
        for (int i = 0; i < N; i++) 
        {
            int current = Integer.parseInt(br.readLine());
            
             
            if(current==0)
            {
            	if(!s.empty())
            		{
            			current=(Integer)s.pop();
            			sum-=current;
            		}
            	
            }
            else
            {
            	s.push(current);
            	sum+=current;
            }
        }
        
        
        

        System.out.println(sum);
    }
}
