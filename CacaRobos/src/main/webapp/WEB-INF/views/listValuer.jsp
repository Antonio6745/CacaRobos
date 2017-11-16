<!DOCTYPE html>
<html lang="PT-BR">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Ca�a Rob�s</title>
<!-- Bootstrap core CSS-->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">

<link rel="shortcut icon" href="resources/img/logo.ico"
	type="image/x-icon" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<!-- Navigation -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container"></div>
		<img src="resources/img/logo.ico"
			style="padding-right: 500px; padding-top: -20px;">
		</div>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<ul class="navbar-nav ml-auto">



			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>
					Logout
			</a></li>
		</ul>

	</nav>

	<!--Menu lateral-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<center>
					<a><img border="0" alt="Logo" src="resources/img/logo.png"
						width="100" height="100"> </a>
				</center>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Estatisticas">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Charts"><a class="nav-link" href="graficoAdm"> <i
						class="fa fa-fw fa-area-chart"></i> <span class="nav-link-text">Estatisticas</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Tables"><a class="nav-link" href="gerenManager"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">Avaliadores</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Menu Levels"><a
					class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
					href="#collapseMulti" data-parent="#exampleAccordion"> <i
						class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">Den�ncias</span>
				</a>
					<ul class="sidenav-second-level collapse" id="collapseMulti">
						<li><a href="#">Em analise</a></li>
						<li><a href="#">Finalizadas</a></li>

						<li><a class="nav-link-collapse collapsed"
							data-toggle="collapse" href="#collapseMulti2">Redes Sociais</a>
							<ul class="sidenav-third-level collapse" id="collapseMulti2">
								<li><a href="#">Facebook</a></li>
								<li><a href="#">Whatsapp</a></li>
								<li><a href="#">Instagram</a></li>


								<ul class="navbar-nav ml-auto">
									<li class="nav-item dropdown">

										<div class="menu">
											<div class="collapse navbar-collapse" id="navbarResponsive"
												height="700">
								</ul>
		</div>
	</nav>

	<div class="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="feed.html">Feed de
						Den�ncias</a></li>
				<li class="breadcrumb-item"><a href="#">Rob�s Capturados</a></li>
				<li class="breadcrumb-item"><a href="Graficos.html">Gráficos</a>
				</li>
			</ol>

			<ul class="navbar-nav ml-auto">


				<li class="nav-item" style="padding-left: 1385px;">
					<form class="form-inline my-2 my-lg-0 mr-lg-2">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="ultilize Tags para facilitar a busca"
								maxlength="15"> <span class="input-group-btn">
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
			<!-- Area Chart Example-->
			<c:forEach items="${listValuers }" var="valuer">
				<div class="card mb-3">
					<div class="card-header">
						<div class="row" style="padding-left: 400px;">
							<div class="col-lg-8">
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-custom">
										<div class="panel-heading" role="tab" id="headingOne">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapseOne" aria-expanded="true"
													aria-controls="collapseOne"> <i
													class="glyphicon glyphicon-plus"></i>
													<center style="color: white; padding-left: 0px;">
														${valuer.name }</center>
												</a>
											</h4>
										</div>
										<div id="collapseOne" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingOne">
											<div class="panel-body animated zoomOut">
												<center>
													</br>
													<p>
														<b><span style="color: #28a745">Email para
																contato: </span></b> ${valuer.username } <br> <br> <b><span
															style="color: #28a745">Total de avaliação: </span></b> <b>É
															um robo: ${report.voteCounting.isARobot }</b></br> <b>Não é um
															robô: ${report.voteCounting.isNotARobot }</b></br> <br> <br>
														<b><span style="color: #28a745">Status: </span></b> Ativo
													</p>

													<button type="button" class="btn btn-success">Excluir
														Voluntario</button>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</c:forEach>




			<!-- /.content-wrapper -->

			<!-- /.container-fluid-->
			<!-- /.content-wrapper-->
			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top"> <i
				class="fa fa-angle-up"></i>
			</a>
			<!-- Logout Modal-->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Tem certeza
								que deseja sair?</h5>
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">Selecione "Logout" para encerrar a
							sessão.</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Cancelar</button>
							<a class="btn btn-primary" href="logout">Logout</a>
						</div>
					</div>
				</div>
			</div>
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
