package com.myjmeyerson.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A model to build charts out of. Reads a time series written by DataMiner.
 */

public class ChartSubject implements Serializable{

    public static enum ValueType {
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

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

}
