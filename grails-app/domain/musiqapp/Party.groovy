package musiqapp

import grails.rest.Resource

class Party {
    String name
    String token
    String refreshToken
    static hasMany = [songs : Song, users : User]

    static constraints = {
        songs nullable: true
        name nullable: true
    }
}