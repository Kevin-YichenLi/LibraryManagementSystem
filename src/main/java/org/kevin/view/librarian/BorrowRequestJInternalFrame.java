/*
 * Created by JFormDesigner on Sat May 18 18:21:22 EDT 2024
 */

package org.kevin.view.librarian;

import java.awt.event.*;
import org.kevin.dao.NovelDao;
import org.kevin.dao.OperationDao;
import org.kevin.dto.Novel;
import org.kevin.util.DBUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author kevin
 */
public class BorrowRequestJInternalFrame extends JInternalFrame {
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();
    private OperationDao operationDao = new OperationDao();

    public BorrowRequestJInternalFrame() {
        initComponents();
        setSize(650, 375);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        fillTable();
    }

    private void onApprovedPressed(ActionEvent event) {
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

                    novelDao.approved(con, novelId);
                    operationDao.approved(con, operationId);

                    JOptionPane.showMessageDialog(null, "borrow approved successfully");
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

    private void onRejectedPressed(ActionEvent event) {
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

                    operationDao.rejected(con, operationId);

                    JOptionPane.showMessageDialog(null, "borrow rejected successfully");
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
        contentPane = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        label1 = new JLabel();
        operationIdTxt = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("Borrow request");
        setMaximizable(true);
        setIconifiable(true);
        setClosable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,contentPane. getBorder( )) ); contentPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );

            //======== scrollPane1 ========
            {

                //---- table ----
                table.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, "", null, null},
                        {null, null, null, null, null},
                    },
                    new String[] {
                        "operation id", "user name", "novel id", "title", "status"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        true, true, false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = table.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(125);
                    cm.getColumn(2).setResizable(false);
                    cm.getColumn(2).setPreferredWidth(55);
                    cm.getColumn(3).setResizable(false);
                    cm.getColumn(3).setPreferredWidth(215);
                    cm.getColumn(4).setResizable(false);
                    cm.getColumn(4).setPreferredWidth(115);
                }
                scrollPane1.setViewportView(table);
            }

            //---- label1 ----
            label1.setText("Operation id:");

            //---- button1 ----
            button1.setText("rejected");
            button1.addActionListener(e -> onRejectedPressed(e));

            //---- button2 ----
            button2.setText("approved");
            button2.addActionListener(e -> onApprovedPressed(e));

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(label1)
                                .addGap(30, 30, 30)
                                .addComponent(operationIdTxt, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(button2)
                                .addGap(55, 55, 55)
                                .addComponent(button1)))
                        .addContainerGap(49, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(operationIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2)
                            .addComponent(button1))
                        .addContainerGap(32, Short.MAX_VALUE))
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel contentPane;
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label1;
    private JTextField operationIdTxt;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void fillTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet resultSet = operationDao.list(con);
            while (resultSet.next()) {
                if (resultSet.getString("status").equals("waiting")) {
                    ArrayList<String> rowData = new ArrayList<>();
                    rowData.add(resultSet.getString("operation_id"));
                    rowData.add(resultSet.getString("user name"));
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
