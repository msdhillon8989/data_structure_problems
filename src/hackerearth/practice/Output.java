package hackerearth.practice;

import java.util.*;
class newthread implements Runnable {
    Thread t;
    newthread() {
        t = new Thread(this,"Hello");
        t.start();
    }
    public void run() {
        System.out.println(t.getName());
    }
}
public class Output {
	public static void main(String args[]) {
        int x,y;
        x = 3 & 6;
        y = 3 | 6;
        System.out.println(x + " " + y);
    }
}