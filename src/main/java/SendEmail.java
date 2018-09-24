

import java.io.File;
import java.io.FileFilter;


import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;


 
public class SendEmail 
{

	/*private static String currentDate(String format)
	{
		Date d = new Date();
		SimpleDateFormat sm;
		try
		{
			sm = new SimpleDateFormat(format);
		}
		catch(Exception x)
		{
			sm = new SimpleDateFormat("dd/MMM/yyyy");
		}
		return sm.format(d);
	}

	public static void sendEmail(String toEmail, String fromEmail, String subject, String smtpHostServer,
			String destFsileLocation, String body,String fileNames) throws Exception
	{
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHostServer);
		Session session = Session.getInstance(props, null);
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromEmail));
			msg.setReplyTo(InternetAddress.parse(fromEmail, false));
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmail, false));

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			// Now set the actual message

		//	messageBodyPart.setText(body);

			if(null!=body)
			{

				 while(true)
			        {
				        int sindex=body.indexOf("<DATE>");
				        int eindex=body.indexOf("</DATE>",sindex);

				        if(sindex>-1 && eindex>-1)
				        {
				        	String format = body.substring(sindex+6,eindex);
				        	String nformat=currentDate(format);
				        	body=body.replace("<DATE>"+format+"</DATE>", nformat);
				        }
				        else
				        {
				        	break;
				        }
				     }

			messageBodyPart.setContent(body,"text/html");
			}

			// Create a multipar message
			Multipart multipart = new MimeMultipart();
			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			// Part two is attachment
//			messageBodyPart = new MimeBodyPart();					
//			DataSource source = new FileDataSource(destFileLocation);
//			messageBodyPart.setDataHandler(new DataHandler(source));
//		    messageBodyPart.setFileName(fileName);
//			multipart.addBodyPart(messageBodyPart);
//			// Send the complete message parts
			msg.setContent(multipart);
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	private static File lastFileModified(String dir)
	{
	    File fl = new File(dir);
	    File[] files = fl.listFiles(new FileFilter() {
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	    return choice;
	}


    public static void main(String a[])
    {
    		String to="";
			String from="";
			String subject="";
			String smtpHostServer="";
			String body="";

			to="daljit.kaur@hpe.com";
		//	to="deepikav@hpe.com,jatin.bansal@hpe.com,kobi.iyakutti@hpe.com,maninders@hpe.com,vikas.k@hpe.com,ajinkya.nag.bapat@hpe.com,anniruddha.mah.lanke@hpe.com,audumbar.raj.nevarekar@hpe.com,diksha.bajaj@hpe.com,pravin.jag.chavan@hpe.com,prithvi.sureka@hpe.com,prajwal.s@hpe.com,anusha.m2@hpe.com,divya.kashyap@hpe.com,dharshini.cols@hpe.com,akshayraj.ash.sawant@hpe.com,nikita.bhagat@hpe.com";
			from="basavaraj.thilagar@hpe.com";
			subject="Sweets at my desk";
			smtpHostServer="smtp3.hp.com";
			body="Its my bday";

			try{
				sendEmail(to, from, subject, smtpHostServer, null, body, null);
			}
			catch(Exception x)
			{

			}


    }*/
 
   
}