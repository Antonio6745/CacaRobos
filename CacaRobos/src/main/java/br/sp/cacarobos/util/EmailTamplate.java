package br.sp.cacarobos.util;

public enum EmailTamplate {
	TEST_EMAIL_HTML("<html><h1>Teste de Email com HTML com um simples link:</h1><br><a href='www.globo.com'>Teste</a></html>"),
	TK_FOR_SUBSCRIBLE_USR("<html><h1>Obrigado por se inscrever no Ca�a Robos!</h1></br><h3>Vamos tornar a internet um ambiente mais real</h3></br>"
			+ "<p>� de extrema importancia que voce ajude nosse pa�s a ter um cenario polit�co livre de manipula��o! </p>"
			+ "<a href='172.16.12.79/cacarobos/home'>Vamos come�ar!</a></html>"),
	TK_FOR_SUBSCRIBLE_ADM("<html><h1>Voce agora � um gestor no Ca�a Robos!<h1></br><h3>'Com grandes poderes, vem grandes responsabilidades'</h3></br>"
			+ "<p>Voce acaba de receber a responsabilidade de escolher aqueles que cuidar�o do nosse cenario polit�co, boa sorte - Espero que sim!</p>"
			+ "<a href='172.16.12.79/cacarobos/home'>Vamos come�ar!</a></html>"),
	TK_FOR_SUBSCRIBLE_VLR("<html><h1>Voce se candidatou a avalidador!</h1></br><h3>Obrigado por querer participar dessa mudan�a conosco!</h3></br>"
			+ "<p>Sua conta foi enviada para analise, e um de nossos gestores logo provavelmente a aprovar�!</p>"
			+ "<a href='172.16.12.79/cacarobos/home'></a></html>"),
	APPROVE_REPORT_EMAIL("<html><h1>Sua denucia foi aprovada!</h1></br><h3>Nossos avaliadores aprovaram que a vota��o de sua denuncia come�e!</h3></br>"
			+ "<p>Apartir de agora a vota��o est� iniciada, que o povo decida o que � melhor!</p>"
			+ "<a href='172.16.12.79/cacarobos/home'></a></html>"),
	APPROVE_ACCOUNT_EMAIL("<html><h1></h1>Sua conta foi verificada</br><h3>Nossos gestores aprovaram sua conta!</h3></br>"
			+ "<p>Voce ja pode come�ar a ajudar aprovando denuncias de usuarios!</p>"
			+ "<a href=''></a></html>")
	/*
	 * STANDARD_CONSTRAINT_TAMPLATE("<html><h1></h1></br><h3></h3></br>"
			+ "<p></p>"
			+ "<a href=''></a></html>")*/;
	public String emailTamplate;
	
	EmailTamplate(String emailTamplate) {
		this.emailTamplate=emailTamplate;
	}
	
	
}
