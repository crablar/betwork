package com.myjmeyerson.app;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import static com.myjmeyerson.app.ChartSubject.*;

/**
 * DataMiner reads from an API and writes files.
 * TODO add APIs other than FB
 */
public class DataMiner {

    private final static String accessToken = "CAALlmZAQoBx8BAGdlgCwgTSThHLAKbxQUBQ3EDmastxIYQ9iQucnOLNq6caUd2AnqUZBMaZCr7eH4ZBh9nDI81jZCgX9NgnDhUr0zLgYnt3c77dMTY7WOnjrZBZBMscnhLiKKmKMoDgLtDzDFSJSZAQqw1RSvwQg962qGXNUmKHe0qcI9rW6QPZBPZCjEmzKz5VVypDld29cYq4lCx6PSD2Xxp";

    private String subjectName;
    private ValueType valueType;
    private MySQLAccess mySQLAccess;
    private FacebookClient facebookClient;

    public DataMiner(ChartSubject chartSubject) throws Exception {
        mySQLAccess = new MySQLAccess();
        subjectName = chartSubject.getSubjectName();
        valueType = chartSubject.getValueType();
        facebookClient = new DefaultFacebookClient(accessToken);
    }

    public void update() throws SQLException {
        Page page = facebookClient.fetchObject(subjectName, Page.class);
        Event event = new Event(subjectName, System.currentTimeMillis(), page.getLikes(), valueType);
        mySQLAccess.writeEvent(event);
    }
}