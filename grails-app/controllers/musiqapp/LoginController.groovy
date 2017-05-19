package musiqapp

import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class LoginController {

	def spotifyService
	def randomGenerator = RandomGenerator.newInstance()
	
	def callback() {
		
		def code = params.code
		def state = params.state
		
		//generate the ids for the party
		def publicID = "P" + randomGenerator.randomString(8)
		def adminID = "A" + randomGenerator.randomString(8)
		
		if(params.state != session.id){
			throw new Exception("session ids do not match")
		}
		
		def loginResult = spotifyService.login(code,
			grailsApplication.config.getProperty('app.spotify.client_id'),
			grailsApplication.config.getProperty('app.spotify.client_secret'))
		
		Party party = new Party(token: loginResult.access_token, 
			refreshToken: loginResult.refresh_token,
			adminID: adminID, publicID: publicID).save(failOnError:true)
		
		render (view: "/login/create", model: [party: party])
		
	}

}