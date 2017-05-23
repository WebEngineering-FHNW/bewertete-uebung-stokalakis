<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="layout" content="nav" />
<title>MusiQ App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<asset:stylesheet src="custom.css" />
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<!--<h1>Welcome to Musiq</h1>-->
			<p class="lead">Enter a playlist name and you are ready to go!</p>
			<form action="/playlist/create" method="post">
				<div class="input-group-lg">
					<label for="partyID" class="sr-only">Name</label> <input
						type="text" name="namePlaylist" class="form-control"
						placeholder="Name your playlist" required autofocus> <input
						type="hidden" name="adminID" value="${party.adminID}"> <br />
					<button class="btn btn-lg btn-primary" type="submit">Go!</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>