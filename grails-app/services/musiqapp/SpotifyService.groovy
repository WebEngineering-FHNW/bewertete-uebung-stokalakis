package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*
import groovy.json.JsonBuilder

class SpotifyService {

	RestBuilder rest = new RestBuilder()

	def login(def code, def clientId, def clientSecret){
		
		// O-AUTH 2 https://developer.spotify.com/web-api/authorization-guide/
		// (Part) EXTERNAL: http://stackoverflow.com/questions/21744236/grails-restbuilder-simple-post-example	
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
		form.add("grant_type", "authorization_code")
		form.add("code", code)
		form.add("redirect_uri", "http://localhost:8080/login/callback")
		// EXTERNAL END

        def resp = rest.post('https://accounts.spotify.com/api/token') {
            auth (clientId, clientSecret)
           	accept("application/json")
		    contentType("application/x-www-form-urlencoded")
		    body(form)
        }
        
        return resp.json
	}
	
	// Defining playlist services based on https://developer.spotify.com/web-api/endpoint-reference/

	def playPlaylist(def token, def userID, def playlistID) {
		
        def playPlaylist = rest.put('https://api.spotify.com/v1/me/player/play?access_token=' + token) {
            contentType("application/json")
            json{ context_uri = "spotify:user:" + userID + ":playlist:" + playlistID }
        }
        
        return playPlaylist.json
		
	}
	
	def deletePlaylist(def token, def userID, def playlistID) { 
		// See FAQ in https://developer.spotify.com/web-api/remove-tracks-playlist/ : Deletion not possible, but unfollowing
		def delete = rest.delete('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/followers?access_token=' + token)
		return delete.status
	}
	
	def getUserPlaylists(def token, def userID) {
			def getUserPlaylists = rest.get('https://api.spotify.com/v1/users/' + userID + '/playlists?access_token=' + token)
			
			return getUserPlaylists.json
	}
	
	def getPlaylistSongs(def token, def userID, def playlistID) {
		def getPlaylistSongs = rest.get('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/tracks?access_token=' + token)
		
		return getPlaylistSongs.json
	}
	
	def createPlaylist(def token, def playlistName, def user) {
        def playlist = rest.post('https://api.spotify.com/v1/users/' + user + '/playlists?access_token=' + token) {
            contentType("application/json")
            body("{\"name\" : \"" + playlistName + "\", \"public\" : false}")
        }
        
        return playlist.json
		
	}
	
	// Defining song (track) services based on https://developer.spotify.com/web-api/endpoint-reference/
	
	def addSong(def token, def trackID, def playlistID, def userID) { 
		def addSong = rest.post('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/tracks?access_token=' + token) {
			contentType("application/json")
			json{
				 uris = ["spotify:track:" + trackID]
			}
		}
		
		return addSong.json
	
	}
	
	// ToDo: Not sure if working :)
	def deleteSong(def token, def userID, def playlistID, def trackID) {
		def deleteSong = rest.delete('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/tracks?access_token=' + token) { 
			contentType("application/json")
			json {
				tracks = [{ uri = "spotify:track:" + trackID }]
			}
		}
		
		return deleteSong.json
	}
	
	def nextSong(def token) {
		def nextSong = rest.post('https://api.spotify.com/v1/me/player/next?access_token=' + token) { 
			contentType("application/json")
		}
		
		return nextSong.status
		
	}
	
	def previousSong(def token) {
		def previousSong = rest.post('https://api.spotify.com/v1/me/player/previous?access_token=' + token) {
			contentType("application/json")
		}
		
		return previousSong.status
	}
	
	def pauseSong(def token) {
		def pauseSong = rest.post('https://api.spotify.com/v1/me/player/pause?access_token=' + token) { 
			contentType("application/json")
		}
		
		return pauseSong.status
	}
	
	// Defining User services
	
	def getUser(def token) {
		def user = rest.get('https://api.spotify.com/v1/me?access_token=' + token)
		
		return user.json
		
	}
	
	// Defining search services
	
	def searchSong(def query, def type, def limit) {
		
		def searchSong = rest.get('https://api.spotify.com/v1/search?q=' + query + '&type=' + type + '&limit=' + limit)
		
		return searchSong.json
		
	}

}