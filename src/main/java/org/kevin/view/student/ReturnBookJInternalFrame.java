/*
 * Created by JFormDesigner on Sat May 18 19:59:00 EDT 2024
 */

package org.kevin.view.student;

import org.kevin.dao.NovelDao;
import org.kevin.dao.OperationDao;
import org.kevin.dto.User;
import org.kevin.util.DBUtil;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author kevin
 */
public class ReturnBookJInternalFrame extends JInternalFrame {
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();
    private User currentUser;
    private OperationDao operationDao = new OperationDao();

    public ReturnBookJInternalFrame(User currentUser) {
        initComponents();
        setSize(700, 390);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.currentUser = currentUser;
        fillTable();
    }

    private void onReturnPressed(ActionEvent event) {
        if (operationIdTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "id can't be empty");
            return;
        }

        int operationId = Integer.parseInt(operationIdTxt.getText());

        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet operationResultSet = operationDao.list(con);
            boolean flag = false;

            while (operationResultSet.next()) {
                int currentId = operationResultSet.getInt("operation_id");
                if (operationId == currentId) {
                    flag = true;
                    int novelId = operationResultSet.getInt("novel_id");

                    novelDao.returned(con, novelId);
                    operationDao.returned(con, operationId);

                    JOptionPane.showMessageDialog(null, "return successfully");
                    break;
                }
            }

            if (!flag) {
                JOptionPane.showMessageDialog(null, "Such operation id doesn't exist");
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

        fillTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        scrollPane1 = new JScrollPane();
        table = new JTable();
        label1 = new JLabel();
        operationIdTxt = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("Return book");
        setMaximizable(true);
        setIconifiable(true);
        setClosable(true);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, "", null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "operation id", "novel id", "title", "status"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    true, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = table.getColumnModel();
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(55);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(215);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(3).setPreferredWidth(115);
            }
            scrollPane1.setViewportView(table);
        }

        //---- label1 ----
        label1.setText("Operation id:");

        //---- button1 ----
        button1.setText("return");
        button1.addActionListener(e -> onReturnPressed(e));

        //---- label2 ----
        label2.setText("My borrow requests");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(label1)
                    .addGap(26, 26, 26)
                    .addComponent(operationIdTxt, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(178, 178, 178))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(operationIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label1;
    private JTextField operationIdTxt;
    private JButton button1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void fillTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet resultSet = operationDao.list(con);
            while (resultSet.next()) {
                if (currentUser.getUserName().equals(resultSet.getString("user name"))
                        && resultSet.getString("status").equals("approved")) {
                    ArrayList<String> rowData = new ArrayList<>();
                    rowData.add(resultSet.getString("operation_id"));
                    rowData.add(resultSet.getString("novel_id"));
                    rowData.add(resultSet.getString("title"));
                    rowData.add(resultSet.getString("status"));
                    defaultTableModel.addRow(rowData.toArray());
                }
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
