package org.kevin.dao;

import org.kevin.dto.Novel;
import org.kevin.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * User Dao class
 * @author Kevin-Yichen Li
 */
public class UserDao {
    /**
     * login verification
     * @param con
     * @param user
     * @return
     * @throws Exception
     */
    public User login(Connection con, User user) throws Exception {
        User resultUser = null;
        String sql = "select * from t_user where userName=? and password=?";
        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(1, user.getUserName());
        statement.setString(2, user.getPassword());
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            resultUser = new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setStatus(rs.getString("status"));
        }
        return resultUser;
    }

    public int add(Connection con, User user) throws Exception {
        String sql = "insert into t_user values(null, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getStatus());
        return preparedStatement.executeUpdate();
    }

    public ResultSet list(Connection con, User user) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_user");
        if (user != null && user.getUserName() != null && !user.getUserName().isBlank()) {
            sb.append(" and userName like '%"+user.getUserName()+"%'");
        }
        if (user != null && user.getPassword() != null && !user.getPassword().isEmpty()) {
            sb.append(" and password like '%"+ user.getPassword()+"%'");
        }
        if (user != null && user.getStatus() != null && !user.getStatus().isEmpty()) {
            sb.append(" and status like '%"+ user.getStatus()+"%'");
        }

        PreparedStatement preparedStatement = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return preparedStatement.executeQuery();
    }
}
