package techgig.practice;


class Sample
{
	 public static void greeting() {
	        System.out.println("Hello World");
	    }
}


public class Test 
{
	
    public static void main(String... args) 
    {
        Sample test=null;
        test.greeting(); // call with null reference
        
        
    }

}