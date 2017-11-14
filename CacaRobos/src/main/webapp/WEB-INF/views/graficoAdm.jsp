<!DOCTYPE html>
<html lang="br">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Caça Robôs</title>
  <script src="javascripts/jquery.js" type="text/javascript"></script>
  <script type="text/javascript">
  
  $(document).ready(function() {
  var largura = $(window).width(); /* Capturando a do cliente */
  if (largura <= 921) {
  /* Se a Largura do monitor for menor ou = que 921 px */
  $("#hire").hide(); /* Esconde a bandeira azul*/
  $("#resize").hide(); /* Esconde "triangulo" resize no canto inferior direito*/
  }
  else if (tam >= 922) {
  /* Se não for a condição a cima e for marior ou = a 922 px */
  $("#hire").show(); /* Mostra a bandeira azul*/
  $("#resize").show(); /* Mostra "triangulo" resize no canto inferior direito*/
  }
});
</script>
<script src="resources/Chart.min.js"></script>

     <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
  .card4 {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    max-width: 300px;
    margin: auto;
    text-align: center;
    font-family: arial;
  }
  
  .title {
    color: grey;
    font-size: 18px;
  }
  
  button {
    border: none;
    outline: 0;
    display: inline-block;
    padding: 8px;
    color: white;
    background-color: #000;
    text-align: center;
    cursor: pointer;
    width: 100%;
    font-size: 18px;
  }
  
  b {
    text-decoration: none;
    font-size: 22px;
    color: black;
  }
  
  button:hover, a:hover {
    opacity: 0.7;
  }
  </style>


    <style type="text/css">

    *{
        font-family: calibri;        
    }

    .box {
        margin: 0px auto;
        width: 70%;
    }

    .box-chart {
        width: 100%;
        margin: 0 auto;
        padding: 10px;
    }

    </style>  

 <script type="text/javascript">
        var randomnb = function(){ return Math.round(Math.random()*300)};

         </script>  



  <!-- Bootstrap core CSS-->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin.css" rel="stylesheet">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

     <link rel="shortcut icon" href="logo.ico" type="image/x-icon" />

    <style>
    .card4 {
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      max-width: 300px;
      margin: auto;
      text-align: center;
      font-family: arial;
    }
    
    .title {
      color: grey;
      font-size: 18px;
    }
    
    button2 {
      border: none;
      outline: 0;
      display: inline-block;
      padding: 8px;
      color: white;
      background-color: #000;
      text-align: center;
      cursor: pointer;
      width: 100%;
      font-size: 18px;
    }
    
    c {
      text-decoration: none;
      font-size: 22px;
      color: black;
    }
    
    button2:hover, a:hover {
      opacity: 0.7;
    }
    </style>

</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation -->

 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
  <div class="container">
    

  </div>
  <img src="images/logo.ico" style="padding-right: 500px; padding-top: -20px;">
</div>
<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
  <span class="navbar-toggler-icon"></span>
</button>

<ul class="navbar-nav ml-auto">
  
         
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    
                    <!-- /.dropdown-alerts -->
                </li>
          
          <li class="nav-item">
            <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
              <i class="fa fa-fw fa-sign-out"></i>
              Logout</a>
          </li>
        </ul>


        

      </nav>

<!--Menu lateral-->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
<div class="collapse navbar-collapse" id="navbarResponsive">
  <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
      <center><a><img border="0" alt="Logo" src="resources/img/logo.png" 
        width="100" height="100">
    </a></center>

</br>

       <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large">Meu Perfil</button>


    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Estatisticas">


     <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
       <a class="nav-link" href="graficoAdm">
        <i class="fa fa-fw fa-area-chart"></i>
        <span class="nav-link-text">Estatisticas</span>
      </a>
    </li>
    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
      <a class="nav-link" href="valuerRegistered">
        <i class="fa fa-fw fa-table"></i>
        <span class="nav-link-text" >Avaliadores</span>
      </a>
    </li>
      
        
    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
      <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
        <i class="fa fa-fw fa-sitemap"></i>
        <span class="nav-link-text">Denúncias</span>
      </a>
      <ul class="sidenav-second-level collapse" id="collapseMulti">
        <li>
          <a href="#">Em analise</a>
        </li>
        <li>
          <a href="#">Finalizadas</a>
        </li>

        <li>
          <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti2">Redes Sociais</a>
          <ul class="sidenav-third-level collapse" id="collapseMulti2">
            <li>
              <a href="#">Facebook</a>
            </li>
            <li>
              <a href="#">Whatsapp</a>
            </li>
            <li>
              <a href="#">Instagram</a>
            </li>
             <li>
              <a href="#">Google+</a>
            </li>

<ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         
              <div class="menu">
              <div class="collapse navbar-collapse" id="navbarResponsive" height="700">


                
                </ul>
              </div>
            </nav>

            <div class="content-wrapper">

              <div class="container-fluid">

     <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                  <li class="breadcrumb-item">
                    <a style="color:antiquewhite" href="feedAdm">Feed de Denúncias</a>
                  </li>
                  <li class="breadcrumb-item">
                     <a style="color:antiquewhite" href="valuerPendente">Novas Solicitações de Avaliadores</a>
                  </li>
                  <li class="breadcrumb-item">
                     <a style="color:antiquewhite" href="graficoAdm">Gráficos</a>
                  </li>
                   <li class="breadcrumb-item">
                     <a style="color:antiquewhite" href="cadastro-adm.html">Adicionar um novo administrador</a>
                  </li> 
                 
                </ol>

                <ul class="navbar-nav ml-auto">
                  </div>
       

      <!-- Area Chart Example -->
  

    <div class="box">

        <h1 style="color: #2ABE4A">Gráficos e estatísticas</h1>
         <h2 style="color: #2ABE4A">Acessos por rede social</h2>
        <small style="color: #2ABE4A">A analise dos dados são feitas através das denúncias efetuadas.</small>
        </br>
        <small style="color: #2ABE4A">Para observar a legenda passe o cursor do mouse nas fatias do gráfico.</small>

        <div class="box-chart" style="padding-left: ">

            <canvas id="GraficoPizza" style="width:100%;"></canvas>

            <script type="text/javascript">

                var options = {
                    responsive:true
                };

                var data = [
                    {
                        value: randomnb(),
                        color:"#F53515",
                        highlight: "#A81C0C",
                        label: "Instagram"
                    },
                    
                    {
                        value: randomnb(),
                        color: "#0BB5ED",
                        highlight: "#0B56ED",
                        label: "twitter"
                    },
                    {
                        value: randomnb(),
                        color: "#FF0012",
                        highlight: "#500D00",
                        label: "Google +"
                    },
                    {
                        value: randomnb(),
                        color: "#290CC8",
                        highlight: "#2947C8",
                        label: "Facebook"
                    }
                   
                ]
                
                window.onload = function(){

                    var ctx = document.getElementById("GraficoPizza").getContext("2d");
                    var PizzaChart = new Chart(ctx).Pie(data, options);
                }  
            </script>      




        

        
         
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <!-- Scroll to Top Button-->


    <!-- Logout Modal-->
      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Tem certeza que deseja sair?</h5>
              <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
              </button>
            </div>
            <div class="modal-body">Selecione "Logout" para encerrar a sessão.</div>
            <div class="modal-footer">
              <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
              <a class="btn btn-success" href="logout">Logout</a>
            </div>
          </div>
        </div>
      </div>

    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>    
    
    <div id="id01" class="w3-modal" style="padding-left: 200px; padding-top: 134px;">
      <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width: 500px;">
  
        <div class="w3-center"><br>
          <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal" >&times;</span>
          
        </div>
  
        <h2 style="text-align:center; color: #28a745">Perfil</h2>
        
        <div class="card4" style="height: 600px;">
          <img src="img/team2.png" alt="John" style="width:100%">
          <h1>João Vaz</h1>
          <p class="title">administrador</p>
          <center><p style="color:#A9A9A9; width: 278px; border: solid 1px;"> E-Mail: exemplo@exemplo.com</p></center>
          
          
          <details>
            <summary style="color: #28a745;">Mostrar suas Denúncias</summary> </br>
          </details></center>

          <div style="margin: 24px 0;">
            
            <a href="#"><i class="fa fa-twitter"></i></a>  
            
            <a href="#"><i class="fa fa-facebook"></i></a> 
         </div>
         <button2 onclick="document.getElementById('id02').style.display='block'" class="w3-button w3-green w3-large">Editar</button2></br>
        </div>
  
      </div>
    </div>
  </div>

  <div id="id02" class="w3-modal" style="padding-left: 200px; padding-top: 300px;">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:500px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        
      </div>

      <h2 style="text-align:center; color:#28a745">Editar dados pessoais</h2></br>
      
      <div class="card4"></br>
        <center><input name="myFile" type="file"></center></br>
        <p class="title" style="color: #28a745">Alterar nome:</p>
        <center><input type="text" name="nome"></center></br></br>
        <center><p style="color:#A9A9A9; width: 278px; border: solid 1px;"> E-Mail: exemplo@exemplo.com</p></center>
        
    </br>
        
       <button2 style="background-color: #28a745">Salvar</button2></br></br>
      </div>

    </div>
  </div>
</div>

<footer class="sticky-footer">
  <div class="container">
    <div class="text-center">
      <small>Todos os direitos Reservados &copy; Appcívico 2017</small>
    </div>
  </div>
</footer>


    <!-- Bootstrap core JavaScript-->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/popper/popper.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin.min.js"></script>
  </div>
</body>

</html>