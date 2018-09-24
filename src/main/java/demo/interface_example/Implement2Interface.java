package demo.interface_example;

public class Implement2Interface extends AbstractClass implements Interface1,Interface2{


    void print (String s)
    {
        System.out.println("String" +s);



    }

    void print(Object o)
    {
        System.out.println("Object "+o);
    }

    void print (Integer s)
    {
        System.out.println("Integer" +s);
    }


    static int getInt()
    {
        int number =7;
        try{
            number = 9;
            return number;
        }
        catch (Exception e)
        {

        }
        finally {
            return number=21;
        }

    }

    static void modify(String s)
    {
        s = s+" Maninder";
    }

    public static void main(String[] args) {
        new Implement2Interface().print("String");

        System.out.println(getInt()
        );

        String ss = "Hello";

        modify(ss);

        System.out.println(ss);
    }

}

class Data{
    public String s;
}
