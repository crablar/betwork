package com.myjmeyerson.app;

import java.util.Date;
/**
 * Created by jmeyerson on 01/01/15.
 */
public class Event {
    private String subjectName;
    private ChartSubject.ValueType valueType;
    private long value;
    private Date timestamp;

    public Event(String subjectName, Date timestamp, Long value, ChartSubject.ValueType valueType) {
        this.subjectName = subjectName;
        this.timestamp = timestamp;
        this.value = value;
        this.valueType = valueType;
    }

    public String getSubjectName(){
        return subjectName;
    }

    public long getValue() {
        return value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public ChartSubject.ValueType getValueType(){
        return valueType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "subjectName='" + subjectName + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                ", valueType=" + valueType +
                '}';
    }

}
