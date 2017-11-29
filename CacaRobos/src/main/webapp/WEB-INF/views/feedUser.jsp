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
  <title>Feed Comentario</title>
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
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion" style="padding-top: px;">
          <center><a><img border="0" alt="Logo" src="resources/img/logo.png" 
            width="100" height="100">
        </a></center>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard" style="padding-top: 17px;">
          <a class="nav-link" href="enviarDenuncia">
            <i class="fa fa-wpforms"></i>

            <i class="fa fa-fw fa-dashboard"></i>

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
          <a class="nav-link" href="graficoUser">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Estatistícas</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="graficoUser">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Gráficos</span>
          </a>
        </li>

      </ul>
     
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
         
        <li class="nav-item">

          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">

          <a class="nav-link" data-toggle="modal" data-target="#exampleModal href="logout" style="color: #28a745">
            <a href="logout"><i class="fa fa-fw fa-sign-out"></i>Logout</a></a>

        </li>
      </ul>
    </div>
  </nav>
  
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb" >
         <li class="breadcrumb-item">
          <a href="#">Feed de Denúncias</a>
        </li>
      </ol>
      
      
      <!-- Area Chart Example-->
       <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
            
        <li class="nav-item">
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

        <div class="container">  
        <div class="row">
        <c:forEach items="${feedReportUser }" var="report">
            <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
              <div class="card h-100">
                <div class="card-body">
                  <h4 class="card-title">
                    <p><b><u>${report.title }</u></p></b></h4>
                  <p align="left"><p><b><span style="color:#28a745">Endereço da denúncia: </span></b> ${report.link }
                             <br>
                            <b><span style="color:#28a745">Robô: </span></b> ${report.voteCounting.isARobot }
                            <br>
                            <b><span style="color:#28a745">Perfil comum: </span></b> ${report.voteCounting.isNotARobot }
                            <br>
                            <br>
                            <b><span style="color:#28a745">Status: </span></b> Processamento</p></p>
                            
                            <!--Modal Descrição da Denúncia!-->
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal2">Descrição da Denúncia</button>
                            
                                 <!-- Modal -->
                                 <div class="modal fade" id="myModal2" role="dialog">
                                   <div class="modal-dialog">
                                   
                                     <!-- Modal content-->
                                     <div class="modal-content">
                                       <div class="modal-header">
                                         <button type="button" class="close" data-dismiss="modal">&times;</button>
                                         <h4 class="modal-title">Descrição da Denúncia</h4>
                                       </div>
                                       <div class="modal-body">
                                          <b><span style="color:#28a745">Descrição da denúnia: </span></b>${report.description}
                                        <br>
                                               <br>
                                               <br>
                                       </div>
                                       <div class="modal-footer">
                                         <button type="button" class="btn btn-info btn-lg" data-dismiss="modal">Close</button>
                                       </div>
                                     </div>
                                     
                                   </div>
                                 </div>
                                 <br>
                                 <br>

                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#${report.id }">Comente Aqui!</button>
                            <!-- Modal -->
                                <div class="modal fade" id="${report.id }" role="dialog">
                                  <div class="modal-dialog">
                                  
                              <!-- Modal content-->
                                    <div class="modal-content">
                                      <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">${report.title }</h4>
                                      </div>
                                      <div class="modal-body">
                                          <li>
                                          <c:forEach items="${report.commentaryList }" var="commentary">
                                              <div class="comment-main-level">
                                                  <div class="comment-box">
                                                      <div class="comment-head">
                                                          <h6 class="comment-name by-author"><b>${commentary.user.nickname } - </b><b>${commentary.user.login.userType }</b></h6>
                                                      </div>
                                                      <div class="comment-content">
                                                          ${commentary.description }
                                                      </div>
                                                      <br>
                                                      <br>
                                                      </div>
                                                      </div>
                                                      </c:forEach>
                                                      
                                            </li>
                                              <br>
                                              <br>
  
                           <p><b><span style="color:#28a745">Comente aqui: </span></b></p>
                           <form action="createCommentary/${report.id }" method="get">
                           <textarea rows="2" cols="100" name="description" class="form-control vresize" id="MyID3"></textarea> <br>
                          <button type="submit" class="btn btn-success">Enviar comentario</button></center>
                          </form>
                                      </div>
                                      <div class="modal-footer">
                                        <button type="button" class="btn btn-success" data-dismiss="modal">Fechar</button>
                                      </div>
                                    </div>
                                    
                                  </div>
                                </div>
                                </div>
                                </div>
                                
                  </div>
                  </c:forEach>
                </div>
              </div>
              <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <br>
                  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
              </nav>


             
      

         
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
