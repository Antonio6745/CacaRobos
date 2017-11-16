<!DOCTYPE html>
<html lang="br">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Caça-Robôs</title>
  <!-- Bootstrap core CSS-->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin.css" rel="stylesheet">
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
            <span class="nav-link-text">Nova denúncia</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="listFeedUser">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Feed de Den�ncias</span>
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
          <a href="">Enviar Denúncia</a>
        </li>
      </ol>
      
    
      <center>
      <ol class="breadcrumb" style="background-color: #28a745; width: 550px;">
          <li class="breadcrumb-item" >
            <a> <span style="color:white; font-size: 17pt; padding-left: 160px;">Faça sua denúncia</span></a>
          </li>
      </ol>
    </center>
      
    </br>
  </br>
</br>
        <center><form action="sendReport">
          <fieldset class="grupo">
           <div class="campo" style="padding-left: 620px;">
                    <label for="titulo"  style="font-size: 23pt;">Título da denúncia: <span style="color:red">*</span> </label>
                   <input type="text" id="nome" name="title" style="width: 25em" value=""> 
                    </br>
              </div> 
              <div class="campo" style="padding-left: 620px;">
                    <label for="nome"  style="font-size: 23pt;">Endereço do suposto perfil: <span style="color:red">*</span> </label>
                    <span style="color:#A9A9A9; font-size: 10pt;"> Exemplo: https://www.denuncia#255.com.br</span><input type="text" id="nome" name="link" style="width: 25em" value=""> 
                    </br>
              </div> 
          </fieldset>
                
              <div class="campo">
                  <label for="nome" style="font-size: 23pt;">Por que está denunciando? <span style="color:red">*</span> </label>
                  <textarea rows="6" style="width: 30em" id="mensagem" name="description"></textarea>
              </div>
        
              <div class="campo" style="padding-top: 20px;">
                  <label>
                    <select name="networkType">
                      <option value="Twitter">Twitter</option>
                      <option value="Facebook">Facebook</option>
                    </select>
                  </label>
              </div>
             <button type="submit" class="btn btn-success">Enviar avaliação</button>
             <br>
            </fieldset>
        </form></center>
        
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
