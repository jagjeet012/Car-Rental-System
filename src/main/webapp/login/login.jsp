
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap template site</title>
<link rel="stylesheet" href="css/login.css">
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

	<!--Pulling Awesome Font -->


	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<form action="LoginController">
					<div class="form-login">
						<h4>!!Welcome!!</h4>
						<input type="text" id="loginName"
							class="form-control input-sm chat-input" placeholder="login name"
							name="loginName" /> <input type="password" id="loginPassword"
							class="form-control input-sm chat-input" placeholder="password"
							name="password" />
						<div class="wrapper">
							<span class="group-btn"> <input type="submit"
								value="Login" class="btn btn-danger">

							</span>
						</div>
					</div>
				</form>



			</div>
		</div>
	</div>
</body>