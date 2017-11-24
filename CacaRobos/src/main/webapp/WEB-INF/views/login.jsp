<!DOCTYPE html>
<html>
<head>
	<title>Caça Robôs - Login </title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link rel="shortcut icon" type="image/x-icon" href="resources/img/logo.png">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="resources/css/estilos-login.css" rel="stylesheet">
	<link rel="apple-touch-icon" href="apple-touch-icon.png">

     <link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
  	<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  	<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
     <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

</head>
<body id="page-top">

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
              float: left;
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

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a href="home"><img border="0" alt="Logo" src="resources/img/logo.png" width="100" height="100"></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">

                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <div class="dropdown" style="padding-top: 0px; ">
                            <button class="dropbtn">Cadastro</button>
                            <div class="dropdown-content">
                              <center><a href="formValuer">Voluntario</a>
                              <a href="formUser">Usuário</a></center>
                            </div>
                          </div>
                    </ul>
                </div>
            </div>
        </nav>
      </div>
    </nav>
    
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<!-- Icone -->
<div class="contenedor-formulario">

<!--<h3 class="h3">Olá! Digite seu email e senha</h3>-->

<!--Caixa do login -->
<div class="wrap">

<!-- Inicio login -->
  <form action="sigin" class="formulario"  name="formulario_registro" method="get">
    <div>
      <div class="input-group">
        <input type="email"  id="email" name="username">
        <label class="label" for="email">E-mail:</label>
      </div>
      <div class="input-group">
        <input type="password" id="senha" name="password">
        <label class="label" for="senha">Senha:</label>
      </div>

      <input type="submit" id="btn-submit" value="Logar">
    </div></br><!-- Fim login -->
    <a class="cadastro" data-toggle="tooltip" title="Recupere sua senha!" href="cadastro">Esqueceu sua senha?</a>
  </form>
</div>
</div>




</body>

<script src="resources/js/formulario.js"></script>

</html>