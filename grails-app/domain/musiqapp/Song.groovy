package musiqapp

import grails.rest.Resource

class Song {
    String name
    String songID
    String user
    Date dateAdded

    static belongsTo = [ party: Party ]

    static constraints = {

    }
}
