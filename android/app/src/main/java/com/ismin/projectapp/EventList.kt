/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

class EventList {
    private val storage: ArrayList<Event> = ArrayList()

    fun addEvent(newEvent: Event) {
        if(this.getEventByID(newEvent.id) == null) { this.storage.add(newEvent) }
    }

    fun getEvent(title: String): Event? {
        return this.storage.find{it.title == title}
    }

    fun getEventByID(id: String): Event? {
        return this.storage.find { it.id === id }
    }

    fun getAllEventsSortedByTitle(): ArrayList<Event> {
        return ArrayList(this.storage.sortedBy { it.title })
    }

    fun getAllEventsSortedByDate(): ArrayList<Event> {
        return ArrayList(this.storage.sortedBy { it.date_start })
    }

    fun getTotalNumberOfEvents(): Int {
        return this.storage.size
    }

    fun removeEvent(event: Event) {
        this.storage.remove(event)
    }
}