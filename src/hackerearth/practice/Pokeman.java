package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Pokeman {

	 public static void main(String args[] ) throws Exception {
	       

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	            int ponds = Integer.parseInt(br.readLine());
	            HashMap<String,Integer> has = new HashMap<>(); 
	            int carry=0;
	            for(int j=0;j<ponds;j++)
	            {
	            	String currentPond[] = br.readLine().split(" ");
	            	Integer foodCount=has.get(currentPond[0]);
	            	if(foodCount==null)
	            	{
	            		has.put(currentPond[0], 1);
	            	}
	            	else
	            	{
	            		has.put(currentPond[0], ++foodCount);
	            	}
	            	
	            	foodCount=has.get(currentPond[1]);
	            	if(foodCount==null)
	            	{
	            		carry++;
	            	}
	            	else
	            	{
	            		if(foodCount==1)
	            		{
	            			has.remove(currentPond[1]);
	            		}
	            		else
	            		{
	            			has.put(currentPond[1], --foodCount);
	            		}
	            	}
	            	
	            	
	            	
	            	
	            }
	            System.out.println(carry);
	        }
	       
	                
	        

	    
	    }

}
