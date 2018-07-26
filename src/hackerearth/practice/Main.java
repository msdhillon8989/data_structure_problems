package hackerearth.practice;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			String[] c = s.split(" ");
			int x1 = Integer.parseInt(c[0]);
			int y1 = Integer.parseInt(c[1]);
			int w1 = Integer.parseInt(c[2]);
			int h1 = Integer.parseInt(c[3]);

			int x2 = Integer.parseInt(c[4]);
			int y2 = Integer.parseInt(c[4]);
			int w2 = Integer.parseInt(c[6]);
			int h2 = Integer.parseInt(c[7]);
			if (x1 < x2 && y1 < y2) 
			{
				if (x1 + w1 >= x2 &&  y1+h1 >=y2) 
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
				}
			}
			else if (x1 < x2 && y2 < y1) 
			{
				if (x1 + w1 >= x2 &&  y2+h2 >=y1) 
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
				}
			}
			else if (x2 < x1 && y2 < y1) 
			{
				if (x2 + w2 >= x1 &&  y2+h2 >=y1) 
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
				}
			}
			else if (x2 < x1 && y1 < y2) 
			{
				if (x2 + w2 >= x1 &&  y1+h1 >=y2) 
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
				}
			}

		}
	}
}
