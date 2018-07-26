package hackerearth.practice;

import java.io.*;

public class JPMain1 {
    
  public static void main(String[] args) throws IOException 
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null) 
    {
      String nums[] = s.split(" ");
      
      int max  = nums[0].length() > nums[1].length() ?  nums[0].length() : nums[1].length();
      
      
      int num1[]  =  new int[max] ;
      int num2[]  =  new int[max] ;
      
      int num1Length = nums[0].length();
      int num2Length = nums[1].length();
      
      for(int i= 0;i< num1Length ;i++)
      {
          num1[i] = (int)(nums[0].charAt(num1Length-i-1)-'0');
          //System.out.print(num1[i]+" ");
      }
      
      System.out.println();
      for(int i= 0;i< num2Length ;i++)
      {
          num2[i] = (int)(nums[1].charAt(num2Length-i-1)-'0');
         // System.out.print(num2[i]);
      
      }
      
      
      int num3[] = new int[max+1]; 
      
      int  flag = 0;
      for(int i=0;i<max;i++)
      {
    	  int sum = num1[i]+num2[i]+flag ;
    	  
    	  switch(sum)
    	  {
    	  	case 0: flag =0;break;
    	  	case 1: flag = 0; num3[i]=1; break;
    	  	case 2: flag = 1; num3[i]=0; break;
    	  	case 3: flag = 1; num3[i]=3; break;
    	  	
    	  }
      }
      if(flag==1)
      {
    	  num3[max]=1;
      }
      
      flag =0;
      
      StringBuilder sb = new StringBuilder("");
      for(int i=max;i>=0;i--)
      {
    	  if(flag==1)
    	  {
    		  sb.append(num3[i]);
    	  }
    	  else if(num3[i]==1)
    	  {
    		  flag=1;
    		  sb.append(num3[i]);
    	  }
    	  
      }
      
      System.out.println(sb.toString());
      
      
      
      
    }
    
    
  }
  
  
}
