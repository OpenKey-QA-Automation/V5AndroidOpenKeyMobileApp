package com.openkey.reporting;

import com.openkey.screens.OpenKeyDoorLockScreen;
import com.openkey.setups.CapabilitiesManager;

import java.sql.*;
import java.util.Calendar;

public class DataBaseHandler extends CapabilitiesManager {

    static Connection conn;

    private static PreparedStatement pstmt;

    public static String DB_URL = "jdbc:mysql://localhost/openKey";
    public static String DB_USER = "root";

    public static String DB_PASSWORD = "gunjan@702";
    String dbClass = "com.mysql.cj.jdbc.Driver";

    public void setupConnection() throws ClassNotFoundException, SQLException, SQLException {

        Class.forName(dbClass);
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("Database Connection established successfully" + DB_URL);
        String query = "insert into openKey.locksStatistics (TotalRun,TotalPass,TotalFailed,timestamp) values (?,?,?,?)";
        System.out.println("Insert Query Executed " + OpenKeyDoorLockScreen.totalNumberOfLockOpeningAttempts);
        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1, OpenKeyDoorLockScreen.totalNumberOfLockOpeningAttempts);

        pstmt.setInt(2, OpenKeyDoorLockScreen.lockOpenSuccessCount);

        pstmt.setInt(3, OpenKeyDoorLockScreen.lockOpenFailureCount);

        pstmt.setTimestamp(4, new Timestamp(Calendar.getInstance().getTime().getTime()));

        pstmt.executeUpdate();
    }
}