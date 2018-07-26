import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class IfURLExist 
{
	public static String URL = "http://www.nbc.com/Heroes/novels/downloads/";

	public static int getResponseCode(String urlString) throws MalformedURLException, IOException {
	    
	    HttpURLConnection huc =  (HttpURLConnection) new URL(urlString).openConnection(); 
	    huc.setRequestMethod("GET"); 
	    huc.connect(); 
	    huc.disconnect(); 
	    
	    return huc.getResponseCode();
	}
	
	
	public static void main(String s[]) throws Exception
	{
		System.out.println(getResponseCode("http://wwwwww.questions.com"));
	//	System.out.println(validateDownloadLinks("http://fortbendisd.com/cms/lib09/TX01917858/Centricity/Domain/61/FBISD At a Glance tri-fold 15 16.pdf"));
		
		
	}
	
	
	
	
	
	

		public static String validateDownloadLinks( String url)
					throws IOException {
				try {
					// check HTTP response code
					 HttpURLConnection linkConnection =  (HttpURLConnection) new URL(url).openConnection();
					 System.out.println(linkConnection.getContentType());
					String responseCheck = Integer.toString(linkConnection.getResponseCode());
					if (responseCheck.startsWith("2") || responseCheck.startsWith("3")) {
						// open input stream for start reading
						InputStream inputStream = linkConnection.getInputStream();
						byte[] buffer = new byte[1];
						if ((inputStream.read(buffer)) != -1) {// check return
							inputStream.close();
							return "Valid";
						} else {
							inputStream.close();
							return "invalid";
						}
					} else {
						return "invalid";
					}
				} catch (Exception b) {
					return "invalid";				}
			} 

	
	


}
