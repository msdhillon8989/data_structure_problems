package Array;

import java.util.Scanner;

public class DynamicArray {

	static   int []increaseSizeOfArray(int []arr){
	    int []brr=new int[(arr.length*2)];
	    for (int i = 0; i < arr.length; i++) {
	    	brr[i]=arr[i];     
	    }
	    return brr;
	}
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	     int total = in.nextInt();
	     int q = in.nextInt();
		 
		 int seq[][]  =  new int[total][16];
		 int lastIndex[] = new int[total];
		 int lastAns =0;
		 while(q-->0)
		 {
			 int type = in.nextInt();
			 int x = in.nextInt();
			 int y = in.nextInt();
			 int index = (x ^ lastAns)%total;
			  if(type == 1)
			  {
				  
				  
				  if(seq[index].length<=lastIndex[index])
				  {
					  seq[index] = increaseSizeOfArray(seq[index]);
				  }
				  
				  seq[index][lastIndex[index]]=y;
				  lastIndex[index]++;
			  }
			  else
			  {
				  lastAns = seq[index][y%lastIndex[index]];
				  System.out.println(lastAns);
			  }
			 
		 }
		 
		 

	}

}




