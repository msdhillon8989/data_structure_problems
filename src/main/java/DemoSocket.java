import java.net.Socket;


public class DemoSocket 
{
	public static void main(String a[])
	{
		try {
			Socket sock = new Socket("www.hotelveenus.in", 80);
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
