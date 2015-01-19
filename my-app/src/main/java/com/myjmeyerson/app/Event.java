package com.myjmeyerson.app;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by jmeyerson on 01/01/15.
 */
public class Event implements Serializable{

    private long value;
    private long timestamp;

    public Event(long timestamp, Long value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getValue() {
        return value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Event{value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }

}
