package musiq

import grails.rest.Resource

class Song {
    String name
    String spotifyID
    String user
    Date dateAdded

    static belongsTo = [ party: Party ]

    static constraints = {
        name nullable: true
        spotifyID nullable: true
        user nullable: true
        party nullable: true
        
    }
}
