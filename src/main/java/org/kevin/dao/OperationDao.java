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

    public int approved(Connection con, int operationId) throws Exception{
        String sql = "update t_book_operation set status=? where operation_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, "approved");
        preparedStatement.setInt(2, operationId);
        return preparedStatement.executeUpdate();
    }

    public int rejected(Connection con, int operationId) throws Exception{
        String sql = "update t_book_operation set status=? where operation_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, "rejected");
        preparedStatement.setInt(2, operationId);
        return preparedStatement.executeUpdate();
    }

    public int returned(Connection con, int operationId) throws Exception{
        String sql = "update t_book_operation set status=? where operation_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, "returned");
        preparedStatement.setInt(2, operationId);
        return preparedStatement.executeUpdate();
    }
}
