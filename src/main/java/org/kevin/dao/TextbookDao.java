package org.kevin.dao;

import org.kevin.dto.Novel;
import org.kevin.dto.Textbook;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Textbook Dao class
 * @author Kevin-Yichen Li
 */
public class TextbookDao {
    public int add(Connection con, Textbook textbook) throws Exception {
        String sql = "insert into t_textbook values(null, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, textbook.getAuthor());
        preparedStatement.setInt(2, textbook.getStorageNum());
        preparedStatement.setInt(3, textbook.getYearOfPublication());
        preparedStatement.setString(4, textbook.getTitle());
        return preparedStatement.executeUpdate();
    }

}
