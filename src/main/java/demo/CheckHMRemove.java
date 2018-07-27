package demo;

import java.util.*;

/**
 * Created by maninder on 7/11/16.
 */
public class CheckHMRemove
{


    public static void sort()
    {
        int arr[] = {1,1,0};

        int i=0,j=arr.length-1;
        boolean swap1=false,swap2=false;

        while(i<j)
        {
            if(arr[i]==0)
            {
                i++;
            }
            else
            {
                swap1=true;
            }

            if(arr[j]==1)
            {
                j--;
            }
            else
            {
                swap2=true;
            }

            if(swap1&&swap2)
            {
                swap1=swap2=false;
                arr[i]=0;
                arr[j]=1;
            }
        }
        for(int x : arr)
        {
            System.out.print(x+" ");
        }
        System.out.println("sorted array"+arr);
    }

    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("name0","maninder");
        hm.put("name1","maninder1");
        hm.put("name2","maninder2");
        hm.put("name3","maninder3");
        hm.put("name4","maninder3");
        hm.put("name5","maninder5");
        String json  = "[{\"segmentid\":1234,\"segmentName\":\"pokkt_female_18_24\"},{\"segmentid\":1235,\"segmentName\":\"pokkt_female_18_34\"}]";
       // ObjectMapper mapper = new ObjectMapper();

        //sort();
       /* try{
            JSONArray jsonArray = new JSONArray(json);
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }*/
        Set<String> keys = hm.keySet();
       /* for(String key : keys){
            if(hm.get(key).equals("maninder3"))
            {
                hm.remove(key);
            }
        }*/

       String stringKeys = getCSVString(keys);
        System.out.println(hm.toString());

        HashSet<String> newset = new HashSet<String>(Arrays.asList(stringKeys.split(",")));

        System.out.println(newset.toString());


    }


    public static String getCSVString(Set<String> keys)
    {
        return String.join(",", keys.toArray(new CharSequence[]{}));
    }
}
