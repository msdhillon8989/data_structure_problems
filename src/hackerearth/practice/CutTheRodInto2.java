package hackerearth.practice;

import java.util.Scanner;

public class CutTheRodInto2 {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		for(int i=0;i<n;i++)
		{
			int num = s.nextInt();
			int count=0;
			int num1=0,num2=0;
			
			if(num%2==1&&num>1)
			{
				count++;
			}
			while(num!=1)
			{
				if(num%2==1)
				{
					
					num1=num/2;
					num2=num1+1;
				}
				else
				{
					num1=num2=num/2;
					
					
				}
				num=num1;
				if(num1==1)break;
				if(num1%2==1)
				{
					count++;
				}
				if(num2%2==1)
				{
					count++;
				}
				
				System.out.println(num1+"   "+num2);
			}
			System.out.println(count);
		}

	}

}

// 127 63  31  15  7  3 1 
//  64 32  16  8   4  2   

/**
 *  1
 *  2   3     1
 *  5   5     1 
 *  10  11    1 
 *  21  21    1
 *  42  43    1
 *  85  85    1
 *  170 171   1
 *  341 341   1
 *  682 682   
 *  1364 
 *  
 *      
 *  11    1
 *  5   6 1
 *  2   3
 *  
 */





