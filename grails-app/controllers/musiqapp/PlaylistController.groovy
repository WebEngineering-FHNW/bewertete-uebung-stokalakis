package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class PlaylistController {

	def spotifyService

	def index(){}
	
	// add Song to a playlist method
	def addSong() {
		def songID = params.song
		def partyID = params.id
		// determine if you're an admin
		def admin = partyID.startsWith("A")
		def party
		if(admin) { 
			party = Party.findByAdminID(partyID)
		} else { 
			party = Party.findByPublicID(partyID)
		}
		
		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
   		
   		def song
   		try {
			song = spotifyService.getSong(party.token, songID)
		} catch (Exception e) {
			throw new Exception("Could not get song. Details: " + e)
   		}
		
		// add song to db (with transaction --> both ways (db & spotify) have to be successful, otherwise both fail --> this ensures that you're in sync)
		def added
		try {
			Song.withTransaction { status ->
			new Song(image: song.album.images[2].url, album: song.album.name, name: song.name, artist: song.artists[0].name, songID : songID, dateAdded: new Date(), party: party).save(failOnError:true)
			added = spotifyService.addSong(party.token, songID, party.playlistID, user.id)
			log.info(added.toString())
			}
		} catch (Exception e) {
			throw new Exception("Could not add song to database or Spotify playlist. Details: " + e)
   		}
		
		log.info(added.toString())

		redirect (action: "show", id: partyID)
		
	}
		
	// shows the playlist to the admin or user
	def show() {
		def partyID = params.id
		def admin = partyID.startsWith("A")
		def party
		if(admin) { 
			party = Party.findByAdminID(partyID)
		} else { 
			party = Party.findByPublicID(partyID)
		}

		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
			
		render(view: "playlist", model: [admin: admin, party: party, user: user])
	}
	
	// create playlist method
	def create() {
		def name = params.namePlaylist
		def adminID = params.adminID
		def party = Party.findByAdminID(adminID)
		party.name = name
		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
		
		// we add "mq_" before each playlist to know, which playlist has been created by the app in the Spotify account
		def playlistID
		try {
			playlistID = spotifyService.createPlaylist(party.token, "mq_" + party.name, user.id).id
			party.playlistID = playlistID
			party.save(flush: true, failOnError: true)
		} catch (Exception e) {
			throw new Exception("Could not create playlist. Details: " + e)
   		}

		log.info ("created");
		redirect (action: "show", id: adminID)
		
	}
	
	// join a party method
	def join() {
		def partyID = params.partyID
		log.info partyID
		def admin = partyID.startsWith("A")
		def party
		if(admin) { 
			party = Party.findByAdminID(partyID)
		} else { 
			party = Party.findByPublicID(partyID)
		}
		
		// validate party ID input (label appears if party ID is unknown)
		if(party == null){
			render(view: "/welcome/index", model: [error: "Party ID does not exist. Please retry."])
			return
		}
		redirect (action: "show", id: partyID)
	}
	
	// play a playlist method
	def play() { 
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
		
		try {
			spotifyService.playPlaylist(party.token, user.id, party.playlistID)
		} catch (Exception e) {
			throw new Exception("Could not play playlisst. Details: " + e)
   		}
		redirect (action: "show", id: adminID)
	}
	
	// pause (stop) a playlist method (stop, because you start over when you click on play again)
	def pause() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
   		
   		try {
			spotifyService.pauseSong(party.token)
		} catch (Exception e) {
			throw new Exception("Could not pause playlist. Details: " + e)
   		}
		redirect (action: "show", id: adminID)
	}
	
	// next song method
	// BUG (https://github.com/spotify/web-api/issues/537): If you add a new song and press next, the new song it not recognised by the application. This is a bug from Spotify and cannot be solved at this time.
	def next() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
		
		try {
			spotifyService.nextSong(party.token)
		} catch (Exception e) {
			throw new Exception("Could not play next song. Details: " + e)
   		}
		redirect (action: "show", id: adminID)
		
	}
	
	// previous song method
	def previous() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
		
		try {
			spotifyService.previousSong(party.token)
		} catch (Exception e) {
			throw new Exception("Could not play previous song. Details: " + e)
   		}
		redirect (action: "show", id: adminID)
		
	}
	
	// delete a song method
	def delete() {
		def adminID = params.id
		def party = Party.findByAdminID(adminID)
		def songID = params.songID
		def user
		try {
			user = spotifyService.getUser(party.token)
		} catch (Exception e) {
			throw new Exception("Could not get user. Details: " + e)
   		}
		
		// again with transaction to ensure being in sync
		def deleted
		try {
			Song.withTransaction { status ->
				def song = Song.findByPartyAndSongID(party, songID)
				song.delete()
				deleted = spotifyService.deleteSong(party.token, user.id, party.playlistID, songID)
			}
		} catch (Exception e) {
			throw new Exception("Could not delete song from database or Spotify playlist. Details: " + e)
   		}
   		
		log.info(deleted.toString())
		redirect (action: "show", id: adminID)
		
	}

}