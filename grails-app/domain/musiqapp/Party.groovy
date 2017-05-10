package musiqapp

import grails.rest.Resource

class Party {
    String name
    String token
    String refreshToken
    static hasMany = [songs : Song]

    static constraints = {
        songs nullable: true
    }
}