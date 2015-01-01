package com.myjmeyerson.app;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * DataMiner reads from an API and writes files.
 * TODO add APIs other than FB
 */
public class DataMiner {

    private final static String outputPath = "output/";

    private long lastTimestamp;
    private File file;
    private PrintWriter printWriter;

    public DataMiner(String subject, int interval, String xAxisType, String yAxisType) {

        String accessToken = "CAALlmZAQoBx8BAGdlgCwgTSThHLAKbxQUBQ3EDmastxIYQ9iQucnOLNq6caUd2AnqUZBMaZCr7eH4ZBh9nDI81jZCgX9NgnDhUr0zLgYnt3c77dMTY7WOnjrZBZBMscnhLiKKmKMoDgLtDzDFSJSZAQqw1RSvwQg962qGXNUmKHe0qcI9rW6QPZBPZCjEmzKz5VVypDld29cYq4lCx6PSD2Xxp";
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
        Page page = facebookClient.fetchObject(subject, Page.class);

        file = new File(outputPath + subject);
        Calendar calendar = Calendar.getInstance();

        try {
            file.createNewFile();
            printWriter = new PrintWriter(file);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        printWriter.println(xAxisType + " " + yAxisType);

        for(int i = 0; i < 10; i++) {

            calendar.setTimeInMillis(System.currentTimeMillis());
            int day = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            String now = day + "/" + hour + "/" + minute + "/" + second;

            printWriter.println(now + " " + page.getLikes());

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
