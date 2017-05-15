<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>MusiQ App - Share your music style!</title>

<asset:stylesheet src="bootstrap.css" />
<asset:stylesheet src="custom.css" />

</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<div class="input-group">
				<form action="/search?publicID=${party.publicID}" method="post">
					<input type="text" class="form-control" name="search"
						placeholder="search" aria-describedby="basic-addon1">
					<button type="submit" class="btn btn-default">Search</button>
				</form>
			</div>
		</div>
		<g:if test="${searchSong}">
			<g:each var="song" in="${searchSong.tracks.items}">
				<li>
					<a href="playlist/addSong?song=${song.id}&publicID=${party.publicID}"><img src="${song.album.images[2].url}" height="64" width="64"/> ${song.artists[0].name} / ${song.album.name} / ${song.name}</a>
				</li>
			</g:each>
		</g:if>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<asset:javascript src="bootstrap.js" />
</body>
</html>
