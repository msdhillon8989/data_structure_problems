package demo;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable{

    // SimpleDateFormat is not thread-safe, so give one to each thread
    private volatile  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMdd HHmm");


    
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i<2; i++){
            Thread t = new Thread(obj, ""+i);
            t.start();
            Thread.sleep(10000);

        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+simpleDateFormat.toPattern());
       /* try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //formatter pattern is changed here by thread, but it won't reflect to other threads
       simpleDateFormat = new SimpleDateFormat();

        
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+simpleDateFormat.toPattern());
    }

}
