
 class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    
    private void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

 class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    
    public static void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

   
}



public class StaticMethodOverridingDemo {

	public static void main(String[] args) {
		//Animal a = new Cat();
		
		Animal x = new Cat();
	    //x.testInstanceMethod();
	    x.testClassMethod();
	}

}
