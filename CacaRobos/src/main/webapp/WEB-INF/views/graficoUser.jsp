<!DOCTYPE html>

<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">

   <title>Caça Robôs</title>
    <script src="resources/Chart.min.js"></script>

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

    <link rel="shortcut icon" href="logo.ico" type="image/x-icon" />

   

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
    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Estatisticas">


     <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
      <a class="nav-link" href="graficoUser">
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
              <a href="#">Twitter</a>
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
                    <a href="feedUser">Feed de Denúncias</a>
                  </li>
                  <li class="breadcrumb-item">
                    <a href="myReport">Minhas Denúncias</a>
                  </li>
                  <li class="breadcrumb-item">
                    <a href="graficoUser">Gráficos</a>
                  </li> 
                </ol>

                <ul class="navbar-nav ml-auto">
         
         
          <li class="nav-item" style="padding-left: 1385px;">
            <form class="form-inline my-2 my-lg-0 mr-lg-2">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="ultilize Tags para facilitar a busca" maxlength="15">
                <span class="input-group-btn">
                  <button class="btn btn-primary" type="button">
                    <i class="fa fa-search"></i>
                  </button>
                </span>
              </div>
            </form>
          </li>

          </br>
        </ul>

                <!-- Area Chart Example -->
  

    <div class="box">

        <h1 style="color: #2ABE4A">Gráficos e estatísticas</h1>
         <h2 style="color: #2ABE4A">Acessos por rede social</h2>
        <small style="color: #2ABE4A">A analise dos dados são feitas através das denúncias efetuadas.</small>

        <div class="box-chart" style="padding-left: ;">

            <canvas id="GraficoPizza" style="width:100%;"></canvas>

            <script type="text/javascript">

                var options = {
                    responsive:true
                };

                var data = [
                    {
                        value: ${basicStatistcs.instagramReports},
                        color:"#F53515",
                        highlight: "#A81C0C",
                        label: "Instagram"
                    },
                    
                    {
                        value: ${basicStatistcs.twitterReports},
                        color: "#0BB5ED",
                        highlight: "#0B56ED",
                        label: "twitter"
                    },
                    {
                        value: ${basicStatistcs.googlePlusReport},
                        color: "#FF0012",
                        highlight: "#500D00",
                        label: "Google +"
                    },
                    {
                        value: ${basicStatistcs.facebookReports},
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
            <a class="btn btn-primary" href="logout">Logout</a>
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


        </div>
    
    </div>

</body>

</html>