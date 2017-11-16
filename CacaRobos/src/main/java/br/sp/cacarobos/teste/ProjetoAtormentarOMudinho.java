package br.sp.cacarobos.teste;

import java.io.IOException;

import org.apache.commons.mail.EmailException;

import br.sp.cacarobos.util.EmailUtils;

public class ProjetoAtormentarOMudinho {
	public static void enviar(String emailToBeAddressed, int i) throws EmailException{
		EmailUtils email=new EmailUtils();
		email.setEmailAdress(emailToBeAddressed);
		email.sendEmail("Teste de Segurança", "Anderson, Boa Tarde! Para terminar, iremos realizar uma contagem para garantir que nao se trata de"
				+ "uma conta falsa, vamos contar? "+i);
	}
	public static void main(String[] args) throws EmailException, IOException, InterruptedException {
		int i=0;
		while(true){
			enviar("andersonnunescoelhojunior@gmail.com", i);
			System.out.println("Emails enviados já: "+i);
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			i++;
		}
	}
}