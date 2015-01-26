package com.myjmeyerson.app;

import java.util.Date;

import static com.myjmeyerson.app.ChartSubject.ValueType.*;

public class App 
{
    public static void main( String[] args ) throws Exception {

        long nextTick = System.currentTimeMillis();

        while(true) {
            if (System.currentTimeMillis() > nextTick) {
                ChartSubject[] chartSubjects = initializeChartSubjects();
                DataMinerEngine dataMinerEngine = new DataMinerEngine(chartSubjects);
                dataMinerEngine.updateChartSubjects();
                ChartEngine.writeCharts(chartSubjects);
                AWSUploader.upload();
                nextTick += (1000 * 60 * 60);
                System.out.println(new Date() + ": uploading chart");
            }
        }

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
