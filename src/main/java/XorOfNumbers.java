
public class XorOfNumbers {

	public static int myXOR(int x, int y)
	{
	   
	    return (x | y) & (~x | ~y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(myXOR(3, 5));
	}

}
 