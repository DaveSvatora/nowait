package dev.nowait.model;

import java.time.LocalDate;

public class Event {
    private int eventNum;
    private String eventName;
    private LocalDate eventDate;

    public Event(int eventNum, String eventName, LocalDate eventDate) {
        this.eventNum = eventNum;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public Event() {
    }

    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}