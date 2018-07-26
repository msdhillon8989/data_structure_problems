package hackerearth.practice;


import java.io.IOException;

import java.util.Scanner;

public class MMTPosition {

	public static void main(String[] args) throws IOException 
	{
		int posOfNumber[]  = new int[200001];
		int numbers[]  = new int[100001];
		
		int maxNum=0;
		  Scanner sc = new Scanner(System.in);
	        
	        int N = sc.nextInt();
	        int Q = sc.nextInt();
	        for (int i = 1; i <= N; i++) 
	        {
	        	int num = sc.nextInt();
	        	numbers[i]= num;
	        	posOfNumber[num]=i;
	        	if(num>maxNum)
	        		maxNum=num;	
	        }
	        
	        
	        for(int i=0;i<Q;i++)
	        {
	        	int task = sc.nextInt();
	        	if(task==0)
	        	{
	        		int x = sc.nextInt();
	        		int y = sc.nextInt();
	        		
	        		
	        		int numAtX = numbers[x];
	        		
	        		posOfNumber[numAtX]=0;
	        		
	        		numbers[x]=y;
	        		posOfNumber[y]=x;
	        		if(y>maxNum)
	        		{
	        			maxNum=y;
	        		}
	        		
	        	}
	        	else
	        	{
	        		boolean found =false;
	        		int numToFind=sc.nextInt();
	        		int pos =-1;
	        		if(numToFind<=maxNum)
	        		{	
	        			
	        			for(int n=numToFind;n<posOfNumber.length&&n<=maxNum;n++)
	        			{
	        				
	        				if(posOfNumber[n]!=0 )
	        				{
	        					pos=posOfNumber[n];
	        					numToFind=n;
	        					found=true;
	        					break;
	        					
	        				}
	        				
	        			}
	        			
	        		}
	        		if(!found)
	        		{
	        			System.out.println("-1");
	        		}
	        		else
	        		{
	        			for(int x =1;x<=pos;x++)
	        			{
	        				if(numbers[x]>numToFind)
	        				{
	        					pos=x;
	        					break;
	        				}
	        			}
	        			System.out.println(pos);
	        		}
	        	}
	        }
		
		
	}

}
