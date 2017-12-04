package br.sp.cacarobos.util;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
public class EmailUtils{
	private HtmlEmail email;
	private final String HOST_NAME="smtp.gmail.com";
	private final int SMTP_PORT=465;
	private final String USERNAME="senaimt4project";
	private final String PASSWORD="appcmt4132";
	private final String FROM_WHO="senaimt4project@gmail.com";
	private final boolean SSL_ON_CONNECT=true;
	
	public EmailUtils() throws EmailException{
		email=new HtmlEmail();
		email.setHostName(HOST_NAME);
		email.setSmtpPort(SMTP_PORT);
		email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
		email.setSSLOnConnect(SSL_ON_CONNECT);
		email.setFrom(FROM_WHO);
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
	
	public void setEmailAdress(String emailAdress){
		try{
			email.addTo(emailAdress);
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Set email adress): "+e.getMessage());
		}
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
	public void sendHtmlEmail(String subject, EmailTamplate emailTemplate){
		try{
			email.setSubject(subject);
			email.setHtmlMsg(emailTemplate.emailTamplate);
			email.setTextMsg("Email não suporta uma mensagem HTML");
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send forgot password html email): "+e.getMessage());
		}
	}
	
	public void sendSubscribleEmailUser(String emailToBeAdressed){
		try{
			email.addTo(emailToBeAdressed);
			email.setSubject("Inscrição no Caça Robos!");
			email.setHtmlMsg(EmailTamplate.TK_FOR_SUBSCRIBLE_USR.emailTamplate);
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send Subscrible email): "+e.getMessage());
		}
	}
	
	public void sendSubscribleEmailValuer(String emailToBeAdressed){
		try{
			email.addTo(emailToBeAdressed);
			email.setSubject("Inscrição no Caça Robos!");
			email.setHtmlMsg(EmailTamplate.TK_FOR_SUBSCRIBLE_VLR.emailTamplate);
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send Subscrible email): "+e.getMessage());
		}
	}
	
	public void sendSubscribleEmailManger(String emailToBeAdressed){
		try{
			email.addTo(emailToBeAdressed);
			email.setSubject("Inscrição no Caça Robos!");
			email.setHtmlMsg(EmailTamplate.TK_FOR_SUBSCRIBLE_ADM.emailTamplate);
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send Subscrible email): "+e.getMessage());
		}
	}

	public void sendApproveReportEmail(String username) {
		try{
			email.addTo(username);
			email.setSubject("Denuncia aprovada no Caça Robos");
			email.setHtmlMsg(EmailTamplate.APPROVE_REPORT_EMAIL.emailTamplate);
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send Approve report email): "+e.getMessage());
		}
	}

	public void sendApproveAccountEmail(String username) {
		try{
			email.addTo(username);
			email.setSubject("Sua conta foi aprovada!");
			email.setHtmlMsg(EmailTamplate.APPROVE_ACCOUNT_EMAIL.emailTamplate);
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send approve account email): "+e.getMessage());
		}
	}
	
	public void sendRejectAccount(String username){
		try{
			email.addTo(username);
			email.setSubject("Conta rejeitada");
			email.setHtmlMsg(EmailTamplate.REJECT_ACCOUNT.emailTamplate);
			email.send();
		}catch(EmailException e){
			throw new RuntimeException("Error in EmailUtils(Send reject account): "+e.getMessage());
		}
	}
}