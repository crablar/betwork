package com.myjmeyerson.app;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * ChartWriter writes a ChartSubject into a chart.
 */
public class ChartWriter {

    private MySQLAccess mySQLAccess;

    public ChartWriter(ChartSubject chartSubject) throws Exception {
        mySQLAccess = new MySQLAccess();
        List<Event> events = mySQLAccess.getEvents(chartSubject.getSubjectName(), chartSubject.getValueType());
        for(Event event : events){
            System.out.println(event);
        }
    }

}
