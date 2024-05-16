/*
 * Created by JFormDesigner on Thu May 16 12:21:28 EDT 2024
 */

package org.kevin.view.librarian;

import org.kevin.dao.UserDao;
import org.kevin.dto.Genre;
import org.kevin.dto.Novel;
import org.kevin.dto.User;
import org.kevin.util.DBUtil;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author kevin
 */
public class ViewUsersJInternalFrame extends JInternalFrame {
    private DBUtil dbUtil = new DBUtil();
    private UserDao userDao = new UserDao();
    public ViewUsersJInternalFrame() {
        initComponents();
        setSize(700, 472);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void onSearchPressed(ActionEvent event) {
        String userName = userNameTxt.getText();
        String status = statusJbc.getSelectedItem().toString();
        String hiddenPassword = "";

        User user = null;

        if (status.equals("none")) {
            user = new User(userName, hiddenPassword);
        } else {
            user = new User(userName, hiddenPassword, status);
        }

        System.out.println(user);
        fillTable(user);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        contentPane = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        label4 = new JLabel();
        button1 = new JButton();
        statusJbc = new JComboBox();
        userNameTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        table = new JTable();

        //======== this ========
        setVisible(true);
        setTitle("View users");
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,contentPane. getBorder () ) ); contentPane. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //======== panel1 ========
            {
                panel1.setBorder(new TitledBorder("Searching conditions"));

                //---- label1 ----
                label1.setText("User name:");

                //---- label4 ----
                label4.setText("Status:");

                //---- button1 ----
                button1.setText("Search");
                button1.addActionListener(e -> onSearchPressed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label4)
                            .addGap(18, 18, 18)
                            .addComponent(statusJbc, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap(20, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(36, 36, 36))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(statusJbc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4)
                                .addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1))
                            .addGap(0, 25, Short.MAX_VALUE))
                );
            }

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
            );
        }

        //======== scrollPane1 ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, "", "", ""},
                    {null, null, null, null},
                },
                new String[] {
                    "ID", "User name", "Password", "Status"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = table.getColumnModel();
                cm.getColumn(0).setPreferredWidth(40);
                cm.getColumn(1).setPreferredWidth(145);
                cm.getColumn(2).setPreferredWidth(145);
                cm.getColumn(3).setPreferredWidth(95);
            }
            scrollPane1.setViewportView(table);
        }

        GroupLayout contentPane2Layout = new GroupLayout(contentPane2);
        contentPane2.setLayout(contentPane2Layout);
        contentPane2Layout.setHorizontalGroup(
            contentPane2Layout.createParallelGroup()
                .addGroup(contentPane2Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(contentPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPane2Layout.createSequentialGroup()
                    .addContainerGap(86, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
                    .addGap(81, 81, 81))
        );
        contentPane2Layout.setVerticalGroup(
            contentPane2Layout.createParallelGroup()
                .addGroup(contentPane2Layout.createSequentialGroup()
                    .addComponent(contentPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        fillStatusJbc();
        fillTable(new User());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel contentPane;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label4;
    private JButton button1;
    private JComboBox statusJbc;
    private JTextField userNameTxt;
    private JScrollPane scrollPane1;
    private JTable table;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void fillStatusJbc() {
        statusJbc.addItem("student");
        statusJbc.addItem("librarian");
        statusJbc.addItem("none");
    }

    private void fillTable(User user) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet resultSet = userDao.list(con, user);
            while (resultSet.next()) {
                ArrayList<String> rowData = new ArrayList<>();
                rowData.add(resultSet.getString("id"));
                rowData.add(resultSet.getString("userName"));
                String password = resultSet.getString("password");
                String hiddenPassword = "*".repeat(password.length());
                rowData.add(hiddenPassword);
                rowData.add(resultSet.getString("status"));
                defaultTableModel.addRow(rowData.toArray());
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
