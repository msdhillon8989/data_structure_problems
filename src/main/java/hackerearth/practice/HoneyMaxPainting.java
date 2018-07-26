package hackerearth.practice;

import java.util.Scanner;
/**
 * 
 * @author simanind
 *  
 */
public class HoneyMaxPainting {

	public static void main(String[] args) 
	{
		 Scanner sc = new Scanner(System.in);
		  
		 int N = sc.nextInt();
		 for(int i=0;i<N;i++)
		 {
			 int total=0;
			 int x = sc.nextInt();
			 int y = sc.nextInt();
			 int z = sc.nextInt();
			 
			 total+=x/3;
			 total+=y/3;
			 total+=z/3;
			 x%=3;
			 y%=3;
			 z%=3;
			 
			 
			 int min = x<y ? (x<z?x:z) : (y<z?y:z);
			 
			 total+=min;
			// x-=min;
			// y-=min;
			// z-=min;
			 
			 //total+=x/3;
			// total+=y/3;
			// total+=z/3;
			 
			 System.out.println(total);
			 
		 }
		 
	     
	      
	}

}
