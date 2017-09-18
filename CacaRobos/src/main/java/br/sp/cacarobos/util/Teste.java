package br.sp.cacarobos.util;

import org.apache.commons.mail.EmailException;

public class Teste {
	public static void main(String[] args) throws EmailException{
		EmailUtils emailUtils=new EmailUtils();
		emailUtils.sentEmailToBeAddressedTo("antonio6745.p@gmail.com");
		emailUtils.sendEmail("Daviizinho Malokeiro", "O menino mais leve de Diadema, entorta ate barra de janela nem, que for no sopro");
	}
}
