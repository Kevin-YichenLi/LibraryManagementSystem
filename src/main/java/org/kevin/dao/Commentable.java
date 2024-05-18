package org.kevin.dao;

import java.sql.Connection;

public interface Commentable {
    int comment(Connection con, String comment, int id) throws Exception;
    int rate(Connection con, double rating, int id) throws Exception;
}
