package musiqapp

import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class LoginController {

	def spotifyService
	def randomGenerator = RandomGenerator.newInstance()
	
	def callback() {
		
		def code = params.code
		def state = params.state
		
		// generate the ids for the party
		def publicID = "P" + randomGenerator.randomString(8)
		def adminID = "A" + randomGenerator.randomString(8)
		if(params.state != session.id){
			throw new Exception("Session IDs do not match.")
		}
		
		def loginResult
		try {
      		loginResult = spotifyService.login(code,
			grailsApplication.config.getProperty('app.spotify.client_id'),
			grailsApplication.config.getProperty('app.spotify.client_secret'))
   		} catch (Exception e) {
			throw new Exception("Could not login to Spotify. Details: " + e)
   		}
		
		// creates new Party object with the token
		Party party = new Party(token: loginResult.access_token, 
			refreshToken: loginResult.refresh_token,
			adminID: adminID, publicID: publicID).save(failOnError:true)
		
		// render the create view after successful login
		render (view: "/login/create", model: [party: party])
		
	}

}