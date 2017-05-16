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
        <p class="lead">Party: ${party.name}</p>
        <!-- TODO: Resolve Host -->
        <p class="lead">Host: [hardcoded]</p>
      </div>
      <ul class="media-list">
      <g:each var="song" in="${party.songs}">
        <li class="media" style="padding-left: 15px;">
          <div class="media-left">
            <a href="#">
              <img class="media-object" src="${song.album.images[2].url}">
            </a>
          </div>
          <div class="media-body">
            <a href="#">
            <h4 class="media-heading">${song.name}</h4>
            <p>${song.artists[0].name} - ${song.album.name}</p>
             </a>
          </div>
        </li>
      </ul>
    </div>
  </body>
</html>