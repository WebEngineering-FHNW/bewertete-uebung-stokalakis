package musiqapp

import grails.rest.Resource

class User {
    String name
    Date dateAdded

    static belongsTo = [ party: Party ]

    static constraints = {

    }
}
