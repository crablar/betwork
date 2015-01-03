package com.myjmeyerson.app;

/**
 * Created by jmeyerson on 01/01/15.
 */
public class ChartWriterEngine {

    private ChartWriter[] chartWriters;
    private MySQLAccess mySQLAccess;

    public ChartWriterEngine(ChartSubject[] chartSubjects) throws Exception {
        mySQLAccess = new MySQLAccess();
        chartWriters = new ChartWriter[chartSubjects.length];
        for(int i = 0; i < chartSubjects.length; i++){
            chartWriters[i] = new ChartWriter(chartSubjects[i]);
        }
    }

}