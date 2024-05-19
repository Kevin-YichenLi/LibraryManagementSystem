package org.kevin.dao;

import org.kevin.dto.LibraryItem;
import org.kevin.dto.Novel;

import java.sql.Connection;
import java.sql.ResultSet;

public interface LibraryItemDao <T extends LibraryItem> {
    int add(Connection con, T book) throws Exception;

    ResultSet list(Connection con, T book) throws Exception;

    int delete(Connection con, int id) throws Exception;

    int update(Connection con, T book, int id) throws Exception;
}
