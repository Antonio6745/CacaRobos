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
  <title>Minhas Denuncias</title>
  <!-- Bootstrap core CSS-->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="resources/css/josb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarResponsive" >
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
          <center><a><img border="0" alt="Logo" src="resources/img/logo.png" 
            width="100" height="100">
        </a></center>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard" style="padding-top: 17px;">
          <a class="nav-link" href="enviarDenuncia">
            <i class="fa fa-wpforms"></i>
            <span class="nav-link-text">Nova denúncia</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="listFeedUser">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Feed de Denúncias</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="tables.html">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Estatistícas</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="tables.html">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Gráficos</span>
          </a>
        </li>

      </ul>
     
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
           <a href="logout"> <i class="fa fa-fw fa-sign-out"></i>${userLoggedIn.nickname }</a></a>
        </li>
      </ul>
    </div>
  </nav>
  
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb" >
         <li class="breadcrumb-item">
          <a href="">Minhas Denúncias</a>
        </li>
      </ol>
      
      <!-- Area Chart Example-->
       <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
            
        <li class="nav-item" >
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Procurar por...">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li></br>
      
  <c:forEach items="${listMyReport }" var="myRep">
      <div class="card mb-3">
        <div class="card-header">
      <div class="row" >
        <div class="col-lg-8">
          <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-custom">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#${myRep.id }" aria-expanded="true" aria-controls="collapseOne">
                            <i class="glyphicon glyphicon-plus"></i>
                            <center style="color: white; padding-left: 0px;" >${myRep.title} </center>
                        </a>
                        <a href="deleteReport?id=${myRep.id}">X</a>
                    </h4>
                </div>
                <div id="${myRep.id }" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body animated zoomOut">
                        <center></br><p><b><span style="color:#28a745">Endereço da denúncia: </span></b> ${myRep.link }
                         <br>
                          <br>
                         <b><span style="color:#28a745">Descrição da denúncia: </span></b> ${myRep.description }
                            <br>
                          <br>

                        <b><span style="color:#28a745">Total de avaliação: </span></b></br><br>
                        <b>É um robo: ${report.voteCounting.isARobot }</b></br>
                        <b>Não é um robô: ${report.voteCounting.isNotARobot }</b></br>
                          <br>
                        <b><span style="color:#28a745">Status: </span></b> ${myRep.status }</p>
                        
                                          <a href="listCommentary?id=${myRep.id}"> <span style="color:#28a745">Ir para seção de comentários-> </span></a>
                    </div>
                </div>
            </div>
          </div>
               
              </div>
            </div>
          </div>
        </div>
   </c:forEach>

        
         
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    
    
    
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
