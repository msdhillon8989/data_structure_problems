package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SparseArray {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int strings = Integer.parseInt(br.readLine());
		HashMap<String,Integer> stringCount = new HashMap<>();  
		while(strings-->0)
		{
			String s = br.readLine();
			Integer count  =  stringCount.get(s);
			if(count == null)
			{
				stringCount.put(s, 1);
			}
			else
			{
				stringCount.put(s, count+1);
			}
		}
		int queries = Integer.parseInt(br.readLine());
		while(queries-->0)
		{
			String s = br.readLine();
			Integer count  =  stringCount.get(s);
			if(count == null)
			{
				System.out.println(0);
			}
			else
			{
				System.out.println(count);
			}
		}
		

	}

}
