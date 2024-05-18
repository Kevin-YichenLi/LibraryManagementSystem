package org.kevin.dao;

import org.kevin.dto.Novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OperationDao {
    public int borrow(Connection con, String userName, int id, String title) throws Exception {
        String sql = "insert into t_book_operation values(null, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, id);
        preparedStatement.setString(3, title);
        preparedStatement.setString(4, "waiting");
        return preparedStatement.executeUpdate();
    }

    public ResultSet list(Connection con) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_book_operation");
        PreparedStatement preparedStatement = con.prepareStatement(sb.toString());
        return preparedStatement.executeQuery();
    }
}
