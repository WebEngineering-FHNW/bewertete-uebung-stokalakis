<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MusiQ App</title>
    <asset:stylesheet src="bootstrap.css" />
    <asset:stylesheet src="custom.css" />
  </head>
  <body>
    <div class="container">
      <div class="jumbotron">
        <!--<h1>Welcome to Musiq</h1>-->
        <p>Your party's public ID is: ${party.publicID}</p>
        <p class="lead">Enter your name and you are ready to go!</p>
        <form action="/playlist/create" method="post">
            <div class="input-group-lg">
                <label for="partyID" class="sr-only">Name</label>
                <input type="text" name="namePlaylist" class="form-control" placeholder="Name your playlist" required autofocus>
                <input type="hidden" name="adminID" value="${party.adminID}">
                <br/>
                <button class="btn btn-lg btn-primary" type="submit">Go!</button>
            </div>
        </form>
      </div>
    </div>
  </body>
</html>