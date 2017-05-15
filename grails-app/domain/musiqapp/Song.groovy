package musiqapp

import grails.rest.Resource

class Song {
    String name
    String songID
    User user
    Date dateAdded

    static belongsTo = [ party: Party ]

    static constraints = {

    }
}
