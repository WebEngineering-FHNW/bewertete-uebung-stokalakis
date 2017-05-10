package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class PlaylistController {

	def spotifyService

	def index(){}

	def add() {
	
		def songID = params.song
		def partyID = params.party
		def playlistID = params.playlist
		def party = Party.get(partyID)
		def userID = spotifyService.getUser(party.token)
		
		def added = spotifyService.addSong(party.token, songID, playlistID, userID.id) 
		
		render added
		
		// http://localhost:8080/playlist/add?song=0It6VJoMAare1zdV2wxqZq&party=1&playlist=3Oc39nCFp0ZCR2IjGKaBii
		
	}
	
	def play() {
		
	}

}