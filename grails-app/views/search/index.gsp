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
			<p class="lead">Search a song you'd like to add to the playlist.</p>
			<form action="/search/index/${id}" method="post">
				<div class="input-group-lg">
					<label for="partyID" class="sr-only">Party-ID</label> <input
						type="text" name="search" class="form-control"
						placeholder="Song, Artist or Album" required autofocus> <br />
					<button type="submit" class="btn btn-right" aria-label="Left Align">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</div>
			</form>
		</div>
		<g:if test="${searchSong}">
			<ul class="media-list">
				<g:each var="song" in="${searchSong.tracks.items}">
					<li class="media">
						<div class="media-left">
							<img class="media-object" src="${song.album.images[2].url}">
						</div>
						<div class="media-body">
							<h4 class="media-heading">${song.name}</h4>
							<p>${song.artists[0].name} - ${song.album.name}</p>
						</div>
						<div class="media-right">
							<a
								href="/playlist/addSong/${id}?song=${song.id}&publicID=${party.publicID}"
								class="btn btn-success btn-lg"> <span
								class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</a>
						</div>
					</li>
				</g:each>
			</ul>
		</g:if>
	</div>
</body>
</html>
