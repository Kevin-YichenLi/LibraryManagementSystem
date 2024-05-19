/*
 * Created by JFormDesigner on Sat May 18 16:45:49 EDT 2024
 */

package org.kevin.view.student;

import org.kevin.dao.NovelDao;
import org.kevin.dao.OperationDao;
import org.kevin.dto.Novel;
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
public class BorrowBookJInternalFrame extends JInternalFrame {
    private DBUtil dbUtil = new DBUtil();
    private OperationDao operationDao = new OperationDao();
    private NovelDao novelDao = new NovelDao();
    private User currentUser;
    public BorrowBookJInternalFrame(User currentUser) {
        initComponents();
        setSize(720, 455);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.currentUser = currentUser;
        fillTable();
    }

    private void onBorrowPressed(ActionEvent event) {
        if (idTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "id can't be empty");
            return;
        }
        
        int id = Integer.parseInt(idTxt.getText());

        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet resultSet = novelDao.list(con, new Novel());
            boolean flag = false;

            while (resultSet.next()) {
                int currentId = Integer.parseInt(resultSet.getString("id"));
                if (id == currentId) {
                    if (resultSet.getInt("storageNum") <= 0) {
                        JOptionPane.showMessageDialog(null, "Sorry, the requested book is out of stock");
                        return;
                    }

                    flag = true;
                    String title = resultSet.getString("title");
                    operationDao.borrow(con, currentUser.getUserName(), id, title);

                    JOptionPane.showMessageDialog(null, "borrow successfully");
                    break;
                }
            }

            if (!flag) {
                JOptionPane.showMessageDialog(null, "The novel with such id doesn't exist");
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
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        label4 = new JLabel();
        idTxt = new JTextField();
        label3 = new JLabel();
        label2 = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("Borrow");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,contentPane. getBorder( )) ); contentPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- button1 ----
            button1.setText("borrow");
            button1.addActionListener(e -> onBorrowPressed(e));

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

            //---- label4 ----
            label4.setText("My borrow requests:");

            //---- label3 ----
            label3.setText("id:");

            //---- label2 ----
            label2.setText("Only novels can be borrowed");

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(569, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(0, 151, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(label4)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(50, 50, 50)
                                    .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button1))
                                .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(80, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2)
                        .addGap(264, 264, 264))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 306, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(0, 71, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(label2)
                        .addGap(28, 28, 28)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1))
                        .addGap(31, 31, 31)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPane2Layout = new GroupLayout(contentPane2);
        contentPane2.setLayout(contentPane2Layout);
        contentPane2Layout.setHorizontalGroup(
            contentPane2Layout.createParallelGroup()
                .addComponent(contentPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPane2Layout.setVerticalGroup(
            contentPane2Layout.createParallelGroup()
                .addComponent(contentPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel contentPane;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label4;
    private JTextField idTxt;
    private JLabel label3;
    private JLabel label2;
    private JLabel label1;
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
                        && !resultSet.getString("status").equals("returned")) {
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
