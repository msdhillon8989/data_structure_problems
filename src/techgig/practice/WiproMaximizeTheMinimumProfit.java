package techgig.practice;

import java.util.ArrayList;


public class WiproMaximizeTheMinimumProfit {

	
	 public static String[] amount_value(int input1,String[] input2)
	    {
	        ArrayList <String>arr = new ArrayList<>();
	        
	        
	        int mx[][] = new int[input1][input1];
	        
	        
	        for(int i=0;i<input2.length;i++)
	        {
	        	String vals[] = input2[i].split("#");
	        	for(int c=0;c<vals.length;c++ )
	        	{
	        		mx[i][c]=Integer.parseInt(vals[c]);
	        	}
	        }
	        
	        int currentMax=0;
	        int pos[][] = {	
	        				{-1,-1},
		    				{-1, 0},
		    				{-1, 1},
		    				{0,-1},
		    				{0, 1},
		    				{1,-1},
		    				{1, 0},
		    				{1, 1}
		    			};
	        
	        for(int r=0;r<input1;r++)
	        {
	        	for(int c =0;c<input1;c++)
	        	{
	        		int min = mx[r][c];
	        		
	        		
	        		for(int i=0;i<pos.length;i++)
	        		{
	        			try{
	        			int num =mx[r+pos[i][0]][c+pos[i][1]];
	        			if(min>num)
	        			{
	        				min=num;
	        			}
	        			}catch(Exception x)
	        			{
	        				
	        			}
	        		}
	        		
	        		if(min>=currentMax)
	        		{
	        			if(min!=currentMax)
		        			arr.clear();
		        			
	        			currentMax=min;
	        			String position = (r+1)+"#"+(c+1);
	        			arr.add(position);
	        		}
	        		
	        	
	          		
	        	}
	        
	        }
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        String res[] = new String[arr.size()];
	        
	        int i=0;
	        for(String s : arr)
	        {
	        	res[i++]=s;
	        }
	        
	        
	        return res;
	    }
	
	public static void main(String[] args) {
		String input2[] = {
							"12#45#33#27",
							"95#54#29#53",
							"98#59#27#62",
							"11#51#67#27"
							};
	   String result[] = amount_value(4,input2);
	   for(String res:result)
	   {
		   System.out.println(res);
	   }

	}

}
