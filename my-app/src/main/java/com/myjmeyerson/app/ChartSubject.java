package com.myjmeyerson.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A model to build charts out of. Reads a time series written by DataMiner.
 */

public class ChartSubject {

    private String name;
    private String xAxisType;
    private String yAxisType;
    private String xValues;
    private String yValues;
    private Map<String, String> yToXAxisMap;

    public ChartSubject(String name) {
        this.name = name;
        this.yToXAxisMap = new LinkedHashMap<String, String>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("output/" + name));
            String line = br.readLine();
            String[] lineArr = line.split(" ");
            this.xAxisType = lineArr[0];
            this.yAxisType = lineArr[1];

            while((line = br.readLine()) != null){
                System.out.println("chartsubject" + line);
                lineArr = line.split(" ");
                yToXAxisMap.put(lineArr[0], lineArr[1]);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getXValues() {
        if(xValues == null){
            buildValueStrings();
        }
        return xValues;
    }

    public String getYValues() {
        if(xValues == null){
            buildValueStrings();
        }
        return yValues;
    }

    public void buildValueStrings(){
        StringBuilder xsb = new StringBuilder("");
        StringBuilder ysb = new StringBuilder("");
        for(Map.Entry<String, String> e : yToXAxisMap.entrySet()){
            xsb.append('\"').append(e.getKey()).append("\",");
            ysb.append(e.getValue()).append(',');
        }
        xValues = xsb.toString();
        yValues = ysb.toString();
    }

}
