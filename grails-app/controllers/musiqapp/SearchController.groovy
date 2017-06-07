package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class SearchController {

	def spotifyService

	def index(){
		def search = params.search
		log.info(search)
		def partyID = params.id
		def party
		if (partyID.startsWith("A")) {
			party = Party.findByAdminID(partyID)
		} else { 
			party = Party.findByPublicID(partyID)
		}
		
		// variables which are hardcoded at the moment. Spotify does not provide more then 50 results per query
		def type = "track"
		def limit = 50
		
		def searchSong
		
		// search service is only called if string is not empty
		try {
			if(search) {
				searchSong = spotifyService.searchSong(party.token, search, type, limit)
			}
		} catch (Exception e) {
			throw new Exception("Search is not working. Details: " + e)
   		}
		
		// render index view again
		render(view: "index", model: [searchSong: searchSong, party: party, id: partyID])
	}

}