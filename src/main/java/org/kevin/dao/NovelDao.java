package org.kevin.dao;

import org.kevin.dto.Novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Novel Dao class
 * @author Kevin-Yichen Li
 */
public class NovelDao implements Commentable, LibraryItemDao<Novel>{

    /**
     * add novel to database
     * @param con
     * @param novel
     * @return
     * @throws Exception
     */
    public int add(Connection con, Novel novel) throws Exception {
        String sql = "insert into t_novel (id, author, storageNum, yearOfPublication, title, genre) values(null, ?, ?, ?, ?, ?)";
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

    public int delete(Connection con, int id) throws Exception {
        String sql = "delete from t_novel where id=?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public int update(Connection con, Novel novel, int id) throws Exception {
        String sql = "update t_novel set author=?, yearOfPublication=?, title=?, genre=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, novel.getAuthor());
        preparedStatement.setInt(2, novel.getYearOfPublication());
        preparedStatement.setString(3, novel.getTitle());
        preparedStatement.setString(4, novel.getGenre().name());
        preparedStatement.setInt(5, id);

        return preparedStatement.executeUpdate();
    }

    public int comment(Connection con, String comment, int id) throws Exception {
        String sql = "update t_novel set comments=? where id=?";

        ResultSet rs = list(con, new Novel());
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
        String sql = "update t_novel set rating=? where id=?";

        double originalRating = 0;
        ResultSet rs = list(con, new Novel());
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

    public int approved(Connection con, int novelId) throws Exception {
        String sql = "update t_novel set storageNum=? where id=?";

        int storageNum = 0;
        ResultSet rs = list(con, new Novel());
        while (rs.next()) {
            if (rs.getString("id").equals(novelId + "")) {
                storageNum = rs.getInt("storageNum");
                break;
            }
        }
        storageNum--;

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, storageNum);
        preparedStatement.setInt(2, novelId);
        return preparedStatement.executeUpdate();
    }

    public int returned(Connection con, int novelId) throws Exception {
        String sql = "update t_novel set storageNum=? where id=?";

        int storageNum = 0;
        ResultSet rs = list(con, new Novel());
        while (rs.next()) {
            if (rs.getString("id").equals(novelId + "")) {
                storageNum = rs.getInt("storageNum");
                break;
            }
        }
        storageNum++;

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, storageNum);
        preparedStatement.setInt(2, novelId);
        return preparedStatement.executeUpdate();
    }
}
