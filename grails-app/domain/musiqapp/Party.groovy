package musiqapp

import grails.rest.Resource

class Party {
    String name
    String spotifyID
    static hasMany = [songs : Song]

    static constraints = {
        name nullable: true
        spotifyID nullable: true
        songs nullable: true
    }
}