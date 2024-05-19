/*
 * Created by JFormDesigner on Thu May 16 18:17:52 EDT 2024
 */

package org.kevin.view.student;

import org.kevin.dao.NovelDao;
import org.kevin.dao.TextbookDao;
import org.kevin.dto.Novel;
import org.kevin.dto.Textbook;
import org.kevin.util.DBUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author kevin
 */
public class ViewCommentsJInternalFrame extends JInternalFrame {
    private TextbookDao textbookDao = new TextbookDao();
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();
    private StudentMainJFrame studentMainFrame;

    public ViewCommentsJInternalFrame(StudentMainJFrame studentMainFrame) {
        this.studentMainFrame = studentMainFrame;
        initComponents();
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void onViewCommentsPressed(ActionEvent event) {
        if (idTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "id can't be empty");
            return;
        }

        int id = Integer.parseInt(idTxt.getText());


        Connection con = null;
        ResultSet resultSet = null;
        try {
            con = dbUtil.getCon();

            if (textbookJrb.isSelected()) {
                resultSet = textbookDao.list(con, new Textbook());
            } else {
                resultSet = novelDao.list(con, new Novel());
            }
            boolean flag = false;

            while (resultSet.next()) {
                String currentId = resultSet.getString("id");
                if ((id == Integer.parseInt(currentId))) {
                    this.dispose();
                    if (textbookJrb.isSelected()) {
                        studentMainFrame.addJInternalFrame(new CommentsAndRatingJInternalFrame("textbook", id));
                    } else {
                        studentMainFrame.addJInternalFrame(new CommentsAndRatingJInternalFrame("novel", id));
                    }
                    flag = true;
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        label1 = new JLabel();
        textbookJrb = new JRadioButton();
        novelJrb = new JRadioButton();
        idTxt = new JTextField();
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("View comments");
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Enter the book id:");

        //---- textbookJrb ----
        textbookJrb.setText("textbook");

        //---- novelJrb ----
        novelJrb.setText("novel");
        novelJrb.setSelected(true);

        //---- button1 ----
        button1.setText("View comments");
        button1.addActionListener(e -> onViewCommentsPressed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(textbookJrb))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(label1)))
                            .addGap(41, 41, 41)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(novelJrb)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(button1)))
                    .addContainerGap(68, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textbookJrb)
                        .addComponent(novelJrb))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(46, 46, 46)
                    .addComponent(button1)
                    .addContainerGap(42, Short.MAX_VALUE))
        );

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(textbookJrb);
        buttonGroup1.add(novelJrb);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JLabel label1;
    private JRadioButton textbookJrb;
    private JRadioButton novelJrb;
    private JTextField idTxt;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
