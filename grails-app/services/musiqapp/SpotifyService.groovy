package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class SpotifyService {

	RestBuilder rest = new RestBuilder()

	def login(def code){
	
		
		// O-AUTH 2
		// (Part) EXTERNAL: http://stackoverflow.com/questions/21744236/grails-restbuilder-simple-post-example	
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
		form.add("grant_type", "authoriaztion_code")
		form.add("code", code)
		form.add("redirect_uri", "http://localhost:8080/login/callback")
		// EXTERNAL END

        def resp = rest.post('https://accounts.spotify.com/api/token') {
            auth ('4a5ac7cf14e5401eb23430dc40164849', '5a54fd36fbfc4f33b2e6d1bdd2e74e27')
           	accept("application/json")
		    contentType("application/x-www-form-urlencoded")
		    body(form)
        }
        
        return resp.json
	}

	def play(def token, def playlist) {
        
        def play = rest.put('https://api.spotify.com/v1/me/player/play?access_token=' + token) {
            contentType("application/json")
            json{ context_uri="spotify:user:sevi_l:playlist:" + playlist }
        }
        
        return play.status
		
	}
	
	def createPlaylist(def token, def playlistName, def user) {
        
        def playlist = rest.post('https://api.spotify.com/v1/users/' + user + '/playlists?access_token=' + token) {
            contentType("application/json")
            body("{name : '" + playlistName + "', public : false, context_uri : 'spotify:user:" + user + ":playlist:" + playlist + "'}")
        }
        
        return playlist.json
		
	}
	
	def addSong(def token, def trackID, def playlistID, def userID) { 
		def addSong = rest.post('https://api.spotify.com/v1/users/' + userID + '/playlists/' + playlistID + '/tracks?access_token=' + token) {
			contentType("application/json")
			json{
				 uris = ["spotify:track:" + trackID]
			}
		}
		
		return addSong.json
	
	}
	
	def getUser(def token) { 
		
		def user = rest.get('https://api.spotify.com/v1/me?access_token=' + token)
		return user.json
		
	}

}