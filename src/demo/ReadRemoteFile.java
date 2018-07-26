package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by maninder on 29/6/17.
 *
 */
public class ReadRemoteFile {

    public static void main(String[] args) throws Exception {

        URL fileUrl = new URL("http://mw-product.s3.amazonaws.com/phab_3545/delivery.csv");
        BufferedReader in = new BufferedReader(new InputStreamReader(fileUrl.openStream()));
        String inputLine;
        int lines  =10;
        while ((inputLine = in.readLine()) != null && lines-->0)
        {
            System.out.println(inputLine);

        }
        in.close();
    }
}
