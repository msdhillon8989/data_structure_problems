package demo;

/**
 * Created by maninder on 12/5/17.
 */
public class CaseConverter {

    public static String convert(String data)
    {

        if(data!=null && data.length()>1)
        {
            Character chars[] = new Character[data.length()];
            chars[0] = data.charAt(0);
        }

        return data;
    }
}
