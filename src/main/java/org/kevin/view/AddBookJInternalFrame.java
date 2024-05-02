/*
 * Created by JFormDesigner on Mon Apr 29 23:55:08 EDT 2024
 */

package org.kevin.view;

import java.awt.event.*;

import org.kevin.dao.NovelDao;
import org.kevin.dao.TextbookDao;
import org.kevin.dto.Genre;
import org.kevin.dto.Novel;
import org.kevin.dto.Textbook;
import org.kevin.util.DBUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Connection;

/**
 * @author kevin
 */
public class AddBookJInternalFrame extends JInternalFrame {
    public AddBookJInternalFrame() {
        initComponents();
        setSize(472, 472);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void onAddPressed(ActionEvent event) throws Exception{
        String title = titleTxt.getText();
        String storageNum = storageNumTxt.getText();
        String author = authorTxt.getText();
        String yearOfPublication = yearOfPublicationTxt.getText();

        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(null, "title can't be empty");
            return;
        }
        if (storageNumTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "storage number can't be empty");
            return;
        }
        if (author.isEmpty()) {
            JOptionPane.showMessageDialog(null, "author can't be empty");
            return;
        }
        if (yearOfPublicationTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "year of publication can't be empty");
            return;
        }

        String type = "";
        if (textbookJrb.isSelected()) {
            type = "textbook";
        } else if (novelJrb.isSelected()) {
            type = "novel";
        }

        Genre genre = null;
        if (!genreJcb.getSelectedItem().toString().equals("None, it's a textbook")) {
            genre = Genre.valueOf(genreJcb.getSelectedItem().toString().replace('-', '_').toUpperCase());
        }

        if (type.equals("textbook")) {
            textbook = new Textbook(title, Integer.parseInt(yearOfPublication), Integer.parseInt(storageNum), author);
        } else {
            novel = new Novel(title, genre, Integer.parseInt(yearOfPublication), Integer.parseInt(storageNum), author);
        }

        Connection con = null;
        int addNum = 0;
        try {
            con = dbUtil.getCon();
            if (type.equals("textbook")) {
                addNum = textbookDao.add(con, textbook);
            } else {
                addNum = novelDao.add(con, novel);
            }
            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "Add successfully");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "Add book failed");
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

    private void onResetPressed(ActionEvent e) {
        resetValue();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        contentPane = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button1 = new JButton();
        titleTxt = new JTextField();
        authorTxt = new JTextField();
        storageNumTxt = new JTextField();
        yearOfPublicationTxt = new JTextField();
        textbookJrb = new JRadioButton();
        novelJrb = new JRadioButton();
        button2 = new JButton();
        genreJcb = new JComboBox();
        button3 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("add book");
        setClosable(true);
        setIconifiable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
            . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing
            .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
            Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,contentPane. getBorder () ) ); contentPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
            public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName (
            ) ) )throw new RuntimeException( ) ;} } );

            //---- label1 ----
            label1.setText("Title:");

            //---- label2 ----
            label2.setText("Author:");

            //---- label3 ----
            label3.setText("Storage number: ");

            //---- label5 ----
            label5.setText("Year of publication:");

            //---- label6 ----
            label6.setText("Textbook or novel?");

            //---- label7 ----
            label7.setText("Genre:");

            //---- button1 ----
            button1.setText("Add");

            //---- textbookJrb ----
            textbookJrb.setText("Textbook");
            textbookJrb.setSelected(true);

            //---- novelJrb ----
            novelJrb.setText("Novel");

            //---- button2 ----
            button2.setText("add");
            button2.addActionListener(e -> {try {
onAddPressed(e);} catch (Exception ex) {
    throw new RuntimeException(ex);
}});

            //---- button3 ----
            button3.setText("reset");
            button3.addActionListener(e -> onResetPressed(e));

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label1)
                                    .addComponent(label2)
                                    .addComponent(label5)
                                    .addComponent(label3)
                                    .addComponent(label6)
                                    .addComponent(label7)))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(button1))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(button2)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(button3))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(novelJrb)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textbookJrb))
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(storageNumTxt, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(yearOfPublicationTxt, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(genreJcb, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))))))
                        .addContainerGap(133, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(storageNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(yearOfPublicationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addGap(27, 27, 27)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(textbookJrb)
                            .addComponent(novelJrb))
                        .addGap(19, 19, 19)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(genreJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button3))
                        .addGap(276, 276, 276)
                        .addComponent(button1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(contentPane, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(textbookJrb);
        buttonGroup1.add(novelJrb);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        fillGenre();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel contentPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button1;
    private JTextField titleTxt;
    private JTextField authorTxt;
    private JTextField storageNumTxt;
    private JTextField yearOfPublicationTxt;
    private JRadioButton textbookJrb;
    private JRadioButton novelJrb;
    private JButton button2;
    private JComboBox genreJcb;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private DBUtil dbUtil = new DBUtil();
    private Novel novel = new Novel();
    private NovelDao novelDao = new NovelDao();
    private TextbookDao textbookDao = new TextbookDao();
    private Textbook textbook = new Textbook();

    /**
     * initialize genre Jcb
     */
    private void fillGenre() {
        genreJcb.addItem("Action");
        genreJcb.addItem("Fantasy");
        genreJcb.addItem("Horror");
        genreJcb.addItem("Science-fiction");
        genreJcb.addItem("None, it's a textbook");
    }
    
    private void resetValue() {
        titleTxt.setText("");
        yearOfPublicationTxt.setText("");
        authorTxt.setText("");
        storageNumTxt.setText("");
        textbookJrb.setSelected(true);
        genreJcb.setSelectedIndex(0);
    }
}
