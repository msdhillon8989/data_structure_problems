package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import java.util.TreeSet;

public class MostSuggestedLaptop {

	public static void main(String args[] ) throws Exception {
		
		

	       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        HashMap<String, Integer> count = new HashMap<>();
      //  String mostSuggested = "";
        Integer max=0;
        for (int i = 0; i < N; i++) 
        {
           String laptop = br.readLine();
           Integer already = count.get(laptop);
           if(already==null)
           {
        	  already=0;
           }
           
           count.put(laptop, ++already);
           
           
           if(already>=max)
           {
        	   max=already;
     //   	   mostSuggested=laptop;
           }
           
           
        }
      
        TreeSet most  = new TreeSet<>();
        for(Map.Entry  laptop:count.entrySet())
        {
        	
        	if(laptop.getValue().equals(max))
        	{ 
        		
        		most.add(laptop.getKey());
        	}
        }
        System.out.println(most.first());
        
       
    }	

}
