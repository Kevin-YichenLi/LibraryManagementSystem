package org.kevin.dao;

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
        }
        return resultUser;
    }
}
