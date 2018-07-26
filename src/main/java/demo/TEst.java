package demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by maninder on 23/1/17.
 */


public class TEst {

    public static String base64( String user ,String key) {
        String username = user;
        String secretKey = key;//"e67c99c8626792dc09c746f7cdd0e550";
        byte[] encodedBytes = Base64.getEncoder().encode((username + ":" + secretKey).getBytes());
        String token = new String(encodedBytes);
        System.out.println(token);
        return token;
    }


    public static void test(String cols) {
        Set<String> all = new HashSet<>(Arrays.asList(cols.split(",")));
        for (String a : all) {
            System.out.println(a);
        }
    }

    public static void checkDouble() {
        double d = 0.036;
        DecimalFormat PRECISION2 = new DecimalFormat("##.##");
        if (d > 0) {
            d = Double.parseDouble(PRECISION2.format(d));
        }
        System.out.println(d);

    }

    public static void parseRow() {
        String row = "[62672e73-3af0-40f5-99a5-234896a22bd6,WrappedArray(963, 964, 1094, 519, 1096, 1033, 970, 843, 1101, 977, 1041, 1043, 1364, 1109, 1304, 985, 1049, 986, 1243, 1053, 1055, 992, 1057, 1059, 997, 1061, 998, 999, 1000, 1001, 1002, 1003, 1004, 301, 1005, 1014, 1017, 1081, 1209, 1021, 1213)]";
        String advertisingId = row.substring(1, row.indexOf(","));
        String segments[] = row.substring(row.indexOf("(") + 1, row.lastIndexOf(")")).split(", ");
        System.out.println(advertisingId);
        for (String segment : segments) {
            System.out.print(segment + ",");
        }
    }

    public static void listFiles() {
        File f = new File("/home/maninder");
        File ss[] = f.listFiles();
        for (File s : ss) {
            System.out.println(s.getAbsolutePath());
        }
    }

    public static void combineListFromMap() {
        Map<String, List<String>> pokktSegmentsMap = new HashMap<>();
        List<String> segmentList = new ArrayList<>();
        segmentList.add("1");
        segmentList.add("2");

        pokktSegmentsMap.put("1", Arrays.asList("a,b,f".split(",")));
        pokktSegmentsMap.put("2", Arrays.asList("d,e,f".split(",")));

        Set<String> pokktSegment = new HashSet<>();
        for(String segment : segmentList)
        {
            pokktSegment.addAll(pokktSegmentsMap.get(segment));
        }

        for (String s : pokktSegment) {
            System.out.println(s);
        }


    }

    public static void remaingCount()
    {
        long max = 20;
        long totalSuccess = 19;
        long remainingDays = 2;

        System.out.println("Daily limit "+Math.round((float)Math.abs(max-totalSuccess)/remainingDays));
    }


    public static void addHAsh() throws MalformedURLException {
        String reportApiUrl = "https://api.fyber.com/publishers/v1/101324/statistics.json?aggregation_level=days&group_by=applications&start_date=2017-02-01&end_date=2017-02-02";
        URL url = new URL(reportApiUrl);
        String params[] = url.getQuery().split("&");
        String path = url.getPath();
        StringBuilder rawHashKey = new StringBuilder(path);
        Map<String,String> paramMap = new TreeMap<>();
        for(String param : params)
        {
            String keyValue[] = param.split("=");
            System.out.println("param "+ param + "  "+keyValue.length);
            paramMap.put(keyValue[0],keyValue[1]);
        }
        for(Map.Entry<String,String> entry :  paramMap.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }

    public static boolean getValu()
    {
        System.out.println("fuinction");
        return true;
    }

    public static void joinner()
    {
        String key  = String.join("_","hello","mello","dello");
        System.out.println(key);
    }
    public static void main(String[] args) throws MalformedURLException {

        //checkDouble();
        //base64();
        //parseRow();
        //listFiles();
        //combineListFromMap();
        //remaingCount();
        //addHAsh();
        //joinner();
        //System.out.println(impressionRatio());
        //linkedHashSet();
        //contains();
        //hashmapFilter();
        //testComparator();
        testSplitter();


    }

    private static void testSplitter() {
        String token ="_ _  _   _    _     _     _     _     _";
        String[] data = token.split("_");
        for (int i=0;i<data.length;i++)
        {
            System.out.println(data[i] + i);
        }
    }

    public static void hashmapFilter()
    {
        class Data{
            String name;
            String region;
            Data(String t,String r)
            {
                name=t;
                region=r;
            }
        }


        HashMap<String,Data> hm = new HashMap<>();
        hm.put("ins1",new Data("vdo123","US"));
        hm.put("ins2",new Data("vdo234","UK"));
        hm.put("ins3",new Data("vdo345","US"));
        hm.put("ins4",new Data("vdo456","UK"));
        hm.put("ins5",new Data("vdo567","US"));
        hm.put("ins6",new Data("vdo678","UK"));

        List<String> data = hm.values().stream().filter(x->x.region.equals("UK")).map(x -> x.name).collect(Collectors.toList());

        for(String d : data)
        {
            System.out.println(d);
        }

    }

    public static void linkedHashSet()
    {
        Set<String> set= new LinkedHashSet<>();
        set.add("maninder");
        set.add("singh");
        String string  = String.join(",", set.toArray(new CharSequence[]{}));

        System.out.println(string);
        Set<String> newset= new LinkedHashSet<>(Arrays.asList(string.split(",")));
        newset.add("dhillon");
        String newString = String.join(",", newset.toArray(new CharSequence[]{}));

        System.out.println(newString);
    }

    public static void contains ()
    {
        String s1 = "maninder||singh|Dhillon||amritsar||";
        for(String s : s1.split("\\|\\|"))
        {
            System.out.println(s+"   sss");
        }

    }




   static int impressionCount =1000;
   static int requestCount = 2000;
    public static final double impressionRatio() {

            return ((double)impressionCount / requestCount) * 100;

    }


    static void testComparator()
    {
        List<UserLocation> list = new ArrayList<>();

        list.add(new UserLocation("city1","state","country","2017-04-01 12:00:00"));
        list.add(new UserLocation("city2","state","country","2017-04-02 12:00:00"));
        list.add(new UserLocation("city14","state","country","2017-04-14 12:00:00"));
        list.add(new UserLocation("city5","state","country","2017-04-05 12:00:00"));
        list.add(new UserLocation("city10","state","country","2017-04-10 12:00:00"));
        list.add(new UserLocation("city4","state","country","2017-04-04 12:00:00"));
        list.add(new UserLocation("city13","state","country","2017-04-13 12:00:00"));
        list.add(new UserLocation("city6","state","country","2017-04-06 12:00:00"));
        list.add(new UserLocation("city11","state","country","2017-04-11 12:00:00"));
        list.add(new UserLocation("city12","state","country","2017-04-12 12:00:00"));
        list.add(new UserLocation("city3","state","country","2017-04-03 12:00:00"));
        list.add(new UserLocation("city9","state","country","2017-04-09 12:00:00"));
        list.add(new UserLocation("city15","state","country","2017-04-15 12:00:00"));
        list.add(new UserLocation("city7","state","country","2017-04-07 12:00:00"));
        list.add(new UserLocation("city8","state","country","2017-04-08 12:00:00"));
        list.add(new UserLocation("city16","state","country","2017-04-16 12:00:00"));

        Collections.shuffle(list);
        Collections.sort(list,UserLocation.dateTimeComparator);
        for(int i=0;i<list.size();i++)
        {
            UserLocation d = list.get(i);
            System.out.println(d.getLocationTime() +" "+d.getLocationDateTime().getTime());
        }

     }
}
