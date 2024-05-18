package org.kevin.util;

import org.kevin.dao.NovelDao;
import org.kevin.dto.Genre;
import org.kevin.dto.Novel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Connect to database
 *
 * @author Kevin-Yichen Li
 */
public class DBUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_library";
    private String dbUserName = "root";
    private String dbPassword = "123456";
    private String jdbcName = "com.mysql.jdbc.Driver";

    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    /**
     * close connection with database
     *
     * @param con
     * @throws Exception
     */
    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }
}