package musiq

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.PRODUCTION) {
            return
        }

        Song song1 = new Song(name: "Song1", user: "Samuel", dateAdded: new Date()).save(failOnError:true)
        Song song2 = new Song(name: "Song2", user: "Severin", dateAdded: new Date()).save(failOnError:true)
        Song song3 = new Song(name: "Song3", user: "Assja", dateAdded: new Date()).save(failOnError:true)

        Party party1 = new Party(name: "Party1", songs: [song1, song2, song3]).save(failOnError:true)

    }

    def destroy = {
    }
}
