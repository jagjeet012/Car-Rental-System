<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap template site</title>
<link rel="stylesheet" href="css/layout.css">
<!-- meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</head>
<body>
	<!-- header -->
	<div class="container-fluid header">
		<header>
			<c:import url="header.jsp"></c:import>
		</header>
	</div>
	<!-- end header -->

	<!-- menu navbar -->
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<c:import url="menu/menu.jsp"></c:import>
	</nav>
	<!-- end navbar -->



	<!-- content -->

	<div class="container-fluid">
		<div class="content row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<c:import url="login/login.jsp"></c:import>
			</div>
			<div class="col-sm-4"></div>

		</div>
	</div>

	<footer>© 2018-2019</footer>

</body>
</html>