package com.myjmeyerson.app;

import static com.myjmeyerson.app.ChartSubject.ValueType.*;

public class App 
{
    public static void main( String[] args ) throws Exception {

        ChartSubject[] chartSubjects = initializeChartSubjects();

        DataMinerEngine dataMinerEngine = new DataMinerEngine(chartSubjects);
        dataMinerEngine.updateChartSubjects();
        ChartEngine chartEngine = new ChartEngine(chartSubjects);

    }

    private static ChartSubject[] initializeChartSubjects() {
        return new ChartSubject[]{
            new ChartSubject("JustinBieber", FB_LIKES),
            new ChartSubject("cocacola", FB_LIKES),
            new ChartSubject("rihanna", FB_LIKES),
            new ChartSubject("istanbul", FB_LIKES),
            new ChartSubject("hearthstone", FB_LIKES)
        };
    }
}
