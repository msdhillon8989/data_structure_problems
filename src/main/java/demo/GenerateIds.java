package demo;

import java.util.ArrayList;

/**
 * Created by maninder on 11/11/16.
 */
public class GenerateIds
{
    private static ArrayList<String> ids = new ArrayList<>();
    static int n=5;  //no of Ids u want te generate
    static int completed =0;
    static char ID[] = new char[7];
    public static void main(String[] args)
    {

        generateIds(0);
        for(String id : ids)
        {
            System.out.println(id);
        }
    }

    private static void generateIds(int i)
    {
        if(n!=completed)
        {
            if(i<2)
            {
                for(char c ='A';c<'Z';c++)
                {
                    ID[i]=c;
                    generateIds(i+1);
                }
            }
            else if(i>=2 && i<7)
            {
                for(char c ='0';c<='9';c++)
                {
                    ID[i]=c;
                    generateIds(i+1);
                }
            }else if(i==7)
            {
                String id = String.valueOf(ID);
                if(!ids.contains(id))
                {
                    ids.add(id);
                    completed++;
                }
            }
        }
    }
}
