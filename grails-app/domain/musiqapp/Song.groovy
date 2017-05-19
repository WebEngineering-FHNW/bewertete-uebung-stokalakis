package musiqapp

import grails.rest.Resource

class Song {
    String name
    String artist
    String songID
    User user
    Date dateAdded
    String image
    String album

    static belongsTo = [ party: Party ]

    static constraints = {
    	user nullable: true

    }

}
