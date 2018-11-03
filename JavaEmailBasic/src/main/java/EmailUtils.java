import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * @author Soham Sengupta
 * 
 * A simple email utility class
 *
 */
public class EmailUtils {

	/**
	 * Utility method to send simple HTML email
	 * @author Soham Sengupta
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("E-mail Was Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Sends TLS email - We may use GMail /Outlook here
	 * @param fromEmail
	 * @param password
	 * @param subject
	 * @param body
	 */
	public static void sendTLSEmail(final String fromEmail, final String password,
									String toEmail,String subject, String body
								) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		sendEmail(session, toEmail, subject, body);
	}
	
	public static void main(String[] args) {
		sendTLSEmail("soham.jis.ts@gmail.com", "9051323084New",
				"soham.payback@gmail.com" ,
				"This is test mail ", 
				"Yoy should get this email "+new Date());
	}
}
