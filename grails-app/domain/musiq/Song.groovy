package musiq

import grails.rest.Resource

class Song {
    String name
    String spotifyID
    String user
    Party Party
    Date dateAdded

    static belongsTo = [ party: Party ]

    static constraints = {
        
    }
}
