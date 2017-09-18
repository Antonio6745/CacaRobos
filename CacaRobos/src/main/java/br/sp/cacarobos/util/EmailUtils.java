package br.sp.cacarobos.util;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class EmailUtils{
	private Email email;
	private final String HOST_NAME="smtp.gmail.com";
	private final int SMTP_PORT=465;
	private final String USERNAME="senaimt4project";
	private final String PASSWORD="appcmt4132";
	private final String FROM_WHO="senaimt4project@gmail.com";
	private final boolean SSL_ON_CONNECT=true;
	
	public EmailUtils() throws EmailException{
		email=new SimpleEmail();
		email.setHostName(HOST_NAME);
		email.setSmtpPort(SMTP_PORT);
		email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
		email.setSSLOnConnect(SSL_ON_CONNECT);
		email.setFrom(FROM_WHO);
	}
	
	public void sentEmailToBeAddressedTo(String emailToBeAddressed) throws EmailException{
		email.addTo(emailToBeAddressed);
	}
	
	public void addEmailListToBeAddressed(List<String> emailList){
		emailList.forEach(i->{
			try{
				email.addTo(i);
			}catch (EmailException e) {
				throw new RuntimeException("Error in EmailUtils(Add email list to be addressed to): "+e.getMessage());
			}
		});
	}
	
	public void sendEmail(String subject, String emailTextMenssage){
		try{
			email.setSubject(subject);
			email.setMsg(emailTextMenssage);
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send Email): "+e.getMessage());
		}
	}
}