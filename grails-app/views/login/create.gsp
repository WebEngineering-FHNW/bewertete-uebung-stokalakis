<!DOCTYPE html>
<html lang="en">
   <head>
      <meta name="layout" content="nav" />
      <title>MusiQ App</title>
   </head>
   <body>
      <div class="container">
         <div class="jumbotron transparent">
            <p class="lead">Enter a playlist name and you are ready to go!</p>
            <!-- Form to add give the playlist a name, uses create method from controller -->
            <form action="/playlist/create" method="post">
               <div class="input-group-lg">
                  <input type="text" name="namePlaylist" class="form-control"
                     placeholder="Name your playlist" required autofocus>
                  <!--  Adding hidden field as we need adminID later -->
                  <input type="hidden" name="adminID" value="${party.adminID}">
                  <br />
                  <button class="btn btn-lg btn-info" type="submit">Go!</button>
               </div>
            </form>
         </div>
      </div>
   </body>
</html>