<!DOCTYPE html>
<html lang="en">
   <head>
      <meta name="layout" content="nav" />
      <title>MusiQ App</title>
   </head>
   <body>
      <div class="container">
         <!-- Search starts here -->
         <div class="jumbotron transparent">
            <p class="lead">Search a song you'd like to add to the playlist.</p>
            <form action="/search/index/${id}" method="post">
               <div class="input-group-lg">
                  <input type="text" name="search" class="form-control"
                     placeholder="Song, Artist or Album" required autofocus> <br />
                  <button type="submit" class="btn btn-success btn-lg"
                     aria-label="Left Align">
                  <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                  </button>
               </div>
            </form>
         </div>
         <!-- Search ends here -->
         <!-- Search resultset starts here, if resultset is not empty -->
         <g:if test="${searchSong}">
            <div class="well transparent">
               <ul class="media-list">
                  <g:each var="song" in="${searchSong.tracks.items}">
                     <li class="media">
                        <div class="media-left">
                           <img class="media-object" alt="album-cover"
                              src="${song.album.images[2].url}">
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
            </div>
         </g:if>
         <!-- Search resultset ends here -->
      </div>
   </body>
</html>