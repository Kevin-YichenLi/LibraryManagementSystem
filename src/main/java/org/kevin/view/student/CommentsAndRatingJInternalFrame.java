/*
 * Created by JFormDesigner on Thu May 16 19:04:09 EDT 2024
 */

package org.kevin.view.student;

import org.kevin.dto.Novel;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kevin
 */
public class CommentsAndRatingJInternalFrame extends JInternalFrame {
    private String type;
    private int id;
    public CommentsAndRatingJInternalFrame(String type, int id) {
        initComponents();
        setSize(580, 435);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.type = type;
        this.id = id;
        showAverageRating();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        ratingTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        commentTxt = new JTextArea();

        //======== this ========
        setVisible(true);
        setTitle("Comments and rating");
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Previous");

        //---- button2 ----
        button2.setText("Next");

        //---- label1 ----
        label1.setText("Average rating:");

        //---- ratingTxt ----
        ratingTxt.setEditable(false);

        //======== scrollPane1 ========
        {

            //---- commentTxt ----
            commentTxt.setEditable(false);
            scrollPane1.setViewportView(commentTxt);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addComponent(label1)
                    .addGap(29, 29, 29)
                    .addComponent(ratingTxt, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(213, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(ratingTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JTextField ratingTxt;
    private JScrollPane scrollPane1;
    private JTextArea commentTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void showAverageRating() {

    }
}
