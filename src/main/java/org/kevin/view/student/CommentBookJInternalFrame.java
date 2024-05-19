/*
 * Created by JFormDesigner on Thu May 16 16:14:29 EDT 2024
 */

package org.kevin.view.student;

import org.kevin.dao.NovelDao;
import org.kevin.dao.TextbookDao;
import org.kevin.dto.Novel;
import org.kevin.dto.Textbook;
import org.kevin.util.DBUtil;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class CommentBookJInternalFrame extends JInternalFrame {
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();
    private TextbookDao textbookDao = new TextbookDao();
    public CommentBookJInternalFrame() {
        initComponents();
        setSize(590, 440);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void onCommentPressed(ActionEvent event) {
        if (idTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "id can't be empty");
            return;
        }
        if (ratingTxt.getText().isEmpty())  {
            JOptionPane.showMessageDialog(null, "rating can't be empty");
            return;
        }
        if (commentArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "comment can't be empty");
            return;
        }

        int rating = Integer.parseInt(ratingTxt.getText());

        if (rating < 0 || rating > 5) {
            JOptionPane.showMessageDialog(null, "rating should be between 0 to 5");
            return;
        }

        String id = idTxt.getText();
        String comment = commentArea.getText();
        Connection con = null;

        if (textbookJrb.isSelected()) {
            try {
                con = dbUtil.getCon();
                ResultSet resultSet = textbookDao.list(con, new Textbook());
                boolean flag = false;

                while (resultSet.next()) {
                    String currentId = resultSet.getString("id");
                    if (id.equals(currentId)) {
                        flag = true;

                        textbookDao.comment(con, comment, Integer.parseInt(id));
                        textbookDao.rate(con, rating, Integer.parseInt(id));

                        JOptionPane.showMessageDialog(null, "comment successfully");
                        break;
                    }
                }

                if (!flag) {
                    JOptionPane.showMessageDialog(null, "The book with such id doesn't exist");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    dbUtil.closeCon(con);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                con = dbUtil.getCon();
                ResultSet resultSet = novelDao.list(con, new Novel());
                boolean flag = false;

                while (resultSet.next()) {
                    String currentId = resultSet.getString("id");
                    if (id.equals(currentId)) {
                        flag = true;

                        novelDao.comment(con, comment, Integer.parseInt(id));
                        novelDao.rate(con, rating, Integer.parseInt(id));

                        JOptionPane.showMessageDialog(null, "comment successfully");
                        break;
                    }
                }

                if (!flag) {
                    JOptionPane.showMessageDialog(null, "The book with such id doesn't exist");
                }
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        panel1 = new JPanel();
        label1 = new JLabel();
        idTxt = new JTextField();
        label2 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        commentArea = new JTextArea();
        label3 = new JLabel();
        ratingTxt = new JTextField();
        textbookJrb = new JRadioButton();
        novelJrb = new JRadioButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Comment book");
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
            ),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
            )))throw new RuntimeException();}});

            //---- label1 ----
            label1.setText("Enter the book id you want to comment on: ");

            //---- label2 ----
            label2.setText("Write your comment:");

            //---- button1 ----
            button1.setText("Comment");
            button1.addActionListener(e -> onCommentPressed(e));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(commentArea);
            }

            //---- label3 ----
            label3.setText("Enter a rating from 1 to 5:");

            //---- textbookJrb ----
            textbookJrb.setText("Textbook");

            //---- novelJrb ----
            novelJrb.setText("Novel");
            novelJrb.setSelected(true);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(label1)
                                            .addComponent(label3))
                                        .addGap(26, 26, 26)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ratingTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addComponent(button1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(textbookJrb)
                                .addGap(96, 96, 96)
                                .addComponent(novelJrb)))
                        .addContainerGap(103, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(ratingTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textbookJrb)
                            .addComponent(novelJrb))
                        .addGap(23, 23, 23)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button1)
                        .addGap(18, 18, 18))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(textbookJrb);
        buttonGroup1.add(novelJrb);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        commentArea.setLineWrap(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel panel1;
    private JLabel label1;
    private JTextField idTxt;
    private JLabel label2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea commentArea;
    private JLabel label3;
    private JTextField ratingTxt;
    private JRadioButton textbookJrb;
    private JRadioButton novelJrb;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
