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
		
		def type = "track"
		def limit = 50
		def searchSong
		
		if(search) {
			searchSong = spotifyService.searchSong(search, type, limit)
		}

		render(view: "index", model: [searchSong: searchSong, party: party, id: partyID])
	}

}