<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MusiQ App</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<asset:stylesheet src="custom.css" />
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<!--<h1>Welcome to Musiq</h1>-->
			<a href="/" class="btn btn-lg btn-success" role="button">Close party</a>
			<p class="lead">Party: ${party.name}</p>
			<p>Your party's public ID is: ${party.publicID}</p>

			<g:if test="${admin}">
				<p>Your party's admin ID is: ${party.adminID}</p>
			</g:if>
			<p class="lead">Host: ${user.id}</p>
			
			<g:if test="${admin}">
				<a href="/search/index/${party.adminID}" class="btn btn-lg btn-success" role="button">Search</a>
				<a href="/playlist/play/${party.adminID}" class="btn btn-success btn-lg">
                  <span class="glyphicon glyphicon-play" aria-hidden="true"></span>
                </a>
			</g:if>
			<g:else>
				<a href="/search/index/${party.publicID}" class="btn btn-lg btn-success" role="button">Search</a>
			</g:else>
			
			<!--  TODO: If Admin: Play, Pause, Delete, (Shuffle?), previous, next button -->
			<!--  Optional TODO: Input field with username (atm, we don't know who adds songs) -->
			<!--  TODO: Proper exception handling -->

		</div>
		<ul class="media-list">
			<g:each var="song" in="${party.songs}">
				<li class="media" style="padding-left: 15px;">
					<div class="media-left">
						<a href="#"> <img class="media-object"
							src="${song.image}">
						</a>
					</div>
					<div class="media-body">
						<a href="#">
							<h4 class="media-heading">${song.name}</h4>
							<p>${song.artist} - ${song.album}</p>
						</a>
					</div>
				</li>
			</g:each>
		</ul>
	</div>
</body>
</html>