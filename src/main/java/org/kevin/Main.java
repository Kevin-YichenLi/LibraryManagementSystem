package org.kevin;

import org.kevin.util.DBUtil;
import org.kevin.view.LogInJFrame;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        new LogInJFrame();
    }
}
