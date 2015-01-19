package com.myjmeyerson.app;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;

/**
 * Created by jmeyerson on 01/01/15.
 */
public class ChartEngine {

    private Chart[] charts;

    public ChartEngine(ChartSubject[] chartSubjects) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        charts = new Chart[chartSubjects.length];
        for(int i = 0; i < chartSubjects.length; i++){
            charts[i] = new Chart(chartSubjects[i]);
        }
        try{
            mapper.writeValue(new File("charts.json"), charts);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}