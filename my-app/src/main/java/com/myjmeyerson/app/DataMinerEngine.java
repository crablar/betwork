package com.myjmeyerson.app;

import java.sql.SQLException;

/**
 * Created by jmeyerson on 01/01/15.
 */
public class DataMinerEngine {

    private DataMiner[] dataMiners;

    public DataMinerEngine(ChartSubject[] chartSubjects) throws Exception {
        dataMiners = new DataMiner[chartSubjects.length];
        for(int i = 0; i < chartSubjects.length; i++){
            dataMiners[i] = new DataMiner(chartSubjects[i]);
        }
    }

    public void updateChartSubjects() throws SQLException {
        for(DataMiner dataMiner : dataMiners){
            dataMiner.update();
        }
    }
}
