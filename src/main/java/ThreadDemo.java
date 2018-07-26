
class Table{
	
		
	 static  synchronized  public void printTable(int n)
	  {
	   for(int i=1;i<=10;i++)
	   {
	     System.out.println(n*i);
	     try{
	       Thread.sleep(200);
	     }catch(Exception e){}
	   }
	 }
	}

	class MyThread1 extends Thread{
		Table t;
		int n;
		public MyThread1(Table t,int n) {
			
			this.t=t;
			this.n=n;
			
		}
	public void run(){
		t.printTable(n);
	}
	}

	

	public class ThreadDemo{
	public static void main(String arg[]){
		Table tt  = new Table(); 
		Table tt1 = new Table(); 
	MyThread1 t1=new MyThread1(tt,10);
	//	Table t2 = new Table(100);
		
		MyThread1 t3=new MyThread1(tt1,100);

	t1.start();
	
	t3.start();
	
	}
	}
