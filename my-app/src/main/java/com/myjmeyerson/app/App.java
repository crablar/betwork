package com.myjmeyerson.app;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.User;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        String[] fbPageNames = {"JustinBieber", "cocacola"};
        DataMiner[] dataMiners = new DataMiner[fbPageNames.length];
        ChartWriter[] chartWriters = new ChartWriter[fbPageNames.length];
        for(int i = 0; i < fbPageNames.length; i++){
            dataMiners[i] = new DataMiner(fbPageNames[i], 1000, "time", "likes");
            chartWriters[i] = new ChartWriter(fbPageNames[i]);
        }

    }
}
