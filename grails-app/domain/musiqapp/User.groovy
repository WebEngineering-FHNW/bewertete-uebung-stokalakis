package musiqapp

import grails.rest.Resource

class User {

	// Not in use at the moment; this functionality is on my TODO list
    String name
    Date dateAdded

    static belongsTo = [ party: Party ]

    static constraints = {

    }
}
