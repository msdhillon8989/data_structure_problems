package demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by maninder on 16/1/17.
 */
class Demo
{
   public Integer event1 =1;
    public int  event2 = 2;
    public int event3 =3;
    public int  event4 = 4;
    public  int event5 =5;
    public int  event6 = 5;
    public  int event7 =4;
    public int  event8 = 3;

}


public class SHA1
{
    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static void main(String[] args)  {
        try {
       /*     String password = "[API_KEY]";
            System.out.println(password.substring(1,password.length()-1));
            System.out.println(sha1("password"));*/
            Demo d = new Demo();
            for(int i=1;i<9;i++)
            {
                int x = (Integer)(d.getClass().getField("event"+i).get(d));
                System.out.println("event"+i+" == "+x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
