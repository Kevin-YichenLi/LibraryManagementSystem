/*
 * Created by JFormDesigner on Wed May 15 17:03:51 EDT 2024
 */

package org.kevin.view.student;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class StudentMainJFrame extends JFrame {
    public StudentMainJFrame() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void onQuitPressed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu5 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menu3 = new JMenu();
        menuItem7 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menu4 = new JMenu();
        menuItem4 = new JMenuItem();
        contentPane = new JPanel();
        desktopPane = new JDesktopPane();

        //======== this ========
        var contentPane2 = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Book operations");

                //======== menu5 ========
                {
                    menu5.setText("View books");

                    //---- menuItem2 ----
                    menuItem2.setText("View textbooks");
                    menu5.add(menuItem2);

                    //---- menuItem6 ----
                    menuItem6.setText("View novels");
                    menu5.add(menuItem6);
                }
                menu1.add(menu5);

                //---- menuItem1 ----
                menuItem1.setText("Comment book");
                menu1.add(menuItem1);

                //---- menuItem3 ----
                menuItem3.setText("View comments");
                menu1.add(menuItem3);

                //---- menuItem8 ----
                menuItem8.setText("Recommendations for you");
                menu1.add(menuItem8);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("Issue books");

                //---- menuItem7 ----
                menuItem7.setText("Borrow book");
                menu3.add(menuItem7);

                //---- menuItem5 ----
                menuItem5.setText("Return book");
                menu3.add(menuItem5);

                //---- menuItem9 ----
                menuItem9.setText("History");
                menu3.add(menuItem9);
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
            contentPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
            ),contentPane. getBorder()));contentPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
            )))throw new RuntimeException();}});

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu5;
    private JMenuItem menuItem2;
    private JMenuItem menuItem6;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JMenuItem menuItem8;
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JMenuItem menuItem5;
    private JMenuItem menuItem9;
    private JMenu menu4;
    private JMenuItem menuItem4;
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
