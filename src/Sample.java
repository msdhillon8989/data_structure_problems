import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



class Student
{
	int rollno;
	String name;
	
	public Student()
	{
		rollno=0;
		name="studentName";
	}
	
	public Student(int r,String n)
	{
		rollno=r;
		name=n;
	}
	
	public void print()
	{
		System.out.println(rollno+"   "+name);
	}
}


public class Sample
{
	
	public static void method1() throws Exception
	{
		
			File f = new File("C://maninder.java");
			if(!  f.exists())
			{
				throw new Exception("File ni haigi");
			}
			FileReader rf = new FileReader(f);
			BufferedReader br = new BufferedReader(rf);
			br.readLine();
		
		
		
		System.out.println("two");
	}
	
	
	
	public static void main(String sr[])
	{
		
		
		
	}




}
