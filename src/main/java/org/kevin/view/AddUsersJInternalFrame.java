/*
 * Created by JFormDesigner on Wed May 15 17:39:42 EDT 2024
 */

package org.kevin.view;

import org.kevin.dao.UserDao;
import org.kevin.dto.User;
import org.kevin.util.DBUtil;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class AddUsersJInternalFrame extends JInternalFrame {
    private UserDao userDao = new UserDao();
    private DBUtil dbUtil = new DBUtil();

    public AddUsersJInternalFrame() {
        initComponents();
        setSize(640, 452);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * add user
     * @param event
     */
    private void onAddPressed(ActionEvent event) {
        if (!new String(passwordTxt.getPassword()).equals(new String(passwordConfirmTxt.getPassword()))) {
            JOptionPane.showMessageDialog(null, "You must enter the same password");
            return;
        }

        if (passwordConfirmTxt.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please confirm your password");
            return;
        }

        if (userNameTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a user name");
            return;
        }

        if (passwordTxt.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a password");
            return;
        }

        String userName = userNameTxt.getText();
        String password = new String(passwordConfirmTxt.getPassword());
        String status = "";

        if (studentJrb.isSelected()) {
            status = "student";
        } else {
            status = "librarian";
        }

        User user = new User(userName, password, status);

        Connection con = null;
        int addNum = 0;
        try {
            con = dbUtil.getCon();

            ResultSet list = userDao.list(con, new User());
            while (list.next()) {
                if (list.getString(2).equals(userName)) {
                    JOptionPane.showMessageDialog(null, "The user name already exist");
                    return;
                }
            }

            addNum = userDao.add(con, user);

            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "Add successfully");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "Add user failed");
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
        contentPane = new JPanel();
        librarianJrb = new JRadioButton();
        studentJrb = new JRadioButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        userNameTxt = new JTextField();
        passwordTxt = new JPasswordField();
        label4 = new JLabel();
        passwordConfirmTxt = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("Add User");
        setIconifiable(true);
        setClosable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
            .BOLD,12),java.awt.Color.red),contentPane. getBorder()));contentPane. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
            .equals(e.getPropertyName()))throw new RuntimeException();}});

            //---- librarianJrb ----
            librarianJrb.setText("Librarian");

            //---- studentJrb ----
            studentJrb.setText("Student");
            studentJrb.setSelected(true);

            //---- label1 ----
            label1.setText("User type:");

            //---- label2 ----
            label2.setText("User name:");

            //---- label3 ----
            label3.setText("Password:");

            //---- label4 ----
            label4.setText("Please confirm the password:");

            //---- button1 ----
            button1.setText("Add");
            button1.addActionListener(e -> onAddPressed(e));

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label4)
                                    .addComponent(label3)
                                    .addComponent(label2)
                                    .addComponent(label1))
                                .addGap(48, 48, 48)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(librarianJrb)
                                        .addGap(32, 32, 32)
                                        .addComponent(studentJrb))
                                    .addComponent(userNameTxt)
                                    .addComponent(passwordTxt)
                                    .addComponent(passwordConfirmTxt)))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addComponent(button1)))
                        .addContainerGap(178, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(librarianJrb)
                            .addComponent(studentJrb)
                            .addComponent(label1))
                        .addGap(40, 40, 40)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(label2)
                            .addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(passwordConfirmTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addGap(53, 53, 53))
            );
        }

        GroupLayout contentPane2Layout = new GroupLayout(contentPane2);
        contentPane2.setLayout(contentPane2Layout);
        contentPane2Layout.setHorizontalGroup(
            contentPane2Layout.createParallelGroup()
                .addComponent(contentPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPane2Layout.setVerticalGroup(
            contentPane2Layout.createParallelGroup()
                .addComponent(contentPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(librarianJrb);
        buttonGroup1.add(studentJrb);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel contentPane;
    private JRadioButton librarianJrb;
    private JRadioButton studentJrb;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField userNameTxt;
    private JPasswordField passwordTxt;
    private JLabel label4;
    private JPasswordField passwordConfirmTxt;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void resetValue() {
        userNameTxt.setText("");
        passwordTxt.setText("");
        passwordConfirmTxt.setText("");
        studentJrb.setSelected(true);
    }
}
