package musiqapp

import grails.rest.Resource

class Party {
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
    
    static mapping = {
    	songs sort: 'dateAdded', order: 'asc'
	}
}