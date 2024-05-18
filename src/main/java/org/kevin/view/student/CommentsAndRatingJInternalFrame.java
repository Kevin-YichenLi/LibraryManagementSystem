/*
 * Created by JFormDesigner on Thu May 16 19:04:09 EDT 2024
 */

package org.kevin.view.student;

import java.awt.event.*;
import org.kevin.dao.NovelDao;
import org.kevin.dto.Novel;
import org.kevin.util.DBUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author kevin
 */
public class CommentsAndRatingJInternalFrame extends JInternalFrame {
    private String type;
    private int id;
    private int index;
    private int length;
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();
    public CommentsAndRatingJInternalFrame(String type, int id) {
        initComponents();
        setSize(580, 435);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.type = type;
        this.id = id;
        showAverageRating();
        index = 0;
        showComment();
    }

    private void onNextPressed(ActionEvent e) {
        if (index != length - 1) {
            index++;
            showComment();
        }
    }

    private void onPreviousPressed(ActionEvent e) {
        if (index != 0) {
            index--;
            showComment();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        ratingTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        commentTxt = new JTextArea();
        label2 = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("Comments and rating");
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Previous");
        button1.addActionListener(e -> onPreviousPressed(e));

        //---- button2 ----
        button2.setText("Next");
        button2.addActionListener(e -> onNextPressed(e));

        //---- label1 ----
        label1.setText("Average rating:");

        //---- ratingTxt ----
        ratingTxt.setEditable(false);

        //======== scrollPane1 ========
        {

            //---- commentTxt ----
            commentTxt.setEditable(false);
            scrollPane1.setViewportView(commentTxt);
        }

        //---- label2 ----
        label2.setText("Comments:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addComponent(label1)
                    .addGap(29, 29, 29)
                    .addComponent(ratingTxt, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(213, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(117, 117, 117)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(ratingTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(label2))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JTextField ratingTxt;
    private JScrollPane scrollPane1;
    private JTextArea commentTxt;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void showComment() {
        if (type.equals("textbook")) {

        } else {
            Connection con = null;
            try {
                con = dbUtil.getCon();
                ResultSet resultSet = novelDao.list(con, new Novel());

                int counter = 0;
                String originalComments = "";

                while (resultSet.next()) {
                    String currentId = resultSet.getString("id");
                    if (id == Integer.parseInt(currentId)) {
                        originalComments = resultSet.getString("comments");
                    }
                }

                String[] comments = originalComments.split("~");
                length = comments.length;
                commentTxt.setText(comments[index]);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    dbUtil.closeCon(con);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showAverageRating() {
        if (type.equals("textbook")) {

        } else {
            Connection con = null;
            try {
                con = dbUtil.getCon();
                ResultSet resultSet = novelDao.list(con, new Novel());

                double rating = 0;
                int counter = 0;
                String comments = "";

                while (resultSet.next()) {
                    String currentId = resultSet.getString("id");
                    if (id == Integer.parseInt(currentId)) {
                        rating = Double.parseDouble(resultSet.getString("rating"));
                        comments = resultSet.getString("comments");
                    }
                }

                for (int i = 0; i < comments.length(); i++) {
                    if (comments.charAt(i) == '~') {
                        counter++;
                    }
                }

                rating /= counter;
                ratingTxt.setText(rating + "");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    dbUtil.closeCon(con);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
