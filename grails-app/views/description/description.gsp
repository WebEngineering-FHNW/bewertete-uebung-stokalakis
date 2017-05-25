<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="layout" content="nav" />

<title>Project description</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<asset:stylesheet src="custom.css" />

</head>

<body>

	<!-- Project description starts here; same content as the initial commit proposal -->

	<div class="container">

		<div class="jumbotron transparent">
			<h1>About MusiQ App</h1>
			<p class="lead">The MusiQ App allows you to create and
				administrate a playlist if you have a Spotify Premium Account. Share
				the ID with your friends and allow them to search and add tracks to
				your playlist. As admin, you have the full control over the playlist
				and you can stop the playback and skip or delete certain songs.</p>
		</div>

		<div class="well transparent">
			<div class="row marketing">
				<div class="col-lg-6">
					<h4>Problem</h4>
					<p>Partying with friends. All the boys want to connect to the
						UE BOOM to play their cool music. Switching beetwen different
						devices to connect to the UE BOOM is painful and time-consuming.</p>

					<h4>Solution</h4>
					<p>
						I want to program a web app which allows me, sending music titles
						into a queue.<br> A webserver acts as the connector between
						different devices, usergroups manage the access rights. The
						webserver needs an active Spotify account.<br> A device
						(Laptop, PC, iPad) starts the web app and logs into it's MusiQ
						account. This account acts as the master. Other users also start
						the app and log-in into their MusiQ accounts. The master account
						is able to create and modify playlists via the Spotify Web API.
						The playlist itself stays with Spotify. The master device is the
						only device which is connected with the audio device (eg. UE
						BOOM).<br> A client-usergroup is assigned to a master-account
						and connects to the webserver. The client-usergroup is able to
						search for music titles and add them to a playlist ("Queue").<br>
						The master account always has the full control over the
						playlist(s) ("Queues") and is able to add, remove and modify
						active clients and music titles.<br> A nice to have feature
						is a poll functionality to allow the clients to vote for certain
						music titles, genres, singers.
					</p>

				</div>

				<div class="col-lg-6">
					<h4>Future</h4>
					<p>The bigger idea behind this is to be able to use a MusiQ
						account for several streaming services (Youtube, Apple Music etc)
						- and not being bound to Spotify; or even stream your own local
						stored music to a master device, whereat an internet connection is
						not needed at all (master device itself acts then as a webserver).</p>

					<h4>Update, 10.05.2017</h4>
					<p>New idea: User does not need an MusiQ account - it's enough
						to know the unique public ID of the playlist to add a song ("login
						screen": Name and ID)</p>

					<h4>TODOs</h4>
					<p>
						- (Optional) Shuffle, Repeat, Pause/Resume, Play specific song
						button<br> - (Optional) Input field with username (atm, we
						don't know who adds songs) / Poll functionality<br>-
						(Optional) Mark current playing song<br> - Testing<br>-
						(Optional) What happens if someone wants to add a song after one
						hour (token expired)?<br>- (Optional) Pagination for search
						results<br> - (Optional) Copy to clipboard button
					</p>
				</div>
			</div>
		</div>

		<footer class="footer">
			<p>&copy; 2017 Tokalakis, Samuel</p>
		</footer>

	</div>

</body>
</html>
