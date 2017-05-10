package musiq

class WelcomeController {

	def createParty() { 
	}

    /*def play() {
        def allRooms = Room.list()
        Date today = new Date().clearTime()
        String lastSlot = "15:15-18:00"
        def bookedRooms = Booking.findAllByDayAndTimeSlot(today, lastSlot).room
        render text: (allRooms - bookedRooms)
    }

    def search() {
        render view:"search", model:[people: Person.list()]
    }

    def openBookingsFor(Person person) {
        Date today = new Date().clearTime()
        List<Booking> bookings = Booking.findAllByBookerAndDayGreaterThanEquals(person, today)
        respond bookings, view:"openBookingsFor", model:[bookings: bookings]
    }

    def availableRoomsFor(String day, String timeSlot) {
        def allRooms = Room.list()
        def searchDay = Date.parse('yyyy-MM-dd', day)
        def bookedRooms = Booking.findAllByDayAndTimeSlot(searchDay, timeSlot).room
        render view:"availableRoomsFor", model: [rooms: (allRooms - bookedRooms)]
    }*/

}
