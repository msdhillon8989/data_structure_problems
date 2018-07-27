package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


public class TestClass
{
    static String NAME_FILE = "/tmp/names.txt";
    static String TEXT_FILE = "/tmp/text.txt";
    public static void main(String[] args) throws Exception
    {
        Map<String,Set<Integer>> nameCount = new HashMap<>();
        File nameFile = new File(NAME_FILE);
        File textFile = new File(TEXT_FILE);
        BufferedReader br  = new BufferedReader(new FileReader(nameFile));
        String name = null;
        while((name=br.readLine())!=null)
        {
            nameCount.put(name.toLowerCase(),new HashSet<>());
        }
        BufferedReader br2  = new BufferedReader(new FileReader(textFile));
        String line = null;
        int lineNo =0;
        while((line=br2.readLine())!=null)
        {
            lineNo++;
            String tokens[] = line.split(" |\\.|,|'|`|\"");
            for(String token : tokens)
            {
                String word = token.toLowerCase();
               if(nameCount.containsKey(word))
                {
                    nameCount.get(word).add(lineNo);

                }
            }
        }

        for(Map.Entry<String,Set<Integer>> e : nameCount.entrySet())
        {
            Set<Integer> lines = e.getValue();
            if(lines.size()>0)
            {
                System.out.print(e.getKey()+" : ");
                for(Integer pos : lines)
                {
                    System.out.print(pos+", ");
                }
                System.out.println();
            }
        }

    }
}
