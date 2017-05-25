package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*
import groovy.json.JsonBuilder

class SpotifyService {

	RestBuilder rest = new RestBuilder()

	def login(def code, def clientId, def clientSecret){
		
		// O-AUTH 2.0 https://developer.spotify.com/web-api/authorization-guide/
		// (Part) EXTERNAL: http://stackoverflow.com/questions/21744236/grails-restbuilder-simple-post-example	
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
		form.add("grant_type", "authorization_code")
		form.add("code", code)
		form.add("redirect_uri", "http://localhost:8080/login/callback")
		// EXTERNAL END

        def login = rest.post('https://accounts.spotify.com/api/token') {
            auth (clientId, clientSecret)
           	accept("application/json")
		    contentType("application/x-www-form-urlencoded")
		    body(form)
        }
        if(login.status >= 400){ 
        	throw new Exception("Service call failed with error " + login.status)
        }
        
        return login.json
	}
	
	// ### Defining playlist services based on https://developer.spotify.com/web-api/endpoint-reference/ // token needed ###
	
	// play the playlist
	def playPlaylist(def token, def userID, def playlistID) {
		// get devices
		def devices = rest.get('https://api.spotify.com/v1/me/player/devices?access_token=' + token) {
			contentType("application/json")
		}
		if(devices.status >= 400){ 
        	throw new Exception("Service call failed with error " + devices.status)
        }
		// get first device
		if(devices.status == 200 && devices.json.devices.length() > 0){
			def deviceId = devices.json.devices.id[0]
			
			//transfer the playback to the correct device
			def transfer = rest.put('https://api.spotify.com/v1/me/player?access_token=' + token) {
				contentType("application/json")
				json {device_ids = [deviceId]
					play = 'false'
				}
			}
			if(transfer.status >= 400){ 
        		throw new Exception("Service call failed with error " + transfer.status)
        	}
			
		}
		// give the api some time to make the switch
		sleep(500)
		
		def noShuffle = rest.put('https://api.spotify.com/v1/me/player/shuffle?state=false&access_token=' + token)
		
		if(noShuffle.status >= 400){ 
        	throw new Exception("Service call failed with error " + noShuffle.status)
        }
		
		def playPlaylistContent = [context_uri : "spotify:user:" + userID + ":playlist:" + playlistID, "offset": ["position": 0]]
		def playPlaylist = rest.put('https://api.spotify.com/v1/me/player/play?access_token=' + token) {
            contentType("application/json")
            json{ playPlaylistContent }
        }
		if(playPlaylist.status >= 400){ 
        		throw new Exception("Service call failed with error " + playPlaylist.status)
        }
		log.info ("play " + playPlaylist.status+"")
        return playPlaylist.json
		
	}
	
	// deleting a playlist
	def deletePlaylist(def token, def userID, def playlistID) { 
		// See FAQ in https://developer.spotify.com/web-api/remove-tracks-playlist/ : Deletion not possible, but unfollowing
		def delete = rest.delete('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/followers?access_token=' + token)
		if(delete.status >= 400){ 
        	throw new Exception("Service call failed with error " + delete.status)
        }
		return delete.status
	}
	
	// get a users playlist
	def getUserPlaylists(def token, def userID) {
		def getUserPlaylists = rest.get('https://api.spotify.com/v1/users/' + userID + '/playlists?access_token=' + token)
		if(getUserPlaylists.status >= 400){ 
        	throw new Exception("Service call failed with error " + getUserPlaylists.status)
        }
		return getUserPlaylists.json
	}
	
	// get the songs from a playlist
	def getPlaylistSongs(def token, def userID, def playlistID) {
		def getPlaylistSongs = rest.get('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/tracks?access_token=' + token)
		if(getPlaylistSongs.status >= 400){ 
        	throw new Exception("Service call failed with error " + getPlaylistSongs.status)
        }
		return getPlaylistSongs.json
	}

	// create a playlist
	def createPlaylist(def token, def playlistName, def user) {
        def playlist = rest.post('https://api.spotify.com/v1/users/' + user + '/playlists?access_token=' + token) {
            contentType("application/json")
            body("{\"name\" : \"" + playlistName + "\", \"public\" : false}")
        }
        if(playlist.status >= 400){ 
        	throw new Exception("Service call failed with error " + playlist.status)
        }
        return playlist.json
		
	}
	
	// ### Defining song (track) services based on https://developer.spotify.com/web-api/endpoint-reference/ // token needed ###
	
	// add a song to a playlist
	def addSong(def token, def trackID, def playlistID, def userID) { 
		
		def songs = getPlaylistSongs(token, userID, playlistID);
		def playlistSize = songs.items.length()
		
		def obj = [uris: ["spotify:track:" + trackID], position : playlistSize]
		def addSong = rest.post('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/tracks?access_token=' + token) {
			contentType("application/json")
			json{
				 obj
			}
		}
		if(addSong.status >= 400){ 
        	throw new Exception("Service call failed with error " + addSong.status)
        }
		return addSong.json
	}
	
	// delete a song from a playlist
	def deleteSong(def token, def userID, def playlistID, def trackID) {
		def deleteSong = rest.delete('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/tracks?access_token=' + token) { 
			contentType("application/json")
			json {
				tracks = [{ uri = "spotify:track:" + trackID }]
			}
		}
		if(deleteSong.status >= 400){ 
        	throw new Exception("Service call failed with error " + deleteSong.status)
        }
		return deleteSong.json
	}
	
	// skip to the next song
	def nextSong(def token) {
		def nextSong = rest.post('https://api.spotify.com/v1/me/player/next?access_token=' + token) { 
			contentType("application/json")
		}
		if(nextSong.status >= 400){ 
        	throw new Exception("Service call failed with error " + nextSong.status)
        }
		return nextSong.status
		
	}
	
	// skip to previous song
	def previousSong(def token) {
		def previousSong = rest.post('https://api.spotify.com/v1/me/player/previous?access_token=' + token) {
			contentType("application/json")
		}
		if(previousSong.status >= 400){ 
        	throw new Exception("Service call failed with error " + previousSong.status)
        }
		return previousSong.status
	}
	
	// pause the playlist
	def pauseSong(def token) {
		def pauseSong = rest.put('https://api.spotify.com/v1/me/player/pause?access_token=' + token) { 
			contentType("application/json")
		}
		if(pauseSong.status >= 400){ 
        	throw new Exception("Service call failed with error " + pauseSong.status)
        }
		return pauseSong.status
	}
	
	// get a songs information
	def getSong(def token, def trackID) { 
		def getSong = rest.get('https://api.spotify.com/v1/tracks/' + trackID + '?access_token=' + token)
		if(getSong.status >= 400){ 
        	throw new Exception("Service call failed with error " + getSong.status)
        }
		return getSong.json
	}
	
	// ### Defining User services ###
	
	// get a user
	def getUser(def token) {
		def user = rest.get('https://api.spotify.com/v1/me?access_token=' + token)
		if(user.status >= 400){ 
        	throw new Exception("Service call failed with error " + user.status)
        }
		return user.json
		
	}
	
	// ### Defining search services ###
	
	// search the spotify library with the provided query, type and limit
	def searchSong(def query, def type, def limit) {
		
		def searchSong = rest.get('https://api.spotify.com/v1/search?q=' + query + '&type=' + type + '&limit=' + limit)
		if(searchSong.status >= 400){ 
        	throw new Exception("Service call failed with error " + searchSong.status)
        }
		return searchSong.json
		
	}

}