# WebEngineering Module, Graded Exercise

## Commit Proposal

Matrikel Number: 10-272-888

Project idea short description: The MusiQueue App
[This idea came up to my mind several months ago - I've adapted the scope to meet the webeC project requirements (instead of a smartphone app, I will develop a web app).]

### Problem
Partying with friends. All the boys want to connect to the UE BOOM to play their cool music. Switching beetwen different devices to connect to the UE BOOM is painful and time-consuming.

### Solution
I want to program a web app which allows me, sending music titles into a queue. A master device (laptop, pc, ipad) starts the web app and logs into it's MusiQueue account. Other users also start the app and log-in into their MusiQueue accounts.
The account which acts as the master, needs an active Spotify account. The master is able to create and modify playlists via the Spotify Web API. The playlist itself stays with Spotify. The master device is the only device which is connected with the audio device (eg. UE BOOM).
The clients are allowed to connect to the master account and are able to search for music titles and add them to playlist ("Queue").
The master always has the full control over the playlist(s) ("Queues") and is able to add, remove and modify active clients and music titles. A nice to have feature is a poll functionality to allow the clients to vote for certain music titles, genres, singers.

### Future
The bigger idea behind this is to be able to use a MusiQueue account for several streaming services (youtube, apple music etc) - and not being bound to Spotify.

### In scope for webeC
1.  Master & client UI
2.  Master/client: Ability to search songs via Spotify Web API on master
3.  Master/client: Ability to create playlists, stored on server via master
4.  Master: Ability to play the playlist and let the clients actively adding titles
5.  Optional: Poll initiation

### Out of scope
1.  Group management
2.  Login mask

## Project confirmation

< to be filled by lecturer >


## Project delivery <to be filled by student>

How to start the project: (if other than `grailsw run-app`)

How to test the project:  (if other than `grailsw test-app`)

Project description:      (if other than `/index.html`)

External contributions:

Other comments: 

I'm particular proud of:


## Project grading 

< to be filled by lecturer>