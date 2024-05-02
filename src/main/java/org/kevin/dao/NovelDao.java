package org.kevin.dao;

import org.kevin.dto.Novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Novel Dao class
 * @author Kevin-Yichen Li
 */
public class NovelDao {

    /**
     * add novel to database
     * @param con
     * @param novel
     * @return
     * @throws Exception
     */
    public int add(Connection con, Novel novel) throws Exception {
        String sql = "insert into t_novel values(null, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, novel.getAuthor());
        preparedStatement.setInt(2, novel.getStorageNum());
        preparedStatement.setInt(3, novel.getYearOfPublication());
        preparedStatement.setString(4, novel.getTitle());
        preparedStatement.setString(5, novel.getGenre().name());
        return preparedStatement.executeUpdate();
    }

    /**
     * Search for a specific book
     * @param con
     * @param novel
     * @return
     * @throws Exception
     */
    public ResultSet list(Connection con, Novel novel) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_novel");
        if (novel != null && novel.getTitle() != null && !novel.getTitle().isBlank()) {
            sb.append(" and title like '%"+novel.getTitle()+"%'");
        }
        if (novel != null && novel.getAuthor() != null && !novel.getAuthor().isEmpty()) {
            sb.append(" and author like '%"+novel.getAuthor()+"%'");
        }
        if (novel != null && novel.getYearOfPublication() != 0) {
            String yearOfPublicationStr = "" + novel.getYearOfPublication();
            sb.append(" and yearOfPublication like '%"+yearOfPublicationStr+"%'");
        }
        if (novel != null && novel.getGenre() != null) {
            sb.append(" and genre like '%"+novel.getGenre().name()+"%'");
        }

        PreparedStatement preparedStatement = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return preparedStatement.executeQuery();
    }

}
