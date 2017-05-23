package musiqapp

import grails.rest.Resource

class Party {

	// Domain to create party table, which is related to Songs and Users
    String name
    String token
    String refreshToken
	String adminID
	String publicID
	String playlistID
	
    static hasMany = [songs : Song, users : User]

    static constraints = {
        songs nullable: true
        name nullable: true
		playlistID nullable: true
		publicID unique: true
		adminID unique: true
    }
    
    // Ordering is made via database to ensure the correct list order in the UI
    static mapping = {
    	songs sort: 'dateAdded', order: 'asc'
	}
}