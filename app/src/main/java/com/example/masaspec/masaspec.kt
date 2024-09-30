package com.example.masaspec

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

// calcular la duración del evento
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    // ejemplos de eventos
    val event1 = Event("Breakfast Meeting", "Discussing project updates", Daypart.MORNING, 30)
    val event2 = Event("Lunch Break", "Team lunch at the café", Daypart.AFTERNOON, 60)
    val event3 = Event("Evening Yoga", "Relax and unwind", Daypart.EVENING, 45)
    val event4 = Event("Project Presentation", "Presenting to the board", Daypart.AFTERNOON, 90)
    val event5 = Event("Morning Run", "Jogging in the park", Daypart.MORNING, 30)
    val event6 = Event("Dinner with Friends", "Catch up over dinner", Daypart.EVENING, 120)

    val events = mutableListOf(event1, event2, event3, event4, event5, event6)

    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")

    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }

    println("Last event of the day: ${events.last().title}")

    // ejemplo de uso de la propiedad de duración
    events.forEach { event ->
        println("${event.title} is a ${event.durationOfEvent} event.")
    }
}