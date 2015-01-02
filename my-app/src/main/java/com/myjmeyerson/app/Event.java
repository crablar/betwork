package com.myjmeyerson.app;

import java.util.Date;

/**
 * Created by jmeyerson on 01/01/15.
 */
public class Event {
    private String subjectName;
    private int value;
    private Date timestamp;

    public Event(String subjectName, Date timestamp, int value) {
        this.subjectName = subjectName;
        this.timestamp = timestamp;
        this.value = value;
    }

    public String getSubjectName(){
        return subjectName;
    }

    public int getValue() {
        return value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "subjectName='" + subjectName + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}
