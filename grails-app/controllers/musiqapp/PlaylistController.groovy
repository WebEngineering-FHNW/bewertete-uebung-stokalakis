package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class PlaylistController {

	def spotifyService

	def index(){}

	def play() {
	}	

	def stop() {
	}
		
	def addSong() {
	
		def songID = params.song
		def partyID = params.long('party')
		def playlistID = params.playlist
		def party = Party.get(partyID)
		def userID = spotifyService.getUser(party.token)
		
		def added = spotifyService.addSong(party.token, songID, playlistID, userID.id) 
		
		render added
		
		// http://localhost:8080/playlist/add?song=0It6VJoMAare1zdV2wxqZq&party=1&playlist=3Oc39nCFp0ZCR2IjGKaBii
	}
	
	//shows the playlist to the user
	def user() {
		def publicID = params.id
		def party = Party.findByPublicID(publicID)
		def user = spotifyService.getUser(party.token)
		//TODO: move into add song handler
		spotifyService.playPlaylist(party.token, user.id, '3ftHe2N8T3TGyukzmaa5K7')
		
		render params.id
	}
	
	//shows the playlist to the admin
	def admin() {
		def publicID = params.id
		def party = Party.findByAdminID(publicID)
		def user = spotifyService.getUser(party.token)
		//TODO: move into add song handler
		spotifyService.playPlaylist(party.token, user.id, '3ftHe2N8T3TGyukzmaa5K7')
		
		render params.id
	}
	
	def create() {
		def name = params.namePlaylist
		def adminID = params.adminID
		def party = Party.findByAdminID(adminID)
		party.name = name
		
		def user = spotifyService.getUser(party.token)
		
		def playlistID = spotifyService.createPlaylist(party.token, "mq_"+party.name, user.id).id

		party.playlistID = playlistID

		party.save(flush: true, failOnError: true)
		
		redirect (action: "admin", params: [id: adminID])
		
	}

}