package fr.cs.sdbm_jee.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class SDBMConnect2 {
    // Declare the JDBC objects.
    private static Connection connexion;

    private SDBMConnect2() {

    }

    public static Connection getInstance() {
        if (connexion == null) {
            try {
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setServerName("127.0.0.1");
                ds.setPortNumber(1401);
                ds.setDatabaseName("SDBM");
                ds.setIntegratedSecurity(false);
                ds.setEncrypt(false);
                ds.setUser("sa");
                ds.setPassword("azerty@123456");
                connexion = ds.getConnection();
            }

            // Handle any errors that may have occurred.
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connexion;
    }
}