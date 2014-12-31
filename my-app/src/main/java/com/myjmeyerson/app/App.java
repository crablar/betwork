package com.myjmeyerson.app;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] fbPageNames = {"JustinBieber", "cocacola"};
        DataMiner[] dataMiners = new DataMiner[fbPageNames.length];
        for(int i = 0; i < fbPageNames.length; i++){
            dataMiners[i] = new DataMiner(fbPageNames[i], 1000);
        }
    }
}
