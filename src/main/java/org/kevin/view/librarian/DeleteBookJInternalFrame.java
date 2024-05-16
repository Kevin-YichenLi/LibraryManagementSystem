/*
 * Created by JFormDesigner on Thu May 02 12:35:19 EDT 2024
 */

package org.kevin.view.librarian;

import org.kevin.dao.NovelDao;
import org.kevin.dto.Novel;
import org.kevin.util.DBUtil;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class DeleteBookJInternalFrame extends JInternalFrame {
    public DeleteBookJInternalFrame() {
        initComponents();
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void onDeletePressed(ActionEvent event) {
        if (idTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "id can't be empty");
            return;
        }
        int id = Integer.parseInt(idTxt.getText());

        if (textbookJrb.isSelected()) {

        } else {
            Novel novel = null;
            Connection con = null;
            try {
                con = dbUtil.getCon();
                ResultSet resultSet = novelDao.list(con, new Novel());
                boolean flag = false;


                while (resultSet.next()) {
                    String currentId = resultSet.getString("id");
                    if ((id == Integer.parseInt(currentId))) {
                        novelDao.delete(con, id);
                        flag = true;
                        JOptionPane.showMessageDialog(null, "delete successfully");
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
        contentPane = new JPanel();
        label1 = new JLabel();
        idTxt = new JTextField();
        button1 = new JButton();
        textbookJrb = new JRadioButton();
        novelJrb = new JRadioButton();

        //======== this ========
        setVisible(true);
        setTitle("delete book");
        setIconifiable(true);
        setClosable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,contentPane. getBorder( )) ); contentPane. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- label1 ----
            label1.setText("Please provide the book ID you wish to delete.");

            //---- button1 ----
            button1.setText("Delete");
            button1.addActionListener(e -> onDeletePressed(e));

            //---- textbookJrb ----
            textbookJrb.setText("Textbook");
            textbookJrb.setSelected(true);

            //---- novelJrb ----
            novelJrb.setText("Novel");

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(label1))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(textbookJrb)
                                .addGap(32, 32, 32)
                                .addComponent(novelJrb))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button1))))
                        .addContainerGap(25, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textbookJrb)
                            .addComponent(novelJrb))
                        .addGap(26, 26, 26)
                        .addComponent(label1)
                        .addGap(25, 25, 25)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button1)
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

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(textbookJrb);
        buttonGroup1.add(novelJrb);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel contentPane;
    private JLabel label1;
    private JTextField idTxt;
    private JButton button1;
    private JRadioButton textbookJrb;
    private JRadioButton novelJrb;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();

}
