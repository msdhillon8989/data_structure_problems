package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/problem/algorithm/the-football-fest-6/
public class BasicOfStack {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		int current = -1;
		boolean alreadyBack=false;
		StringBuilder sb = new StringBuilder();
		while(cases-->0)
		{
			String input = br.readLine();
			int N = Integer.parseInt(input.substring(0, input.indexOf(" ")));
			int first = Integer.parseInt(input.substring(input.indexOf(" ")+1));
			int stack[]  = new int[N+1];
			current=0;
			stack[current]=first;
			while(N-->0)
			{
				String pass = br.readLine();
				if(pass.charAt(0)=='B')
				{
					if(alreadyBack)
					{
						alreadyBack=false;
						current++;
					}
					else
					{
						current--;
						alreadyBack=true;
					}
				}
				else
				{
					alreadyBack=false;
					int id = Integer.parseInt(pass.substring(pass.indexOf(" ")+1));
					current++;
					stack[current]=id;
				}
			}
			//System.out.println("Player "+stack[current]);
			sb.append("Player "+stack[current]+"\n");
		}
		System.out.println(sb.toString());

	}

}
