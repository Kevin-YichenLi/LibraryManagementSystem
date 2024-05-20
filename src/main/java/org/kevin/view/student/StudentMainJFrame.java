/*
 * Created by JFormDesigner on Wed May 15 17:03:51 EDT 2024
 */

package org.kevin.view.student;

import org.kevin.dto.User;
import org.kevin.view.librarian.ViewNovelsJInternalFrame;
import org.kevin.view.librarian.ViewTextbooksJInternalFrame;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class StudentMainJFrame extends JFrame {
    private User currentUser;
    public StudentMainJFrame(User currentUser) {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(contentPane);
        this.currentUser = currentUser;
    }

    private void onQuitPressed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure to quit?");
        if (result == 0) {
            dispose();
        }
    }

    private void onViewNovelsPressed(ActionEvent e) {
        desktopPane.add(new ViewNovelsJInternalFrame());
    }

    private void onCommentPressed(ActionEvent e) {
        desktopPane.add(new CommentBookJInternalFrame());
    }

    private void onViewCommentsPressed(ActionEvent e) {
        desktopPane.add(new ViewCommentsJInternalFrame(this));
    }

    private void onBorrowBookPressed(ActionEvent e) {
        desktopPane.add(new BorrowBookJInternalFrame(currentUser));
    }

    private void onReturnBookPressed(ActionEvent e) {
        desktopPane.add(new ReturnBookJInternalFrame(currentUser));
    }

    private void onViewTextbooksPressed(ActionEvent e) {
        desktopPane.add(new ViewTextbooksJInternalFrame());
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
        menu3 = new JMenu();
        menuItem7 = new JMenuItem();
        menuItem5 = new JMenuItem();
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
                    menuItem2.addActionListener(e -> onViewTextbooksPressed(e));
                    menu5.add(menuItem2);

                    //---- menuItem6 ----
                    menuItem6.setText("View novels");
                    menuItem6.addActionListener(e -> {
			onViewNovelsPressed(e);
		});
                    menu5.add(menuItem6);
                }
                menu1.add(menu5);

                //---- menuItem1 ----
                menuItem1.setText("Comment book");
                menuItem1.addActionListener(e -> onCommentPressed(e));
                menu1.add(menuItem1);

                //---- menuItem3 ----
                menuItem3.setText("View comments");
                menuItem3.addActionListener(e -> onViewCommentsPressed(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("Issue books");

                //---- menuItem7 ----
                menuItem7.setText("Borrow book");
                menuItem7.addActionListener(e -> onBorrowBookPressed(e));
                menu3.add(menuItem7);

                //---- menuItem5 ----
                menuItem5.setText("Return book");
                menuItem5.addActionListener(e -> onReturnBookPressed(e));
                menu3.add(menuItem5);
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
            contentPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,contentPane. getBorder( )) ); contentPane. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPane2Layout = new GroupLayout(contentPane2);
        contentPane2.setLayout(contentPane2Layout);
        contentPane2Layout.setHorizontalGroup(
            contentPane2Layout.createParallelGroup()
                .addGroup(contentPane2Layout.createSequentialGroup()
                    .addComponent(contentPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
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
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JMenuItem menuItem5;
    private JMenu menu4;
    private JMenuItem menuItem4;
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void addJInternalFrame(JInternalFrame jInternalFrame) {
        desktopPane.add(jInternalFrame);
    }
}
