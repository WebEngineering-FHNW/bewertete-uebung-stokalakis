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
			<div class="row text-left">
			  <h3><div class="col-md-6"><span class="label label-info">Party</span></div></h3>
			  <h4><div class="col-md-6"><div class="well well-sm">${party.name}</div></div></h4>
			</div>
			<div class="row text-left">
			  <h3><div class="col-md-6"><span class="label label-info">Your party's public ID is</span></div></h3>
			  <h4><div class="col-md-6"><div class="well well-sm">${party.publicID}</div></div></h4>
			</div>
			<g:if test="${admin}">
				<div class="row text-left">
				  <h3><div class="col-md-6"><span class="label label-info">Your party's admin ID is</span></div></h3>
				  <h4><div class="col-md-6"><div class="well well-sm">${party.adminID}</div></div></h4>
				</div>
			</g:if>
			<div class="row text-left">
			  <h3><div class="col-md-6"><span class="label label-info">Host</span></div></h3>
			  <h4><div class="col-md-6"><div class="well well-sm">${user.id}</div></div></h4>
			</div>
			<g:if test="${admin}">
				<div class="btn-group btn-group-xs" role="group">
					<a href="/search/index/${party.adminID}"
						class="btn btn-success btn-lg"> <span
						class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</a> <a href="/playlist/play/${party.adminID}"
						class="btn btn-success btn-lg"> <span
						class="glyphicon glyphicon-play" aria-hidden="true"></span>
					</a> <a href="/playlist/pause/${party.adminID}"
						class="btn btn-success btn-lg"> <span
						class="glyphicon glyphicon-stop" aria-hidden="true"></span>
					</a> <a href="/playlist/previous/${party.adminID}"
						class="btn btn-success btn-lg"> <span
						class="glyphicon glyphicon-fast-backward" aria-hidden="true"></span>
					</a> <a href="/playlist/next/${party.adminID}"
						class="btn btn-success btn-lg"> <span
						class="glyphicon glyphicon-fast-forward" aria-hidden="true"></span>
					</a>
				</div>
			</g:if>
			<g:else>
				<a href="/search/index/${party.publicID}"
					class="btn btn-success btn-lg"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</a>
			</g:else>
		</div>
		<ul class="media-list">
			<g:each var="song" in="${party.songs}">
				<li class="media" style="padding-left: 15px;">
					<div class="media-left">
						<img class="media-object" src="${song.image}">
					</div>
					<div class="media-body">
						<h4 class="media-heading">${song.name}</h4>
						<p>${song.artist} - ${song.album}</p>
					</div> <g:if test="${admin}">
						<div class="media-right">
							<a href="/playlist/delete/${party.adminID}?songID=${song.songID}"
								class="btn btn-success btn-lg"> <span
								class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</a>
						</div>
					</g:if>
				</li>
			</g:each>
		</ul>
	</div>
</body>
</html>