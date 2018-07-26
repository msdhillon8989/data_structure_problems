package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class AmazonSumOfMaxEdge {
	
	public static void main(String args[] ) throws Exception {
	       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
       
        for (int i = 0; i < N; i++) 
        {
           int nodes = Integer.parseInt(br.readLine());
           int mtx[][] = new int [nodes][nodes]; 
           
           for(int node=0;node<nodes-1;node++)
           {
        	   String edge[] = br.readLine().split(" ");
        	   int n1 = Integer.parseInt(edge[0]);
        	   int n2 = Integer.parseInt(edge[1]);
        	   int w = Integer.parseInt(edge[2]);
        	   
        	   mtx[n1-1][n2-1]=w;
        	   
           }
           
           for(int n1=0;n1<nodes;n1++)
           {
        	  for(int n2=0;n2<nodes;n2++) 
        	  {
        		  if(n1==n2)
        		  {
        			  continue;
        		  }
        		  if(mtx[n1][n2]==0)
        		  {
        			  mtx[n1][n2]=findMax(n1,n2,mtx);
        		  }
        	  }
           }
           
           int sum=0;
           for(int n1=0;n1<nodes;n1++)
           {
        	  for(int n2=n1+1;n2<nodes;n2++) 
        	  {
        		  sum+=mtx[n1][n2];
        		  sum%=1000000007;
        	  }
           }
           System.out.println(sum);
        }
       
    }

	private static int findMax(int n1, int n2, int[][] mtx) {
		
		if(n1>n2)
		{
			int temp=n1;
			n1=n2;
			n2=temp;;
		}
	
		if(mtx[n1][n2]!=0)
			return mtx[n1][n2];
		for(int i=0;i<mtx.length;i++)
		{
			if(mtx[n1][i]!=0)
			{
				int current = mtx[n1][i];
				int maxEdge = findMax(i, n2, mtx);
				if(maxEdge!=0)
				{
					return current>maxEdge?current:maxEdge;
				}
			}
		}
		
		return 0;
	}

	
}
