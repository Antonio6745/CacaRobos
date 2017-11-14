<!doctype html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
         
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>

        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="resources/assets/css/plugins.css" />
		<link rel="stylesheet" href="resources/assets/css/magnific-popup.css">

        <link rel="stylesheet" href="resources/assets/css/style.css">
		
        <link rel="stylesheet" href="resources/assets/css/nexa-web-font.css" />
        <link rel="stylesheet" href="resources/assets/css/opensans-web-font.css" />

        <link rel="stylesheet" href="resources/assets/css/responsive.css" />

        
    </head>
    <body>

    <style>
        .button {
              display: inline-block;
              border-radius: 4px;
              background-color: transparent;
              border: none;
              color: #4d4d4d;
              text-align: center;
              font-size: 28px;
              padding: 20px;
              width: 200px;
              transition: all 0.5s;
              cursor: pointer;
              margin: 5px;
            }

            .button span {
              cursor: pointer;
              display: inline-block;
              position: relative;
              transition: 0.5s;
            }

            .button span:after {
              content: '\00bb';
              position: absolute;
              opacity: 0;
              top: 0;
              right: -20px;
              transition: 0.5s;
            }

            .button:hover span {
              padding-right: 25px;
            }

            .button:hover span:after {
              opacity: 1;
              right: 0;
            }

            .dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
    width: 200px;
}

