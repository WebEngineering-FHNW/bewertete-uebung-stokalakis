<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MusiQ App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<asset:stylesheet src="custom.css" />
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand">MusiQ App</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Welcome</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="/description">Project description</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to the MusiQ App</h1>
			<p class="lead">Create a party where your friends can add their
				favourite songs.</p>
			<p>
			<form class="form-signin">
				<!--<button class="btn btn-lg btn-success" type="submit">Create Party</button>-->
				<a
					href="${grailsApplication.config.app.spotify?.auth_url}?client_id=${grailsApplication.config.app.spotify?.client_id}&response_type=code&redirect_uri=${grailsApplication.config.app.spotify?.redirect_uri}&scope=${grailsApplication.config.app.spotify?.scope}&state=${session.id}"
					class="btn btn-lg btn-success" role="button">Create party</a>
				<!--<a href="https://accounts.spotify.com/authorize/?client_id=4a5ac7cf14e5401eb23430dc40164849&response_type=code&redirect_uri=http://localhost:8080/login/callback&scope=user-read-email playlist-read-private playlist-modify-private user-read-playback-state user-modify-playback-state&state=34fFs29kd09" class="btn btn-info" role="button">New party</a>-->
			</form>
			</p>
			<hr />
			<p class="lead">Join a party by entering the ID.
			<form action="/playlist/join" method="post">
				<div class="input-group-lg">
					<label for="partyID" class="sr-only">Party-ID</label> <input
						name="partyID" id="inputEmail" class="form-control"
						placeholder="Party-ID" required autofocus> <br />
					<button class="btn btn-lg btn-info" type="submit">Join
						party</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
