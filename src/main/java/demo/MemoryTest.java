package demo;

import java.util.ArrayList;
import java.util.List;

public class MemoryTest {

    List<NewObject> list  =  new ArrayList<>();

    public static void main(String[] args){

        MemoryTest m  = new MemoryTest();
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        fillMemory(m);
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        int TOTAL = 25000;
        int BATCH_SIZE =200;

        for (int sliceIndex = 0,i=1; sliceIndex < TOTAL; sliceIndex += BATCH_SIZE,i++) {
            final int sliceStartIndex = sliceIndex;
            int sliceLastIndex = (sliceIndex + BATCH_SIZE) > TOTAL ? TOTAL : sliceIndex + BATCH_SIZE;
            List<NewObject> sublist = m.list.subList(sliceStartIndex, sliceLastIndex);
            System.out.println(i+" Batch KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        }
    }

    static int j=0;
    public static void fillMemory(MemoryTest m){

        for(int k=0; k< 25000; k++)
            m.list.add( new NewObject());

    }


    public static class NewObject{
        long i = 0L;
        long j = 0L;
        long k = 0L;
    }

}