<!DOCTYPE html>
<html>
<head>
	<title>Ca�a Rob�s - Login </title>
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

     <link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
  	<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  	<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
     <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

</head>
<body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a href="home"><img border="0" alt="Logo" src="resources/img/logo.png" width="100" height="100"></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="home">Inicio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="formUser">Cadastro de Usuarios</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="formValuer">Cadastro de Voluntarios</a>
            </li>
          </ul>
        </div>
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
  <div class="icone">
<img src="resources/img/icone.png">
</div>

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