package com.myjmeyerson.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmeyerson on 01/01/15.
 */
public class MySQLAccess {
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MySQLAccess () throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/betwork?" +
                    "user=user&password=password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getSubjects() throws SQLException {
        preparedStatement = connect.prepareStatement("select * from betwork.SUBJECTS");
        resultSet = preparedStatement.executeQuery();
        List<String> subjects = new ArrayList<String>();
        while(resultSet.next()){
            subjects.add(resultSet.getString("SUBJECT"));
        }
        return subjects;
    }

    public List<String> getvalueTypes(String subject) throws SQLException {
        preparedStatement = connect.prepareStatement("select SUBJECT_TYPE from betwork.SUBJECT_TO_VALUE_TYPE "
                + "where SUBJECT_NAME=?");
        preparedStatement.setString(1, subject);
        resultSet = preparedStatement.executeQuery();
        List<String> valueTypes = new ArrayList<String>();
        while(resultSet.next()){
            valueTypes.add(resultSet.getString("VALUE_TYPE"));
        }
        return valueTypes;
    }

    public List<Event> getEvents(String subject, String valueType) throws SQLException {
        preparedStatement = connect.prepareStatement("select * from betwork.EVENTS where " +
                "SUBJECT_NAME=? and VALUE_TYPE=?");
        preparedStatement.setString(1, subject);
        preparedStatement.setString(2, valueType);
        resultSet = preparedStatement.executeQuery();
        List<Event> events = new ArrayList<Event>();
        while(resultSet.next()){
            String subjectName = resultSet.getString("SUBJECT_NAME");
            Date timestamp = resultSet.getDate("TIMESTAMP");
            int value = resultSet.getInt("VALUE");
            events.add(new Event(subjectName, timestamp, value));
        }
        return events;
    }

    public

}
