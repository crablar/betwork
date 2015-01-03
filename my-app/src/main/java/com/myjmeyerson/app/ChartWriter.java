package com.myjmeyerson.app;

import java.io.*;
import java.util.Scanner;

/**
 * ChartWriter writes a ChartSubject into a chart.
 */
public class ChartWriter {

    private MySQLAccess mySQLAccess;

    public ChartWriter(ChartSubject chartSubject) throws IOException {
        for(Event event : mySQLAccess.getEvents(chartSubject.getSubjectName(), chartSubject.getValueType())){
            System.out.println(event);
        }
    }

}
