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
		def publicID = params.publicID
		//def playlistID = params.playlist
		def party = Party.findByPublicID(publicID)
		def user = spotifyService.getUser(party.token)
		
		//TODO: add song to db (mit transaktion, nur wenn es bei der spotify liste auch geklappt hat)
		
		def added = spotifyService.addSong(party.token, songID, party.playlistID, user.id)
		
		//TODO: commit or rollback (if successful)
		 
		def play = spotifyService.playPlaylist(party.token, user.id, party.playlistID)
		
		log.info(added.toString())
		log.info(play.toString())
		render added
		
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
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
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