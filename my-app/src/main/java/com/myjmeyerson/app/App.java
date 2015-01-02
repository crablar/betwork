package com.myjmeyerson.app;

import static com.myjmeyerson.app.ChartSubject.ValueType;

public class App 
{
    public static void main( String[] args ) throws Exception {

        ChartSubject[] chartSubjects = initializeChartSubjects();

        DataMinerEngine dataMinerEngine = new DataMinerEngine(chartSubjects);
        chartSubjects = dataMinerEngine.updateChartSubjects();
        ChartWriterEngine chartWriterEngine = new ChartWriterEngine(chartSubjects);
        chartWriterEngine.start();

    }

    private static ChartSubject[] initializeChartSubjects() {
        return new ChartSubject[]{
            new ChartSubject("JustinBieber", ValueType.FB_LIKES),
            new ChartSubject("cocacola", ValueType.FB_LIKES)
        };
    }
}
