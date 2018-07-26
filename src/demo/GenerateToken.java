package demo;



import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.format.DateTimeFormatter;

/**
 * Created by maninder on 28/3/17.
 */
public class GenerateToken {




  /*  static protected String generateSHA256(String key, String data) {
        Signature signer = null;
        try {
            signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(key);
            signer.update(data);
            byte[] signature = signer.sign();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return  "";
    }*/
    static protected String generateChecksum(String key, String data) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            byte[] hmacData = mac.doFinal(data.getBytes("UTF-8"));
            return Base64.encodeBase64String(hmacData);
        }
        catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz");

    public static void main(String[] args) {
        String apiKey ="3686d98774d4ef98d4e72ce97fd00685";

        //apiKey = "37a2a2e90178481a329876a82b180399";
        //apiKey=37a2a2e90178481a329876a82b180399
        //String url = "http://54.254.236.23:9000/reports/countryVideoReport?apiKey=7a917709f09fca2f316fc63f2ecd54fa&appID=188260c67618c285031696e82c73f223&startDateTime=2017-03-26+00%3A00%3A00&endDateTime=2017-03-26+23%3A59%3A59&campaignFormType=video";
        String url = "http://54.169.33.231:9000/reports/countryVideoReport?appID=5cb0f8b560305d0cbbc18bba8823dfd9&startDateTime=2017-03-23+00%3A00%3A00&endDateTime=2017-03-23+23%3A59%3A59&campaignFormType=Video";
        //http://pokktfeed.pokkt.com/v2/publisherReportByCountry?apiKey=3ee77c658e9558866d8268db6e5c89f7&appId=5cb0f8b560305d0cbbc18bba8823dfd9&startDateTime=2017-03-23+00%3A00%3A00&endDateTime=2017-03-23+23%3A59%3A59&campaignFormType=Video
               url = "http://report.pokkt.com/reports/countryVideoReport?appID=5cb0f8b560305d0cbbc18bba8823dfd9&startDateTime=2017-03-22+00%3A00%3A00&endDateTime=2017-03-23+23%3A59%3A59&campaignFormType=Video";
        String url1 ="http://52.77.238.174:9000/reports/countryVideoReport?appID=5cb0f8b560305d0cbbc18bba8823dfd9&startDateTime=2017-03-22+00%3a00%3a00&endDateTime=2017-03-22+23%3a59%3a59&campaignFormType=video";
        url = "http://localhost:8090/reports/videoBackendReport?appID=ab12a1d9b351a1328e69fa50f4427998&startDateTime=2017-03-25+00%3A00%3A00&endDateTime=2017-03-27+23%3A59%3A59&campaignFormType=video";
            url = "http://54.254.227.123:9000/reports/videoBackendReport?startDateTime=2017-04-20+00%3a00%3a00&endDateTime=2017-04-22+00%3a00%3a00&campaignFormType=video";
            url = "http://report-495902651.ap-southeast-1.elb.amazonaws.com/reports/videoBackendReport?startDateTime=2017-04-20+00%3a00%3a00&endDateTime=2017-04-22+00%3a00%3a00&campaignFormType=video";
            url = "http://device.pokkt.com/device/filter-list?fields=deviceAdvertisingID&ops=eq&values=testuser1_4may&forceBypassCache=true";
            url = "http://localhost:8080/vdoaccesskey/filter-list?values=5c18f8989b8ec0c7c4968777be1ed0c9";
            //url = "http://device.pokkt.com/device/filter-list?fields=deviceAdvertisingID&ops=eq&values=08c2661c-0334-41b8-a9e8-103117013696";
            //url = "http://52.221.183.134:8899/user/bulk";
        url ="http://device.pokkt.com/vdoaccesskey/filter-list?fields=accessKey&ops=eq&values=db56e2b54dfdf48626c8d303e30c8ce3";
    //url = "http://54.255.140.199:9000/update";
        url="http://54.255.180.246:8080/rmq_servers/get_by_host_groups?host_groups=USRMQ,PROD-RABBITMQ";
        //1kgFH31o7WAsrye7FvMICN0vcoFVmG0OPN2nONolwhw=
        url="http://internal-pokktlive-service-669924362.ap-southeast-1.elb.amazonaws.com/pub/get?id=1002263";
        url="http://54.169.186.251:8899/user/user-list?projection=deviceAdvertisingID,mwUpdateDateTime";
        url="http://54.169.17.181:8899/user/filter-unique?values=74686b4b-fa1c-46ff-93d7-27557fe8f64d&ops=eq&fields=deviceAdvertisingID";
        url="http://device.pokkt.com/user/user-list?projection=deviceAdvertisingID,mwUpdateDateTime,locationHistory";
        url ="http://device.pokkt.com/user/3c2825ac-03b8-4b5f-ab58-0eeff606433b?forceBypassCache=true";
    
        //fWjFSNAS791O6BBmdp7UwJFk1D+l9kp6UIZXM7Lzdew=
        //mhrpeZcJBaGNsATuYECq8AICrLc6HxLQ5sHVmyZpXI0=
        // url ="http://report.pokkt.com/reports/countryVideoReport?appID=5cb0f8b560305d0cbbc18bba8823dfd9&startDateTime=2017-03-22+00%3A00%3A00&endDateTime=2017-03-22+23%3A59%3A59&campaignFormType=Video";
        //i3LGQh+RWmn4NX6+DvnaHWSwWit+TzWXYeZnnSVNPQM=
        //url="http://report.pokkt.com/reports/countryVideoReport?appID=5cb0f8b560305d0cbbc18bba8823dfd9&startDateTime=2017-03-22+00%3A00%3A00&endDateTime=2017-03-23+23%3A59%3A59&campaignFormType=Video";
        //3JwXswE5jYrQXeGSr2oIHAbVQquYO1dAFX7RgapAVpM
        System.out.println("Security-Token: "+generateChecksum(apiKey,url));
//        System.out.println("Security-Timestamp: "+generateChecksum(apiKey,url1));


    }

}
