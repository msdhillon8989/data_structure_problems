package hackerrank;

import java.util.Scanner;

public class EqualStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int index1=0;
        int index2=0;
        int index3=0;
        
        long max1 = 0,max2 =0,max3=0; 
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            max1+=h1[h1_i];
            
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            max2+=h2[h2_i] ;
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            max3+=h3[h3_i];
        }
        
        while( (max1!=max2) || (max2!=max3)  )
        {
        if(max1 != max2 )
        {
        	if(max1<max2)
        	{
        		max2=max2-h2[index2++];
        	}
        	else {
        		max1=max1-h1[index1++];
        	}
        }
        
        if(max2 != max3)
        {
        	if(max3<max2)
        	{
        		max2=max2-h2[index2++];
        	}
        	else {
        		max3=max3-h3[index3++];
        	}
        }
        }
        
        System.out.println(max1);
        
    }
}
