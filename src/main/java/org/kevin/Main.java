package org.kevin;

import org.kevin.dao.OperationDao;
import org.kevin.dto.Novel;
import org.kevin.util.DBUtil;
import org.kevin.view.LogInJFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        new LogInJFrame();
    }
}
