/*
 * Created by JFormDesigner on Mon Apr 29 21:17:22 EDT 2024
 */

package org.kevin.view;

import org.kevin.dao.NovelDao;
import org.kevin.dao.UserDao;
import org.kevin.dto.User;
import org.kevin.util.DBUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class LogInJFrame extends JFrame{
    public LogInJFrame() {
        initComponents();
        setVisible(true);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setSize(405, 465);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void resetButton(ActionEvent event) {
        resetValueActionPerformed(event);
    }

    private void resetButtonPressed(ActionEvent event) {
        resetValueActionPerformed(event);
    }

    private void onLogInButtonPressed(ActionEvent event) {
        loginActionPerformed(event);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        LogInJFrame = new JFrame();
        contentPane = new JPanel();
        button3 = new JButton();
        button2 = new JButton();
        passwordTxt = new JPasswordField();
        userNameTxt = new JTextField();
        label5 = new JLabel();
        label4 = new JLabel();
        label3 = new JLabel();

        //======== LogInJFrame ========
        {
            LogInJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            LogInJFrame.setTitle("Log In");
            var LogInJFrameContentPane = LogInJFrame.getContentPane();

            //======== contentPane ========
            {
                contentPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
                EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER ,javax . swing
                . border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,
                java . awt. Color .red ) ,contentPane. getBorder () ) ); contentPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
                { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )
                throw new RuntimeException( ) ;} } );

                //---- button3 ----
                button3.setText("reset");
                button3.addActionListener(e -> resetButtonPressed(e));

                //---- button2 ----
                button2.setText("log in");
                button2.addActionListener(e -> onLogInButtonPressed(e));

                //---- label5 ----
                label5.setText("password");

                //---- label4 ----
                label4.setText("user name:");

                //---- label3 ----
                label3.setText("Library Management System");
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));

                GroupLayout contentPaneLayout = new GroupLayout(contentPane);
                contentPane.setLayout(contentPaneLayout);
                contentPaneLayout.setHorizontalGroup(
                    contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 59, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label5)
                                            .addGap(18, 18, 18)
                                            .addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(button2)
                                            .addGap(66, 66, 66)
                                            .addComponent(button3)))
                                    .addGap(88, 88, 88))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54))))
                );
                contentPaneLayout.setVerticalGroup(
                    contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                            .addGap(32, 32, 32)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5))
                            .addGap(56, 56, 56)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button3)
                                .addComponent(button2))
                            .addGap(54, 54, 54))
                );
            }

            GroupLayout LogInJFrameContentPaneLayout = new GroupLayout(LogInJFrameContentPane);
            LogInJFrameContentPane.setLayout(LogInJFrameContentPaneLayout);
            LogInJFrameContentPaneLayout.setHorizontalGroup(
                LogInJFrameContentPaneLayout.createParallelGroup()
                    .addComponent(contentPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            LogInJFrameContentPaneLayout.setVerticalGroup(
                LogInJFrameContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, LogInJFrameContentPaneLayout.createSequentialGroup()
                        .addComponent(contentPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            LogInJFrame.pack();
            LogInJFrame.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JFrame LogInJFrame;
    private JPanel contentPane;
    private JButton button3;
    private JButton button2;
    private JPasswordField passwordTxt;
    private JTextField userNameTxt;
    private JLabel label5;
    private JLabel label4;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private DBUtil dbUtil = new DBUtil();
    private UserDao userDao = new UserDao();

    /**
     * action performed when the reset button is pressed
     * @param event
     */
    private void resetValueActionPerformed(ActionEvent event) {
        this.userNameTxt.setText("");
        this.passwordTxt.setText("");
    }

    /**
     * action performed when the log in button is pressed
     * @param event
     */
    private void loginActionPerformed(ActionEvent event) {
        String userName = this.userNameTxt.getText();
        String password = new String(this.passwordTxt.getPassword());

        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "user name can't be empty");
            return;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "password can't be empty");
            return;
        }

        User user = new User(userName, password);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            User currentUser = userDao.login(con, user);
            if (currentUser != null) {
                JOptionPane.showMessageDialog(null, "Log in successfully, welcome!");
                dispose();
                if (currentUser.getStatus() != null && currentUser.getStatus().equals("librarian")) {
                    new MainJFrame();
                } else {
                    new StudentMainJFrame();
                }
            } else {
                JOptionPane.showMessageDialog(null, "wrong user name or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LogInJFrame();
    }
}
