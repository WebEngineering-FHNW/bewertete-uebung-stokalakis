<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="nav" />

<title>MusiQ App</title>

</head>
<body>
	<div class="container">
		<div class="jumbotron transparent">
			<h1>Welcome to the MusiQ App</h1>
			<p class="lead">Create a party where your friends can add their
				favourite songs.</p>
			<p>
			<form class="form-signin">

				<!-- O-AUTH 2.0 starts here; we provide scopes and a state to Spotify -->
				<a
					href="${grailsApplication.config.app.spotify?.auth_url}?client_id=${grailsApplication.config.app.spotify?.client_id}&response_type=code&redirect_uri=${grailsApplication.config.app.spotify?.redirect_uri}&scope=${grailsApplication.config.app.spotify?.scope}&state=${session.id}"
					class="btn btn-lg btn-success" role="button">Create party</a>
			</form>
			<hr />

			<!-- Join a party parts starts here where you're able to login via a admin or public IDs -->
			<p class="lead">Join a party by entering the ID.
			<form action="/playlist/join" method="post">
				<div class="input-group-lg">
					<!-- label for="partyID" class="sr-only">Party-ID</label-->
					<input name="partyID" class="form-control" placeholder="Party-ID"
						required autofocus> <br />
					<button class="btn btn-lg btn-info" type="submit">Join
						party</button>
				</div>
				<g:if test="${error}">
					<h3>
						<span class="label label-danger">${error}</span>
					</h3>
				</g:if>
			</form>
		</div>
	</div>
</body>
</html>
