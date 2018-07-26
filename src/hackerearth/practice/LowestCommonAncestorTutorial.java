package hackerearth.practice;

import java.util.Scanner;

public class LowestCommonAncestorTutorial {

	public static void main(String[] args) 
	{
		int p[];// = {0, 0, 1, 1, 1, 2, 3, 4, 4};
		int n[];// = {9,7,8};
		int min;
		int max=0;
		
		
		Scanner s = new Scanner(System.in);
		int nodes = s.nextInt();
		
		p = new int[nodes];
		
		for(int i=0;i<nodes-1;i++)
		{
			p[i]=s.nextInt();
		}
		
		int nn = s.nextInt();
		n = new int[nn];
		min = nodes;
		for(int i=0;i<nn;i++)
		{
			n[i]=s.nextInt();
			if(n[i]<min)
			{
				min=n[i];
			}
			
		}
		
	
	
		
		while(min!=max)
		{
			max=0;
			for(int i=0;i<n.length;i++)
			{
				int cn = n[i];
				if(cn>min)
				{
					n[i]=p[cn-1];
					if(min>n[i])
					{
						min=n[i];
					}
				}
				if(cn>max)
				{
					max=cn;
				}
				
			}
		}
		
		
		System.out.println(min);
		

	}

}