.dropdown {
    position: relative;
    display: inline-block;
    
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    width: 200px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
    </style>

    <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="resources/js/materialize.min.js"></script>
		
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">

                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <div class="dropdown" style="padding-top: 25px; ">
                            <button class="dropbtn">Cadastro</button>
                            <div class="dropdown-content">
                              <center><a href="formValuer">Voluntario</a>
                              <a href="formUser">Usuário</a></center>
                            </div>
                          </div>
                        
                        <li style="padding-left: 20px;"><a href="formLogin">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <header id="home" class="home">
			<div class="overlay sections">
				<div class="container">
					
					<div class="row">
						<div class="wrapper">
							<div class="col-md-6 col-md-offset-3">
								
								<div class="home-details text-center">
									
									<div class="logo">
										<img src="resources/assets/images/logo.png" alt="Logo Image" /></br>
                                            <h7 class="center-align">Seja Bem - Vindo</h7><p></br>
                                            <h5 class="truncate">Para continuar clique no botão a baixo para prosseguir.</h5>
									</div>

                                   <a href="formLogin"><button class="button" style="vertical-align:middle; padding-top: 0px;"><span> Avançar </span></button></a>
                                    
					
								</div>
									
							</div>
						</div>  
					</div>
				</div>
			</div>
        </header>

        <div id="tudo">
          <!-- conteúdos da página -->

        <section id="about" class="about sections">
            <div class="container">

                <div class="row">
                    <div class="wrapper">	
						<div class="col-md-6">
                    		<div class="heading about-content">
								<center><h3 style="color: #28a745; font-size: 40pt; padding-"> Finalidade   </h3></center><br>
								<center><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
								<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p></center>

							</div>
                    	</div>
						
                    </div>
                </div>
            </div> </br> </br> </br> 

            <center><details>
                    <summary style="color: #28a745;">História dos Robos</summary> </br>
                    <p style="font-size: 18pt;"><strong>Robô monitora todos os passos de Donald Trump no Twitter</strong>
                    </p>
            </br>
                    <p>Conta @TrumpsAlert registra mensagens curtidas pelo presidente dos EUA, quem ele segue ou deixa de seguir; familiares e assessores também são vigiados.</p>
                    <p>Não é difícil saber o que Donald Trump escreve no Twitter. Mas um robô foi criado apenas para seguir o que o presidente dos Estados Unidos curte, quem ele segue ou deixa de seguir na rede social, que se tornou uma plataforma para rebater críticas, opinar sobre assuntos importantes e até e antecipar ações do governo..</p>
                    <p>Criada em junho deste ano, a conta @TrumpsAlert estende a vigilância das atividades no Twitter a pessoas do círculo próxima de Trump, como sua esposa, Ivanka Trump, seu filho, Donald Trump Jr, e o conselheiro da Casa Branca, Kellyanne Conway.</p>
        </br>       <img src="resources/assets/images/trump.png" alt="Trump" /> </br></br></br>
                    <p>“Dado que Donald Trump parece governar tuitando, ter uma compreensão de seu mundo no Twitter poderia nos ajudar a entender melhor as decisões que ele toma e o que realmente está acontecendo nos bastidores da Casa Branca”, afirmou o criador da conta, James O’Malley, ao site “Mashable”.</p>
                    <p>Por meio do @TrumpsAlert, é possível saber que Trump muda no topo de sua conta quase todos os dias. Ou que seu filho curtiu uma promoção de cartuchos para espingarda.</p>  
        </br>       <img src="resources/assets/images/trump2.png" alt="Trump - 2" /> </br></br></br>
                    <p>“O que eu acho particularmente interessante é como Trump produz ecos de algo como um estilo de governo parecido com uma corte real, em que a proximidade com o poder é mais significativa do que os papéis ou as instituições”, diz O’Malley.</p>
                    <p>“Por isso, sabendo quem está dentro ou quem está fora da órbita de poder de Trump é particularmente útil.”</p> </br></br></br>
                    <p style="font-size: 18pt;"><strong>Bots: Os robôs das redes sociais</strong></p></br>
                </br>       <img src="resources/assets/images/img1.png" alt="Trump - 2" /> </br></br>
                    <p>A expressão “bot” é uma abreviação da palavra robot e é utilizada quando desejamos nos referir a usuários falsos, seja de Twitter, Facebook, Instagram, YouTube, ou de outras redes sociais. Muitas empresas investem nesse tipo de artimanha para aumentar o número de seguidores, visualizações e alcance de publicações. De acordo com texto veiculado no New York Times, existem companhias especializadas nesse tipo de serviço, “com apenas US$5, eu comprei 4.000 seguidores no Twitter, com mais US$5 eu comprei 4.000 amigos no Facebook e metade deles curtiu uma foto que eu postei na rede”, conta Nick Bilton, colunista de tecnologia.</p>
                    <p>O acesso a esse tipo de ferramenta é extremamente simples. Quando visualizamos o site da Swenzy, por exemplo, já nos é oferecido uma variedade de pacotes de serviço, que podem ser comprados conforme seu objetivo. É possível adquirir visualizações no YouTube, followers no Twitter, downloads e plays no SoundCloud, aumentar o tráfego do seu site e adquirir seguidores no Vine. A empresa garante que o serviço é 100% seguro, rápido, de alta qualidade e melhora indexação no Google e em outros buscadores. Você deve estar pensando, “Hmmmm… por que não?”</p>
                    <p>A resposta para essa pergunta nós encontramos no projeto Bot or Not, um aplicativo criado por alunos da universidade Eugene Lang The New School for Liberal Arts, da Nova Zelândia. De acordo com David Sorkin, especialista em direito na Internet, “o uso dos bots desvaloriza totalmente o sistema, se tudo o que estamos vendo é spam, perdemos a confiança na rede, se você perder a confiança no sistema, as pessoas vão cair fora dele o mais rápido possível”.</p>
                    <p>Sendo assim, apesar do baixo custo, esse tipo de investimento não vale a pena, pois gera frustração aos seguidores reais e fiéis, além de não trazer os resultados desejados, como aumento no engajamento dos fãs/seguidores e conversão em vendas. O Diretor Executivo da Magic Web Design, e especialista em mídias socias, Antonio Borba explica essa situação: </br> "A empresa que adota esta prática está valorizando números vazios, pois os usuários a mais não vão proporcionar interação com a marca nem conversão – ou seja, não haverá retorno proveniente do branding e da ação de marketing digital. Sem contar que, um alto número de seguidores que não interage, pode fazer cair a relevância da marca. Empresas inteligentes percebem que o verdadeiro valor de uma página está no engajamento de fãs legítimos, capazes de traduzir no real a semente plantada no virtual."</p>
    </br><p style="font-size: 16pt; color: #a9a9a9;"><strong>Ok, mas e o Facebook e o Twitter não fazem nada?</strong></p>
</br>       <img src="resources/assets/images/img2.png" alt="Trump - 2" /> </br></br></br>
                    <p>Segundo o editor de tecnologia do The Guardian, Charles Arthur, as redes sociais tentam excluir os bots, sempre que os identificam. “Muitas vezes esses esforços são inúteis, o Twitter conta com uma equipe de 30 pessoas que analisam se os perfis filtrados por conteúdo e comportamento merecem ou não uma bandeira vermelha”, explica. Alguns bots conseguem se disfarçar, criando ninhos onde seguem várias pessoas e empresas, antes de começar a disparar spams, “dessa forma fica muito mais difícil do Twitter criar um algoritmo para rastrear essas contas falsas”, analisa Arthur.</p>
                    <p>Estima-se que apenas uma a cada 100 mil pessoas clica em um link disparado por bot, no Twitter ou Facebook. Mas, enquanto o custo para criar ou comprar esse tipo de serviço continuar tão baixo, “o custo do spam se torna muito mais atraente e esse tipo de ação continuará acontecendo”, explica Michael Hussey, fundador do Peek You.</p>
                    <p>Apesar não existir uma severa punição sobre o uso dos bots, vale a pena analisar que: </br> O Facebook não tolera campanhas que usem artifícios como: prêmios, curtidas e outras práticas que incitem o usuário a dar likes.A rede incentiva o uso dos Social Ads, como estratégia de marketing mais eficiente, pois proporciona maior faturamento para o Facebook e garante que somente o público interessado clique nos anúncios.Sendo assim, a venda de likes e o uso de bots vai totalmente contra essa filosofia do Facebook.</p>


                </details>
            </center>
            

        </section>
        </div>
    </body>
</html>