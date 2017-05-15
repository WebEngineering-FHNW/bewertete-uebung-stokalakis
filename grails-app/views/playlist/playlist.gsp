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
			${party.name}
		</div>
	</div>
	<g:each var="song" in="${party.songs}">
		<li>
			<a href="#">${song.name}</a>
		</li>
	</g:each>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<asset:javascript src="bootstrap.js" />
</body>
</html>