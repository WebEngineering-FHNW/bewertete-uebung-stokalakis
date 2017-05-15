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
			<p>your party's public id is: ${party.publicID}</p>
			<div class="input-group">
				<form action="/playlist/create" method="post">
					<input type="text" class="form-control" name="namePlaylist"
						placeholder="Name your playlist" aria-describedby="basic-addon1">
					<input type="hidden" name="adminID" value="${party.adminID}">
					<button type="submit" class="btn btn-default">Create</button>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<asset:javascript src="bootstrap.js" />
</body>
</html>
