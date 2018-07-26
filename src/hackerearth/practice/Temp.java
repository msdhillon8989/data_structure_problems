package hackerearth.practice;



public class Temp {
	int a=20;
	static int b = 10;
	void m1()
	{
		Temp t = new Temp();
		System.out.println(t.b);
	}
	
	public static void main(String[] args) {
		int choice = (int)(100*Math.random());

		if(choice%3==0)
		{
			System.out.println("Dont go");
		}
		else if(choice%3==1)
		{
			System.out.println("July");
		}
		else
		{
			System.out.println("Diwali");
		}
	}

}
