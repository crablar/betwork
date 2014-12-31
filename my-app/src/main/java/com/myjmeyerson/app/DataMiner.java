package com.myjmeyerson.app;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jeffreymeyerson on 12/30/14.
 */
public class DataMiner {

    private final static String outputPath = "output/";

    private long lastTimestamp;
    private File file;
    private PrintWriter printWriter;

    public DataMiner(String target, int interval) {

        String accessToken = "CAACEdEose0cBAKogIJqBb87DLAyn4ywvnTMxdOp4yZCZCzDuVYYVnKbI1nyy2ZArSJ8S2ffTC3psM7QCg6qVkfZAHH6Eur39ZAOfJGegICZCYVRQAS8sJTF2cmqt0Rh8t2RTEN18pEKZCsITgybjODJJSc2ZBDQzBWQ8qg4vev90LPY1zkBgPFdm4J4mAdW5vR3LBiT45rZCQXg7PcFEQFwWqhPeW4iC76jEZD";
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
        Page page = facebookClient.fetchObject(target, Page.class);

        file = new File(outputPath + target);
        try {
            file.createNewFile();
            printWriter = new PrintWriter(file);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        for(int i = 0; i < 10; i++) {
            printWriter.println("Page likes: " + page.getLikes());
            try{
                Thread.sleep(interval);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        printWriter.close();
    }
}
