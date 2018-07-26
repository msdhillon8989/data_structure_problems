package demo;

/**
 * Created by maninder on 28/12/16.
 */
class Int {
    public static int i =0;
}
public class IncrementIntegerThread
{
    public static void main(String[] args) throws InterruptedException {
        Int i = new Int();
        R r1= new R(i,29);
        R r2 = new R(i,30);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        System.out.println(i.i);

    }

    private static void increment(Int i) {
        i.i++;
    }
}

class R implements Runnable
{
    Int i;
    int x;
    R(Int i,int x)
    {
        this.i = i;
        this.x=x;
    }
    @Override
    public void run() {
        for(int j=0;j<x;j++)
        {
            i.i++;
        }
    }
}
