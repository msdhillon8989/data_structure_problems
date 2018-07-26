


//Creating interface that has 4 methods  
interface A{  
int variable =35;	
void a();//bydefault, public and abstract  
void b();  
void c();  
  
}  
//Creating abstract class that provides the implementation of one method of A interface  
abstract class B implements A{ 

public void c(){System.out.println("I am C"+ variable);}  
}  

//Creating subclass of abstract class, now we need to provide the implementation of rest of the methods  
class M extends B{  

public void a(){System.out.println("I am a");}  
public void b(){System.out.println("I am b");}  
}  

//Creating a test class that calls the methods of A interface  
public class InterfaceDemo {

	public static void main(String[] args) {
			A a=new M();  
			a.a();  
			a.b();  
			a.c();  
			System.out.println(a.variable);
			M b = new M();
			System.out.println(b.variable);
	}

}