package demo;

/**
 * Created by maninder on 26/7/17.
 */
public class MacroReplacer {
    public static void main(String[] args) {
        String callbackUrl = "http://cpi.pokkt.cpo/handle-callback?clickid=1234_1234_1234&e_tkn=token&syste=android";


          callbackUrl =   callbackUrl.replaceAll("\\{(.*?)\\}","");
        System.out.println(callbackUrl);
    }
}
