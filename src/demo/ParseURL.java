package demo;

/**
 * Created by maninder on 17/8/17.
 */
public class ParseURL {
    public static void main(String[] args) {
        String url = "https://play.google.com/store/apps/details?id=com.icicibank.pockets&referrer=af";
        System.out.println(getPackage(url));
    }

    private static String getPackage(String url) {
        try {
            String query = url.substring(url.indexOf("?")+1);
            String params[] = query.split("&");
            for(String param : params)
            {
                if (param.startsWith("id"))
                {
                    return param.substring(3);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
