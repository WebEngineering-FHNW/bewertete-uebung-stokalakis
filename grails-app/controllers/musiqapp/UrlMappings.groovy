package musiqapp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		// now redirecting directly to my app
		"/"(view:"/welcome/index")
		"500"(view: 'customError')
        "404"(view:'/notFound')
        
        "/description"(view:"/description/description")
    }
}
