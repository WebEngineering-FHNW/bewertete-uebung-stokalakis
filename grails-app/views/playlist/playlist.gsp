<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="nav" />
<meta HTTP-EQUIV="refresh" content="15">

<title>MusiQ App</title>

</head>
<body>
	<div class="container">
		<div class="jumbotron transparent">

			<!--  Information about your party starts here -->
			<!--  Invalid HTML: Headers (h3 & h4) are needed by Bootrstrap to steer size; but actually header tags are not allowed before a div -->
			<div class="row text-left">
				<h3>
					<div class="col-md-6">
						<span class="label label-info">Party</span>
					</div>
				</h3>
				<h4>
					<div class="col-md-6">
						<div class="well well-sm">${party.name}</div>
					</div>
				</h4>
			</div>
			<div class="row text-left">
				<h3>
					<div class="col-md-6">
						<span class="label label-info">Your party's public ID is</span>
					</div>
				</h3>
				<h4>
					<div class="col-md-6">
						<div class="well well-sm" id="p1">${party.publicID}</div>
					</div>
				</h4>
			</div>
			<g:if test="${admin}">
				<div class="row text-left">
					<h3>
						<div class="col-md-6">
							<span class="label label-info">Your party's admin ID is</span>
						</div>
					</h3>
					<h4>
						<div class="col-md-6">
							<div class="well well-sm">${party.adminID}</div>
						</div>
					</h4>
				</div>
			</g:if>
			<div class="row text-left">
				<h3>
					<div class="col-md-6">
						<span class="label label-info">Host</span>
					</div>
				</h3>
				<h4>
					<div class="col-md-6">
						<div class="well well-sm">${user.id}</div>
					</div>
				</h4>
			</div>
			<!-- Information about your party ends here -->

			<!-- Admin buttons start here-->
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
				<!-- Admin buttons end here-->
			</g:if>
			<g:else>
				<a href="/search/index/${party.publicID}"
					class="btn btn-success btn-lg"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</a>
			</g:else>
		</div>

		<!-- Playlist is created here; page refreshes every 15s to show newly added songs -->
		<g:if test="${party.songs.size() > 0}">
			<div class="well transparent">
				<ul class="media-list">
					<g:each var="song" in="${party.songs}">
						<li class="media" style="padding-left: 15px;">
							<div class="media-left">
								<img class="media-object" alt="album-cover" src="${song.image}">
							</div>
							<div class="media-body">
								<h4 class="media-heading">${song.name}</h4>
								<p>${song.artist} - ${song.album}</p>
							</div> <g:if test="${admin}">
								<div class="media-right">
									<a
										href="/playlist/delete/${party.adminID}?songID=${song.songID}"
										class="btn btn-success btn-lg"> <span
										class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</a>
								</div>
							</g:if>
						</li>
					</g:each>
				</ul>
			</div>
		</g:if>
	</div>
</body>
</html>