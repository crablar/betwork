package com.myjmeyerson.app;

import java.io.*;
import java.util.Scanner;

/**
 * Created by jeffreymeyerson on 12/31/14.
 */
public class ChartWriter {

    private static final String sourcePath = "output/";
    private static final String destinationPath = "../rails_app/app/assets/javascripts/samplechart.js";

    public ChartWriter(String subject) throws FileNotFoundException {

        BufferedReader reader = null;
        BufferedWriter writer = null;
        String tempFileName = destinationPath.replace("samplechart.js", "samplechart_tmp.js");

        File f = new File(destinationPath);
        File f2 = new File(tempFileName);
        System.out.println(f.canRead());
        System.out.println(f2.canRead());

        try {
            reader = new BufferedReader(new FileReader(destinationPath));
            writer = new BufferedWriter(new FileWriter(tempFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<Y-AXIS VALUES>")) {
                    line = line.replace("<Y-AXIS VALUES>", "fub");
                }
                writer.write(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        File oldFile = new File(destinationPath);
        oldFile.delete();

        File newFile = new File(tempFileName);
        newFile.renameTo(oldFile);

    }

}
