<!DOCTYPE html>
<html>
<head>
	<title>Caça-Robôs - Recupere sua senha</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/jbootstrap.min.css" rel="stylesheet">

    <link rel="shortcut icon" type="image/x-icon" href="resources/img/logo.png">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="resources/css/jfreelancer.css" rel="stylesheet">

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
              <a class="nav-link js-scroll-trigger" href="formUser">Cadastro de Usuário</a>
            </li>
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="formValuer">Cadastro de Voluntários</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="formLogin">Login</a>
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

<div class="imgLogo" style="opacity: 0.2; position: absolute; padding-left: 1000px; padding-top: 10px;">
    <a><img border="0" alt="Logo" src="resources/img/logo.png" 
        width="700" height="700" >
    </a>
  </div>

 <!-- Inicio Formulário 1-->
<div class="contenedor-formulario">
  <div class="wrap">
     <form action="addValuer" class="formulario" name="formulario_registro" enctype="multipart/form-data"  method="post">
        <div class="btn">      

           <h5>Trocar Senha</h5>
        </div>
        </br><br>

        <div class="input-group"><!-- Form-->
                  <input type="password" id="password" name="password">
                  <label class="label" for="password">Digite sua nova senha:</label>
        </div>

        <div class="input-group"><!-- Form-->
            <input type="password" id="password" name="password">
            <label class="label" for="password">Confirme sua senha:</label>
  </div>

        <style type="text/css">
           p {
           color: #000;
           font-family: sans-serif;
           }
        </style>
        <input type="submit" id="btn-submit" value="Avan�ar">
  </div>
  </form>
</div>


</body>

<script src="resources/js/jformulario.js"></script>

</html>