package com.jmeyerson;

/**
 * A model to build charts out of. Reads a time series written by DataMiner.
 */

public class ChartSubject {

    public enum ValueType {
        FB_LIKES, TWTR_RETWEETS
    }

    private String subjectName;
    private ValueType valueType;

    public ChartSubject(String name, ValueType ValueType) {
        this.subjectName = name;
        this.valueType = ValueType;
    }

    public String getSubjectName(){
        return subjectName;
    }

    public ValueType getValueType() {
        return valueType;
    }
}
