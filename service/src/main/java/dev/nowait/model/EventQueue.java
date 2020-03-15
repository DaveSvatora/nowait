package dev.nowait.model;

import java.time.LocalTime;

public class EventQueue {
    // event_num bigint REFERENCES postgres.event,
    // serving_num bigint DEFAULT nextval('linesequence') PRIMARY KEY NOT NULL,
    // name text NOT NULL,
    // phone_num text NOT NULL,
    // start_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    // next_in_line timestamp DEFAULT '9999-12-31 01:01:01.000001' NOT NULL,
    // end_time timestamp DEFAULT '9999-12-31 01:01:01.000001' NOT NULL

    private int eventNum;
    private int servingNum;
    private String name;
    private String phoneNum;
    private LocalTime startTime;
    private LocalTime nextInLine;
    private LocalTime endTime;

    public EventQueue(int eventNum, int servingNum, String name, String phoneNum, LocalTime startTime, LocalTime nextInLine,
    LocalTime endTime) {
        this.eventNum = eventNum;
        this.servingNum = servingNum;
        this.name = name;
        this.phoneNum = phoneNum;
        this.startTime = startTime;
        this.nextInLine = nextInLine;
        this.endTime = endTime;
    }

    public EventQueue() {
    }

    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

    public int getServingNum() {
        return servingNum;
    }

    public void setServingNum(int servingNum) {
        this.servingNum = servingNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getNextInLine() {
        return nextInLine;
    }

    public void setNextInLine(LocalTime nextInLine) {
        this.nextInLine = nextInLine;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}