package com.myjmeyerson.app;

/**
 * Created by jmeyerson on 01/01/15.
 */
public class DataMinerEngine {

    private DataMiner[] dataMiners;

    public DataMinerEngine(ChartSubject[] chartSubjects){
        dataMiners = new DataMiner[chartSubjects.length];
        for(int i = 0; i < chartSubjects.length; i++){
            dataMiners[i] = new DataMiner(chartSubjects[i]);
        }
    }

    public void updateChartSubjects() {
        for(dataMiner : dataMiners){
            dataMiner.update();
        }
    }
}
