<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MusiQ App</title>
    <asset:stylesheet src="custom.css" />
    <asset:stylesheet src="bootstrap.min.3.3.7.css" />
  </head>
  <body>
    <div class="container">
      <div class="jumbotron">
        <!--<h1>Welcome to MusiQ App</h1>-->
        <p class="lead">Search a song you'd like to add to the playlist.</p>
        <form action="/search?publicID=${party.publicID}" method="post">
            <div class="input-group-lg">
                <label for="partyID" class="sr-only">Party-ID</label>
                <input type="text" name="search" class="form-control" placeholder="Song, Artist or Album" required autofocus>
                <br/>
                <!-- TODO: Search button not does not show icon / error message missing fonts..? -->
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
                    <a href="playlist/addSong?song=${song.id}&publicID=${party.publicID}">
                      <img class="media-object" src="${song.album.images[2].url}">
                    </a>
                  </div>
                  <div class="media-body">
                     <a href="playlist/addSong?song=${song.id}&publicID=${party.publicID}">
                    <h4 class="media-heading">${song.name}</h4>
                    <p>${song.artists[0].name} - ${song.album.name}</p>
                     </a>
                  </div>
                </li>
            </g:each>
          </ul>
      </g:if>
    </div>
  </body>
</html>
