/*
 * Created by JFormDesigner on Thu May 02 13:32:12 EDT 2024
 */

package org.kevin.view.librarian;

import org.kevin.dao.NovelDao;
import org.kevin.dao.TextbookDao;
import org.kevin.dto.Genre;
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
public class EditBookJInternalFrame extends JInternalFrame {
    private TextbookDao textbookDao = new TextbookDao();
    public EditBookJInternalFrame() {
        initComponents();
        setSize(580, 350);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void onEditPressed(ActionEvent event) {
        String title = titleTxt.getText();
        String author = authorTxt.getText();

        if (idTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Id can't be empty");
            return;
        }

        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(null, "title can't be empty");
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


        int id = Integer.parseInt(idTxt.getText());
        int yearOfPublication = Integer.parseInt(yearOfPublicationTxt.getText());

        if (textbookJrb.isSelected()) {
            if (!genreJcb.getSelectedItem().toString().equals("None, it's a textbook")) {
                JOptionPane.showMessageDialog(null, "Textbooks don't have genre");
                return;
            }

            Connection con = null;
            try {
                con = dbUtil.getCon();
                ResultSet resultSet = textbookDao.list(con, new Textbook());
                boolean flag = false;

                while (resultSet.next()) {
                    String currentId = resultSet.getString("id");
                    if ((id == Integer.parseInt(currentId))) {
                        Textbook textbook = new Textbook(title, yearOfPublication, author);

                        textbookDao.update(con, textbook, id);
                        flag = true;
                        JOptionPane.showMessageDialog(null, "edit successfully");
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
            if (genreJcb.getSelectedItem().toString().equals("None, it's a textbook")) {
                JOptionPane.showMessageDialog(null, "genre can't be none, it's a novel");
                return;
            }

            Genre genre = Genre.valueOf(genreJcb.getSelectedItem().toString().replace('-', '_').toUpperCase());

            Connection con = null;
            try {
                con = dbUtil.getCon();
                ResultSet resultSet = novelDao.list(con, new Novel());
                boolean flag = false;


                while (resultSet.next()) {
                    String currentId = resultSet.getString("id");
                    if ((id == Integer.parseInt(currentId))) {
                        Novel novel = new Novel(title, yearOfPublication, genre, author);

                        novelDao.update(con, novel, id);
                        flag = true;
                        JOptionPane.showMessageDialog(null, "edit successfully");
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
        label2 = new JLabel();
        label3 = new JLabel();
        textbookJrb = new JRadioButton();
        novelJrb = new JRadioButton();
        idTxt = new JTextField();
        titleTxt = new JTextField();
        authorTxt = new JTextField();
        label4 = new JLabel();
        yearOfPublicationTxt = new JTextField();
        label5 = new JLabel();
        genreJcb = new JComboBox();
        label6 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("edit book");
        setClosable(true);
        setIconifiable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,contentPane. getBorder () ) ); contentPane. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- label2 ----
            label2.setText("Author:");

            //---- label3 ----
            label3.setText("Title:");

            //---- textbookJrb ----
            textbookJrb.setText("Textbook");
            textbookJrb.setSelected(true);

            //---- novelJrb ----
            novelJrb.setText("Novel");

            //---- label4 ----
            label4.setText("Year of publication:");

            //---- label5 ----
            label5.setText("Genre: ");

            //---- label6 ----
            label6.setText("Edit book based on id:");

            //---- button1 ----
            button1.setText("Edit");
            button1.addActionListener(e -> onEditPressed(e));

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(textbookJrb)
                                .addGap(18, 18, 18)
                                .addComponent(novelJrb)
                                .addGap(39, 39, 39))
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label2)
                                    .addComponent(label3))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label4)
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(30, 30, 30)))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(genreJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearOfPublicationTxt, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addContainerGap(208, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addGap(194, 194, 194))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textbookJrb)
                            .addComponent(novelJrb)
                            .addComponent(label6)
                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(yearOfPublicationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(genreJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(label2)
                            .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(button1)
                        .addContainerGap(25, Short.MAX_VALUE))
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
                .addGroup(contentPane2Layout.createSequentialGroup()
                    .addComponent(contentPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
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
    private JLabel label2;
    private JLabel label3;
    private JRadioButton textbookJrb;
    private JRadioButton novelJrb;
    private JTextField idTxt;
    private JTextField titleTxt;
    private JTextField authorTxt;
    private JLabel label4;
    private JTextField yearOfPublicationTxt;
    private JLabel label5;
    private JComboBox genreJcb;
    private JLabel label6;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();

    private void fillGenre() {
        genreJcb.addItem("Action");
        genreJcb.addItem("Fantasy");
        genreJcb.addItem("Horror");
        genreJcb.addItem("Science-fiction");
        genreJcb.addItem("None, it's a textbook");
    }
}
