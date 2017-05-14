package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class LoginController {

	def spotifyService

	def index(){}

	def callback() {
	
		def code = params.code
		def state = params.state
		
		def loginResult = spotifyService.login(code)
		
		Party party = new Party(token: loginResult.access_token, refreshToken: loginResult.refresh_token).save(failOnError:true)
		
		render (view: "/welcome/create", model: [party:party])
		
	}
	
	def play() {
		
	}

}