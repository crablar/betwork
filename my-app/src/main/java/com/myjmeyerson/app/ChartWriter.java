package com.myjmeyerson.app;

import java.io.*;
import java.util.Scanner;

/**
 * ChartWriter writes a ChartSubject into a chart.
 */
public class ChartWriter {

    private static final String sourcePath = "output/";
    private static final String destinationPath = "../rails_app/app/assets/javascripts/samplechart.js";

    public ChartWriter(String name) throws IOException {

        ChartSubject chartSubject = new ChartSubject(name);

        BufferedReader reader = null;
        BufferedWriter writer = null;
        String tempFileName = destinationPath.replace("samplechart.js", "samplechart_tmp.js");

        try {
            reader = new BufferedReader(new FileReader(destinationPath));
            writer = new BufferedWriter(new FileWriter(tempFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("categories:")) {
                    line = "\t\t\tcategories: [" + chartSubject.getXValues() + "],";
                }
                else if (line.contains("data:")) {
                    line = "\t\t\tdata: [" + chartSubject.getYValues() + "]";
                }
                writer.write(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        File oldFile = new File(destinationPath);
        oldFile.delete();
        writer.close();
        File newFile = new File(tempFileName);
        newFile.createNewFile();
        newFile.renameTo(oldFile);

    }

}
