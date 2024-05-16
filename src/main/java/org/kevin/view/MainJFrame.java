/*
 * Created by JFormDesigner on Mon Apr 29 23:02:33 EDT 2024
 */

package org.kevin.view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class MainJFrame extends JFrame {

    public MainJFrame() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void onAddBookPressed(ActionEvent e) {
        addBookActionPerformed(e);
    }

    private void onQuitPressed(ActionEvent event) {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure to quit?");
        if (result == 0) {
            dispose();
        }
    }

    private void onViewNovelsPressed(ActionEvent e) {
        desktopPane.add(new ViewNovelsJInternalFrame());
    }

    private void onDeleteBookPressed(ActionEvent e) {
        desktopPane.add(new DeleteBookJInternalFrame());
    }

    private void onEditBookPressed(ActionEvent e) {
        desktopPane.add(new EditBookJInternalFrame());
    }

    private void onAddUserPressed(ActionEvent e) {
        desktopPane.add(new AddUsersJInternalFrame());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem1 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu5 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu2 = new JMenu();
        menuItem9 = new JMenuItem();
        menuItem10 = new JMenuItem();
        menu3 = new JMenu();
        menuItem7 = new JMenuItem();
        menu4 = new JMenu();
        menuItem4 = new JMenuItem();
        contentPane = new JPanel();
        desktopPane = new JDesktopPane();

        //======== this ========
        setTitle("Home");
        var contentPane2 = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Book management");

                //---- menuItem3 ----
                menuItem3.setText("Add book");
                menuItem3.addActionListener(e -> onAddBookPressed(e));
                menu1.add(menuItem3);

                //---- menuItem1 ----
                menuItem1.setText("Delete book");
                menuItem1.addActionListener(e -> onDeleteBookPressed(e));
                menu1.add(menuItem1);

                //---- menuItem5 ----
                menuItem5.setText("Edit book");
                menuItem5.addActionListener(e -> onEditBookPressed(e));
                menu1.add(menuItem5);

                //======== menu5 ========
                {
                    menu5.setText("View books");

                    //---- menuItem2 ----
                    menuItem2.setText("View textbooks");
                    menu5.add(menuItem2);

                    //---- menuItem6 ----
                    menuItem6.setText("View novels");
                    menuItem6.addActionListener(e -> onViewNovelsPressed(e));
                    menu5.add(menuItem6);
                }
                menu1.add(menu5);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Account management");

                //---- menuItem9 ----
                menuItem9.setText("Add users");
                menuItem9.addActionListener(e -> onAddUserPressed(e));
                menu2.add(menuItem9);

                //---- menuItem10 ----
                menuItem10.setText("View users");
                menu2.add(menuItem10);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Issue books");

                //---- menuItem7 ----
                menuItem7.setText("Borrow request");
                menu3.add(menuItem7);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("Quit");

                //---- menuItem4 ----
                menuItem4.setText("Quit");
                menuItem4.addActionListener(e -> onQuitPressed(e));
                menu4.add(menuItem4);
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //======== contentPane ========
        {
            contentPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
            .Color.red),contentPane. getBorder()));contentPane. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
            equals(e.getPropertyName()))throw new RuntimeException();}});

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
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
                .addComponent(contentPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem3;
    private JMenuItem menuItem1;
    private JMenuItem menuItem5;
    private JMenu menu5;
    private JMenuItem menuItem2;
    private JMenuItem menuItem6;
    private JMenu menu2;
    private JMenuItem menuItem9;
    private JMenuItem menuItem10;
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JMenu menu4;
    private JMenuItem menuItem4;
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void addBookActionPerformed (ActionEvent event) {
        AddBookJInternalFrame addBookJInternalFrame = new AddBookJInternalFrame();
        desktopPane.add(addBookJInternalFrame);
    }

    public static void main(String[] args) {
        new MainJFrame();
    }
}
