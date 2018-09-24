package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maninder on 24/1/17.
 */
public class Mani {
    public static void main(String[] args) {
         final int MAXIMUM_CAPACITY = 1 << 30;
        HashMap<String,String> map = new HashMap<>();

        map.put("Name","Maninder");
        System.out.println("HEllo " +MAXIMUM_CAPACITY);
    }
}
