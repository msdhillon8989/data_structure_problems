package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreedyAddSubtract {
	

	public static void main(String[] args) throws IOException 
	{
		int count[] = new int[100];
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) 
	        {
	        	String inputs[] = br.readLine().split(" ");
	        	int n = Integer.parseInt(inputs[0]);
	        	int k = Integer.parseInt(inputs[1]);
	        	int maxCount = 0;
	        	int max=0;
	        	
	        	String nums[] = br.readLine().split(" ");
	        	for(int j = 0;j<n;j++)
	        	{
	        		int num = Integer.parseInt(nums[j]);
	        		
	        		count[num-1]++;
	        		int currentCount=count[num-1];
	        		
	        		if(currentCount>maxCount)
	        		{
	        			max=num;
	        			maxCount=currentCount;
	        		}
	        		
	        	}
	        	
	        }
	       

	}

}
