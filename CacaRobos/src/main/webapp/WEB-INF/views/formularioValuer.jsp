<!DOCTYPE html>
<html>
<head>
	<title>Ca�a Rob�s - Cadastro de Volunt�rios</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link rel="shortcut icon" type="image/x-icon" href="resources/img/logo.png">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="resources/css/estilos-voluntario.css" rel="stylesheet">

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

 <h2>Seja um volunt�rio!</h2>
 <div class="contenedor-formulario">
 <!-- Caixa do formulário -->
    <div class="wrap">
    <!-- Inicio Formulário -->
       <form action="registerValuer" class="formulario" name="formulario_registro" enctype="multipart/form-data"  method="post">
          <div class="btn">
             <!--<label class="label" for="profilePicture">Foto*:</label>-->
             <label  class="label" for="upload-photo"><img src="resources/img/icone-imagem.png" height="50px"></label>
             <input type="file" onchange="readURL(this);" accept="image/jpeg,image/png" name="file" id="upload-photo"  />
             <img id="blah"  src="#"  />
             <p class="label-foto">Insira uma foto*</p>
          </div>
          </br></br></br>
          <div class="input-group">
             <input type="text" id="nome" autofocus="true" onkeypress="return numeros();" name="name">
             <label class="label"  for="apelido">Nome*:</label>
          </div>
          <div class="input-group">
             <input type="email" id="email" name="username">
             <label class="label" for="email">E-mail*:</label>
          </div>
          <div class="input-group">
             <input type='text' name='cpf'  maxlength="14" onkeypress='mascaraMutuario(this,cpfCnpj)' onblur='clearTimeout()' >
             <label class="label" for="cpf">CPF*:</label>
          </div>
          <div class="input-group">
             <input type="password" maxlength="8" id="senha" name="password">
             <label class="label"  for="senha">Senha*:</label>
          </div>
          <p>Descreva brevemente o motivo de ser um voluntario:</p>
          <div class="form-group">
             <textarea class="form-control" cols="5" rows="4" style="resize: none" name="comment" id="comment"></textarea>
          </div>
          <style type="text/css">
             p {
             color: #000;
             }
          </style>
          <input type="submit" id="btn-submit" value="Cadastrar">
    </div>
    </form><!-- Fim Formulário -->
 </div>
 
 <!-- Script do formulário-->
 <script src="resources/js/formulario.js"></script>

 <!--Script validação CPF-->
 <script type="text/javascript"> 
    function mascaraMutuario(o,f){
       v_obj=o
       v_fun=f
       setTimeout('execmascara()',1)
    }
    
    function execmascara(){
       v_obj.value=v_fun(v_obj.value)
    }
    
    function cpfCnpj(v){
    
       //Remove tudo o que não é dígito
       v=v.replace(/\D/g,"")
    
       if (v.length <= 14) { //CPF
    
           //Coloca um ponto entre o terceiro e o quarto dígitos
           v=v.replace(/(\d{3})(\d)/,"$1.$2")
    
           //Coloca um ponto entre o terceiro e o quarto dígitos
           //de novo (para o segundo bloco de números)
           v=v.replace(/(\d{3})(\d)/,"$1.$2")
    
           //Coloca um hífen entre o terceiro e o quarto dígitos
           v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2")
    
       } else { //CNPJ
    
           //Coloca ponto entre o segundo e o terceiro dígitos
           v=v.replace(/^(\d{2})(\d)/,"$1.$2")
    
           //Coloca ponto entre o quinto e o sexto dígitos
           v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3")
    
           //Coloca uma barra entre o oitavo e o nono dígitos
           v=v.replace(/\.(\d{3})(\d)/,".$1/$2")
    
           //Coloca um hífen depois do bloco de quatro dígitos
           v=v.replace(/(\d{4})(\d)/,"$1-$2")
    
       }
    
       return v
    
    }
 </script>

 <!-- Script para visualizar a foto selecionada-->
 <script type="text/javascript">
     function readURL(input) {
       if (input.files && input.files[0]) {
           var reader = new FileReader();

           reader.onload = function (e) {
               $('#blah')
                   .attr('src', e.target.result)
                   .width(230)
                   .height(200)
                   .padding(20);

           };

           reader.readAsDataURL(input.files[0]);
       }
   }
   </script>

   <!-- Script para campo "nome" aceitar somente letras-->
   <script type="text/javascript">
   function numeros(){
   tecla = event.keyCode;
     if (tecla >= 48 && tecla <= 57){
       return false;
     }else{
         return true;
     }
}
   </script>

     </div>

            <!-- Rodapé -->
            <div class="footer">
              <p>Todos os direitos reservados  © AppCivico - 2017</p>
           </div>
      

</body>
</html>