package inheritance;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by maninder on 10/8/17.
 *
 */
public class Application {
    public static void main(String[] args) throws IOException {
        MobileWala mw = new MobileWala();
        PersonaGraph pg = new PersonaGraph();

        Thread t1 = new Thread(() -> {
            for(int i=1;i<34;i++)
            {
                ObjectNode mobileWala = JsonNodeFactory.instance.objectNode();
                mobileWala.put("dai","ID"+i);
                mw.pushData(mobileWala);
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for(int i=100;i<141;i++)
            {
                ObjectNode personagraph = JsonNodeFactory.instance.objectNode();
                personagraph.put("DeviceAdvertisingId","DEVICE_"+i);
                pg.pushData(personagraph);
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }

}
