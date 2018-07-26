package hackerearth.practice;
//https://www.hackerearth.com/problem/algorithm/akash-and-the-assignment-1-12/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class KthSmalestLetter 
{

	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cases[] = br.readLine().split(" ");
		int q = Integer.parseInt(cases[1]);
		String s = br.readLine();
		while(q-->0)
		{
			String inputs[] = br.readLine().split(" ");
			int l = Integer.parseInt(inputs[0]);
			int r = Integer.parseInt(inputs[1]);
			int k = Integer.parseInt(inputs[2]);
			int processed[] = new int[26]; 
			for(int i=l-1;i<r;i++)
			{
				char c = s.charAt(i);
				processed[c-'a']++;
			}
			boolean found=false;
			char kthLetter = 'a'; 
			for(int i=0;i<26;i++)
			{
				
					k-=processed[i];
					if(k<=0)
					{
						found=true;
						kthLetter = (char)(((int)'a')+i);
						break;
					}
				
			}
			
			if(found)
			{
				System.out.println(kthLetter);
			}
			else
			{
				System.out.println("Out of range");
			}
		}
		

	}

}
