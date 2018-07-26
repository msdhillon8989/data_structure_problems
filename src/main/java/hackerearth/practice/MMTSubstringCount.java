package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * input
 * 5 
 * aacbb
 * 2
 * a c
 * a b
 * 
 * output
 * 2    (aac,ac)
 * 4    (aacbb,aacb,acbb,acb)
 * 
 *
 */



class A
{
   public 	int pos=0;
   public 	int count=0;
   
   
public A(int pos, int count) {
	super();
	this.pos = pos;
	this.count = count;
}
  
   
}


public class MMTSubstringCount {

	static ArrayList<A> pos[] = (ArrayList<A>[]) new ArrayList[26];
    
	public static int countSub(char X ,char Y)
	{
		Object o = 1;
		int total = 0;
		ArrayList<A> listx = pos[X-'a'];
		ArrayList<A> listy = pos[Y-'a'];
		
		int maxPosOfY=1000000;
		
		for(A x : listx)
		{
			
			int x1pos = x.pos;
			int xcount = x.count;
			if(maxPosOfY<x1pos)
				break;
			
			for(int i=listy.size()-1;i>=0;i--)
			{
				A y = listy.get(i);
				int y1Pos = y.pos;
				int ycount = y.count;
				if(x1pos<y1Pos)
				{
					
					total+=(xcount*ycount);
				}
				if(x1pos==y1Pos)
				{
					total+=xcount-1;
				}
				if(x1pos>y1Pos)
				{
					break;
				}
				maxPosOfY=y1Pos;
				
			}
			
		}
		
		
		return total;
	}
	
	public static void main(String[] args) throws IOException 
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        String string = br.readLine();
	        for(int i=0;i<26;i++)
	        {
	        	pos[i]=new ArrayList<A>();
	        }
	        
	        char c = string.charAt(0);
	        int currentCount=1;
	        char currentChar =c;
	        int currentCharFirstPosition=0;
	        for (int i = 1; i < N; i++) 
	        {
	        	currentChar = string.charAt(i);
	        	if(currentChar!=c)
	        	{
	        		pos[c-'a'].add(new A(currentCharFirstPosition,currentCount));
	        		c=currentChar;
	        		currentCharFirstPosition=i;
	        		currentCount=1;
	        	}
	        	else
	        	{
	        		currentCount++;
	        	}
	        }
	        
	        pos[c-'a'].add(new A(currentCharFirstPosition,currentCount));
	        
	        int Q = Integer.parseInt(br.readLine());
	        for(int i=0;i<Q;i++)
	        {
	        	String query = br.readLine();
	        	char X = query.charAt(0);
	        	char Y = query.charAt(2);
	        	int total = countSub(X, Y);
	        	if(X!=Y)
	        	total+=countSub(Y, X);
	        	System.out.println(total);
	        	
	        }
	        
	        
	       
	        
	}

}
