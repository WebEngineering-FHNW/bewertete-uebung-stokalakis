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
		
        //"/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        
        "/description"(view:"/description/description")
    }
}
