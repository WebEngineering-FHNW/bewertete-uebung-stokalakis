 # WebEngineering Module, Graded Exercise

## Commit Proposal

Matrikel Number: 10-272-888

Project idea short description: The MusiQ App
[This idea came up to my mind several months ago - I've adapted the scope to meet the webeC project requirements (instead of a smartphone app, I will develop a web app).]

### Problem
Partying with friends. All the boys want to connect to the UE BOOM to play their cool music. Switching beetwen different devices to connect to the UE BOOM is painful and time-consuming.

### Solution
I want to program a web app which allows me, sending music titles into a queue.<br>
A webserver acts as the connector between different devices, usergroups manage the access rights. The webserver needs an active Spotify account.<br>
A device (Laptop, PC, iPad) starts the web app and logs into it's MusiQ account. This account acts as the master. Other users also start the app and log-in into their MusiQ accounts. The master account is able to create and modify playlists via the Spotify Web API. The playlist itself stays with Spotify. The master device is the only device which is connected with the audio device (eg. UE BOOM).<br>
A client-usergroup is assigned to a master-account and connects to the webserver. The client-usergroup is able to search for music titles and add them to a playlist ("Queue").<br>
The master account always has the full control over the playlist(s) ("Queues") and is able to add, remove and modify active clients and music titles.<br>
A nice to have feature is a poll functionality to allow the clients to vote for certain music titles, genres, singers.

### Update, 10.05.2017
New idea: User does not need an MusiQ account - it's enough to know the unique public ID of the playlist to add a song ("login screen": Name and ID)

### Future
The bigger idea behind this is to be able to use a MusiQ account for several streaming services (Youtube, Apple Music etc) - and not being bound to Spotify; or even stream your own local stored music to a master device, whereat an internet connection is not needed at all (master device itself acts then as a webserver).

### In scope for webeC
1.  Master & client UI
2.  Master: Ability to create playlists, stored on server
3.  Master/client: Ability to search songs via Spotify Web API
4.  Master: Ability to play the playlist and let the clients actively adding titles
5.  Optional: Poll initiation

### Out of scope
1.  Group management
2.  Login mask

## Project confirmation

Confirmed, D.König.
Cool idea! 
It is a comparatively ambitious project.
Make sure you start with the simple parts such that you have something to show
even if the more difficult parts take longer than expected.

## Project delivery <to be filled by student>

How to start the project: (if other than `grailsw run-app`)

How to test the project:  [No tests written so far. Will add them later to my ongoing project.]

Project description:      index.html (CSS included)

External contributions:	  [Marked as EXTERNAL within the code. Occurence: 2x]

Other comments: 		  If possible, live demonstration is recommendable to show interaction with Spotify.

I'm particular proud of:  Complex O-AUTH 2.0 verification (https://developer.spotify.com/web-api/authorization-guide/)


## Project grading 

Index.html given and fully valid html.

The application works fine.

Functionality is a social music-sharing app with shared playlist and 
live streaming. While the typical web-applications features are included,
they almost fade in the presence of the spotify service that is nicely
injected into the Web MVC cycle.

Engingeering:
- full commit log (btw: who is "trentDoom"?) [My old username; changed it after I've noticed that I'm actually a grown man and should use an "age-appropriate" nickname :)]
- no tests
- very nice commenting

Many extra points are awarded for the technical challenge and the extra effort
that comes with integrating an external service and creating such a nice
application.

Congratulations!
While this application builds on the topics that we have covered in the module,
it obviously goes far beyond and demonstrates your ability to extend your
skills and knowledge by yourself and your proficiency in creating
real-life, professional-grade applications.

Grade: 6.0
