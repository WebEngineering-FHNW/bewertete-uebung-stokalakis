package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class PlaylistController {

	def spotifyService

	def index(){}
	
	def addSong() {
		def songID = params.song
		def partyID = params.id
		def admin = partyID.startsWith("A")
		def party
		if(admin) { 
			party = Party.findByAdminID(partyID)
		} else { 
			party = Party.findByPublicID(partyID)
		}
		
		def user = spotifyService.getUser(party.token)
		def song = spotifyService.getSong(party.token, songID)
		
		//add song to db (with transaction --> both ways (db & spotify) have to be successful)
		def added
		Song.withTransaction { status ->
			new Song(image: song.album.images[2].url, album: song.album.name, name: song.name, artist: song.artists[0].name, songID : songID, dateAdded: new Date(), party: party).save(failOnError:true)
			added = spotifyService.addSong(party.token, songID, party.playlistID, user.id)
			log.info(added.toString())
			
		}
		
		log.info(added.toString())

		redirect (action: "show", id: partyID)
		
	}
		
	//shows the playlist to the admin
	def show() {
		def partyID = params.id
		def admin = partyID.startsWith("A")
		def party
		if(admin) { 
			party = Party.findByAdminID(partyID)
		} else { 
			party = Party.findByPublicID(partyID)
		}

		def user = spotifyService.getUser(party.token)
			
		render(view: "playlist", model: [admin: admin, party: party, user: user])
	}
	
	def create() {
		def name = params.namePlaylist
		def adminID = params.adminID
		def party = Party.findByAdminID(adminID)
		party.name = name
		
		def user = spotifyService.getUser(party.token)
		
		def playlistID = spotifyService.createPlaylist(party.token, "mq_" + party.name, user.id).id

		party.playlistID = playlistID

		party.save(flush: true, failOnError: true)
		log.info ("created");
		redirect (action: "show", id: adminID)
		
	}
	
	def join() { 
		def partyID = params.partyID
		log.info partyID
		redirect (action: "show", id: partyID)
	}
	
	def play() { 
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user = spotifyService.getUser(party.token)
		
		spotifyService.playPlaylist(party.token, user.id, party.playlistID)
		
		redirect (action: "show", id: adminID)
	}
	
	def pause() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user = spotifyService.getUser(party.token)
		
		spotifyService.pauseSong(party.token)
		log.info ("pause")
		redirect (action: "show", id: adminID)
	}
	
	// TODO: If new song is added during play and you press 'next', the newly added song does not play (song is unknown for current session)
	def next() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user = spotifyService.getUser(party.token)
		
		spotifyService.nextSong(party.token)
		redirect (action: "show", id: adminID)
		
	}
	
	def previous() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user = spotifyService.getUser(party.token)
		
		spotifyService.previousSong(party.token)
		redirect (action: "show", id: adminID)
		
	}
	
	def delete() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user = spotifyService.getUser(party.token)
		def songID = params.songID
		
		def deleted
		Song.withTransaction { status ->
			def song = Song.findByPartyAndSongID(party, songID)
			song.delete()
			deleted = spotifyService.deleteSong(party.token, user.id, party.playlistID, songID)
		}
		
		log.info(deleted.toString())
		redirect (action: "show", id: adminID)
		
	}

}