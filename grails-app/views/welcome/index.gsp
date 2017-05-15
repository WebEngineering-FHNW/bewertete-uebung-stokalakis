<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>MusiQ App - Share your music style!</title>

    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="custom.css"/>

  </head>

  <body>

    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">MusiQ App</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#admin">Admin</a></li>
            <li><a href="#user">User</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container">
    	<div class="jumbotron">
			<div class="input-group">
				<a href="${grailsApplication.config.app.spotify?.auth_url}?client_id=${grailsApplication.config.app.spotify?.client_id}&response_type=code&redirect_uri=${grailsApplication.config.app.spotify?.redirect_uri}&scope=${grailsApplication.config.app.spotify?.scope}&state=${session.id}" class="btn btn-info" role="button">New party</a>
<%--				<a href="https://accounts.spotify.com/authorize/?client_id=4a5ac7cf14e5401eb23430dc40164849&response_type=code&redirect_uri=http://localhost:8080/login/callback&scope=user-read-email playlist-read-private playlist-modify-private user-read-playback-state user-modify-playback-state&state=34fFs29kd09" class="btn btn-info" role="button">New party</a>--%>
			</div>
			<br>
			<form>
				<div class="input-group">
				  <input type="text" class="form-control" placeholder="Join a party" aria-describedby="basic-addon1">
				  <button type="button" class="btn btn-default">Join</button>
				</div>
			</form>
    	</div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <asset:javascript src="bootstrap.js"/>
  </body>
</html>
