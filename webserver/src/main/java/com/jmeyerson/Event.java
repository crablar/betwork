package com.jmeyerson;

/**
 * Created by jmeyerson on 01/01/15.
 */
public class Event {
    private String subjectName;
    private ChartSubject.ValueType valueType;
    private long value;
    private long timestamp;

    public Event(String subjectName, long timestamp, Long value, ChartSubject.ValueType valueType) {
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

    public long getTimestamp() {
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
