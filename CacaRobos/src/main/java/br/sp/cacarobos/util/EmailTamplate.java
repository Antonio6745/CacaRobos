package br.sp.cacarobos.util;

public enum EmailTamplate {
	TEST_EMAIL_HTML("<html><h1>Teste de Email com HTML com um simples link:</h1><br><a href='www.globo.com'>Teste</a></html>"),
	TK_FOR_SUBSCRIBLE_USR("<html><h1>Obrigado por se inscrever no Ca�a Robos!</h1></br><h3>Vamos tornar a internet um ambiente mais real</h3></br>"
			+ "<p>� de extrema importancia que voce ajude nosse pa�s a ter um cenario polit�co livre de manipula��o! </p>"
			+ "<a href='172.16.12.79/cacarobos/home'>Vamos come�ar!</a></html>"),
	TK_FOR_SUBSCRIBLE_ADM("<html><h1>Voce agora � um gestor no Ca�a Robos!<h1></br><h3>'Com grandes poderes, vem grandes responsabilidades'</h3></br>"
			+ "<p></p></br>"
			+ "<a href=''></a></html>"),
	TK_FOR_SUBSCRIBLE_VLR("<html><h1></h1></br><h3></h3></br>"
			+ "<p></p></br>"
			+ "<a href=''></a></html>");
	public String emailTamplate;
	
	EmailTamplate(String emailTamplate) {
		this.emailTamplate=emailTamplate;
	}
	
	
}
