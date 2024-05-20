package org.kevin.dao;

import org.kevin.dto.Textbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Textbook Dao class
 * @author Kevin-Yichen Li
 */
public class TextbookDao implements LibraryItemDao<Textbook>, Commentable{
    public int add(Connection con, Textbook textbook) throws Exception {
        String sql = "insert into t_textbook (id, author, storageNum, yearOfPublication, title) values(null, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, textbook.getAuthor());
        preparedStatement.setInt(2, textbook.getStorageNum());
        preparedStatement.setInt(3, textbook.getYearOfPublication());
        preparedStatement.setString(4, textbook.getTitle());
        return preparedStatement.executeUpdate();
    }

    /**
     * Search for a specific book
     * @param con
     * @param textbook
     * @return
     * @throws Exception
     */
    public ResultSet list(Connection con, Textbook textbook) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_textbook");
        if (textbook != null && textbook.getTitle() != null && !textbook.getTitle().isBlank()) {
            sb.append(" and title like '%"+textbook.getTitle()+"%'");
        }
        if (textbook != null && textbook.getAuthor() != null && !textbook.getAuthor().isEmpty()) {
            sb.append(" and author like '%"+textbook.getAuthor()+"%'");
        }
        if (textbook != null && textbook.getYearOfPublication() != 0) {
            String yearOfPublicationStr = "" + textbook.getYearOfPublication();
            sb.append(" and yearOfPublication like '%"+yearOfPublicationStr+"%'");
        }

        PreparedStatement preparedStatement = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return preparedStatement.executeQuery();
    }

    public int delete(Connection con, int id) throws Exception {
        String sql = "delete from t_textbook where id=?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public int update(Connection con, Textbook textbook, int id) throws Exception {
        String sql = "update t_textbook set author=?, yearOfPublication=?, title=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, textbook.getAuthor());
        preparedStatement.setInt(2, textbook.getYearOfPublication());
        preparedStatement.setString(3, textbook.getTitle());
        preparedStatement.setInt(4, id);

        return preparedStatement.executeUpdate();
    }

    public int comment(Connection con, String comment, int id) throws Exception {
        String sql = "update t_textbook set comments=? where id=?";

        ResultSet rs = list(con, new Textbook());
        String originalComment = "";
        while (rs.next()) {
            if (rs.getString("comments") != null && rs.getString("id").equals(id + "")) {
                originalComment += rs.getString("comments");
            }
        }

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, originalComment + comment + "~");
        preparedStatement.setInt(2, id);
        return preparedStatement.executeUpdate();
    }

    public int rate(Connection con, double rating, int id) throws Exception {
        String sql = "update t_textbook set rating=? where id=?";

        double originalRating = 0;
        ResultSet rs = list(con, new Textbook());
        while (rs.next()) {
            if (rs.getString("rating") != null && rs.getString("id") .equals(id + "")) {
                originalRating += Double.parseDouble(rs.getString("rating"));
            }
        }

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setDouble(1, rating + originalRating);
        preparedStatement.setInt(2, id);
        return preparedStatement.executeUpdate();
    }
}
