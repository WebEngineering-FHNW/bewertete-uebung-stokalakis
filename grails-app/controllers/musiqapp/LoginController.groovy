package musiqapp
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import grails.plugins.rest.client.*

class LoginController {

	def index(){}

	def callback() {
	
		def code = params.code
		def state = params.state
		
		// EXTERNAL: http://stackoverflow.com/questions/21744236/grails-restbuilder-simple-post-example
		RestBuilder rest = new RestBuilder()
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
		form.add("grant_type", "authorization_code")
		form.add("code", code)
		form.add("redirect_uri", "http://localhost:8080/login/callback")
		// EXTERNAL END

        def resp = rest.post('https://accounts.spotify.com/api/token') {
            auth ('4a5ac7cf14e5401eb23430dc40164849', '5a54fd36fbfc4f33b2e6d1bdd2e74e27')
           	accept("application/json")
		    contentType("application/x-www-form-urlencoded")
		    body(form)

        }
        
        def token = resp.json.access_token
        
        def play = rest.put('https://api.spotify.com/v1/me/player/play?access_token=' + token) {
            contentType("application/json")
            json{ context_uri="spotify:user:sevi_l:playlist:69KzWRLGSV7foEEzDPYOGe" }
        }
        
        render token + "<br/> " + play.json
		
	}

}