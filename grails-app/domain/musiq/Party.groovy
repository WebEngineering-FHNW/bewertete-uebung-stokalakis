package musiq

import grails.rest.Resource

class Party {
    String name
    String spotifyID
    static hasMany = [songs : Song]

    static constraints = {
        
    }
}
