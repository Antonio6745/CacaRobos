package br.sp.cacarobos.util;

public enum EmailTamplate {
	TEST_EMAIL_HTML("<html><h1>Teste de Email com HTML com um simples link:</h1><br><a href='www.globo.com'>Teste</a></html>");
	
	public String emailTamplate;
	
	EmailTamplate(String emailTamplate) {
		this.emailTamplate=emailTamplate;
	}
	
	
}
