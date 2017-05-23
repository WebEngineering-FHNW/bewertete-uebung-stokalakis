package musiqapp

import grails.rest.Resource

class Song {

	// Song domain to add songs from the playlist which is related to Party
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
