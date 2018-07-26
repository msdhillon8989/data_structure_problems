

class TestClass
{
	volatile public int a =40;
}

public class VolatileTest {

	public static void main(String[] args) {
		TestClass t1,t2;
		t1 = new TestClass();
		t2 = new TestClass();
		
		t1.a =50;
		
		System.out.println(t2.a);

	}

}
