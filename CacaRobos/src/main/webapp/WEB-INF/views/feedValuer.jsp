<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Caça Robôs</title>
  <script src="resources/javascripts/jquery.js" type="text/javascript"></script>
  <script type="text/javascript">
  $(document).ready(function() {
  var largura = $(window).width(); /* Capturando a do cliente */
  if (largura <= 921) {
  /* Se a Largura do monitor for menor ou = que 921 px */
  $("#hire").hide(); /* Esconde a bandeira azul*/
  $("#resize").hide(); /* Esconde "triangulo" resize no canto inferior direito*/
  }
  else if (tam >= 922) {
  /* Se n�o for a condi��o a cima e for marior ou = a 922 px */
  $("#hire").show(); /* Mostra a bandeira azul*/
  $("#resize").show(); /* Mostra "triangulo" resize no canto inferior direito*/
  }
});
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
  <!-- Navigation-->
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarResponsive" >
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion" style="padding-top: px;">
          <center><a><img border="0" alt="Logo" src="resources/img/logo.png" 
            width="100" height="100">
        </a></center>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard" style="padding-top: 17px;">
          <a class="nav-link" href="index.html">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Enviadas para análise</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="charts.html">
            <i class="fa fa-fw fa-area-chart"></i>
            <span class="nav-link-text">Avaliadores</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="tables.html">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Denúncias</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Denúncias Finalizadas</span>
          </a>
        </li>

        </br>


        <button2 onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large">Perfil</button2>

      </ul>
     
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <a href="logout"><i class="fa fa-fw fa-sign-out"></i>Logout</a></a>
        </li>
      </ul>
    </div>
  </nav>
  
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item" >
          <a href="listFeedValuer" style="color: white">Feed de Denúncias</a>
        </li>
         <li class="breadcrumb-item">
          <a href="#" style="color: white">Robôs Capturados</a>
        </li>
         <li class="breadcrumb-item">
          <a href="#" style="color: white">Gráficos</a>
        </li> 
      </ol>
      
      <!-- Area Chart Example-->
       <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
            
        <li class="nav-item" style="padding-left: 1290px;">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li></br>
      
<c:forEach items="${feedReportValuer }" var="report">
     <div class="card mb-3">
        <div class="card-header">
      <div class="row" style="padding-left: 400px;">
        <div class="col-lg-8">
          <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-custom">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                         <a data-toggle="collapse" data-parent="#accordion" href="#${report.id }" aria-expanded="true" aria-controls="collapseOne">
                            <i class="glyphicon glyphicon-plus"></i>
                            <center style="color: white; padding-left: 0px;" > Denúncia - ${report.title} </center>
                        </a>
                    </h4>
                </div>
               <div id="${report.id }" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body animated zoomOut">
                        <center></br><p><b><span style="color:#28a745">Endereço da denúncia: </span></b> ${report.link }
                         <br>
                          <br>
                         <b><span style="color:#28a745">Descrição da denuncia: </span></b> ${report.description }
                            <br>
                          <br>
						<a href="listCommentary?id=${report.id}"><button> <span style="color:#28a745">Ir para seção de comentários-> </span></button></a>
                       <b><span style="color:#28a745">Não é Robô: </span></b> ${report.voteCounting.isNotARobot }
                            <br>
                          <br>
						  <b><span style="color:#28a745">É Robô: </span></b> ${report.voteCounting.isARobot }
                            <br>
                          <br>
                           <form action="voteRobotTrue">
                           <input type="hidden" name="reportId" value="${report.id }">
                          <button style="background-color: red; width: 150px; float: right">É um robo!</button>
						  </form>
                          <form action="voteRobotFalse">
                           <input type="hidden" name="reportId" value="${report.id }">
						  <button style="background-color: #28a745; width: 150px; float: left;">Não é robo!</button>
						  </form>
                    </div>
                </div>
            </div>
          </div>
               
              </div>
            </div>
          </div>
        </div>
</c:forEach>
         
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
          <img src="resources/img/team2.png" alt="John" style="width:100%">
          <h1>${valuerLoggedIn.name}</h1>
          <p class="title">Avaliador</p>
          <center><p style="color:#A9A9A9; width: 278px; border: solid 1px;">Email:${valuerLoggedIn.login.username} </p></center>
          
          
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