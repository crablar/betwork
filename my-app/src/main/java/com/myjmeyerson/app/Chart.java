package com.myjmeyerson.app;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Chart is a series of events.
 */
public class Chart implements Serializable {


    private ChartSubject chartSubject;
    private List<Event> events;

    public Chart(ChartSubject chartSubject) throws Exception {
        MySQLAccess mySQLAccess = new MySQLAccess();
        this.events = mySQLAccess.getEvents(chartSubject.getSubjectName(), chartSubject.getValueType());
        this.chartSubject = chartSubject;
    }
    public ChartSubject getChartSubject() {
        return chartSubject;
    }

    public void setChartSubject(ChartSubject chartSubject) {
        this.chartSubject = chartSubject;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> setEvents(List<Event> events) {
        return events;
    }

}
