package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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



public class MMTSubstringCount2 {

	static String  pos[] = new String[26];
    
	public static int countSub(char X ,char Y)
	{
		int total = 0;
		StringTokenizer st1 = new StringTokenizer(pos[X-'a'],";");
		
		int maxPosOfY=1000000;
		while(st1.hasMoreTokens())
		{
			StringTokenizer xst = new StringTokenizer(st1.nextToken(),":");
			int x1pos = Integer.parseInt(xst.nextToken());
			int xcount = Integer.parseInt(xst.nextToken());
			if(maxPosOfY<x1pos)
				break;
			StringTokenizer st2 = new StringTokenizer(pos[Y-'a'],";");
			while(st2.hasMoreTokens())
			{
				StringTokenizer yst = new StringTokenizer(st2.nextToken(),":");
				int y1Pos = Integer.parseInt(yst.nextToken());
				int ycount = Integer.parseInt(yst.nextToken());
				if(x1pos<y1Pos)
				{
					
					total+=(xcount*ycount);
				}
				if(x1pos==y1Pos)
				{
					total+=xcount-1;
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
	        	pos[i]="";
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
	        		pos[c-'a']+=currentCharFirstPosition+":"+currentCount+";";
	        		c=currentChar;
	        		currentCharFirstPosition=i;
	        		currentCount=1;
	        	}
	        	else
	        	{
	        		currentCount++;
	        	}
	        }
	        
	        pos[c-'a']+=currentCharFirstPosition+":"+currentCount+";";
	        
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
