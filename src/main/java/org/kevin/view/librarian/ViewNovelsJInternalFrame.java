/*
 * Created by JFormDesigner on Thu May 02 00:39:41 EDT 2024
 */

package org.kevin.view.librarian;

import java.awt.event.*;
import org.kevin.dao.NovelDao;
import org.kevin.dto.Genre;
import org.kevin.dto.Novel;
import org.kevin.util.DBUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author kevin
 */
public class ViewNovelsJInternalFrame extends JInternalFrame {
    private int idSortCount;
    private int authorSortCount;
    private int yearOfPublicationSortCount;
    private int titleSortCount;
    public ViewNovelsJInternalFrame() {
        initComponents();
        setSize(700, 472);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        idSortCount = 0;
        titleSortCount = 0;
        yearOfPublicationSortCount = 0;
        authorSortCount = 0;
    }

    /**
     * search a novel
     * @param e
     */
    private void onSearchPressed(ActionEvent e) {
        int year = 0;
        String title = titleTxt.getText();
        String author = authorTxt.getText();
        String yearOfPublication = yearOfPublicationTxt.getText();
        if (!yearOfPublication.equals("")) {
            year = Integer.parseInt(yearOfPublication);
        }
        Genre genre = null;
        if (!genreJbc.getSelectedItem().toString().equals("Please choose...")) {
            genre = Genre.valueOf(genreJbc.getSelectedItem().toString().toUpperCase());
        }

        Novel novel = new Novel(title, year, genre, author);
        fillTable(novel);
    }

    private void sortOnId(ActionEvent e) {
        idSortCount++;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector<Vector> data = model.getDataVector();

        data.sort((Vector v1, Vector v2) -> {
            Integer id1 = Integer.parseInt(v1.get(0).toString());
            Integer id2 = Integer.parseInt(v2.get(0).toString());
            return idSortCount % 2 == 0 ? id1.compareTo(id2) : id2.compareTo(id1);
        });

        model.fireTableDataChanged();
    }

    private void sortOnAuthor(ActionEvent e) {
        authorSortCount++;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector<Vector> data = model.getDataVector();

        data.sort((Vector v1, Vector v2) -> {
            String author1 = v1.get(1).toString();
            String author2 = v2.get(1).toString();
            return authorSortCount % 2 == 0 ? author1.compareToIgnoreCase(author2) : author2.compareToIgnoreCase(author1);
        });

        model.fireTableDataChanged();
    }

    private void sortByYear(ActionEvent e) {
        yearOfPublicationSortCount++;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector<Vector> data = model.getDataVector();

        data.sort((Vector v1, Vector v2) -> {
            Integer year1 = Integer.parseInt(v1.get(3).toString());
            Integer year2 = Integer.parseInt(v2.get(3).toString());
            return yearOfPublicationSortCount % 2 == 0 ? year1.compareTo(year2) : year2.compareTo(year1);
        });

        model.fireTableDataChanged();
    }

    private void sortByTitle(ActionEvent e) {
        titleSortCount++;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector<Vector> data = model.getDataVector();

        data.sort((Vector v1, Vector v2) -> {
            String title1 = v1.get(4).toString();
            String title2 = v2.get(4).toString();
            return titleSortCount % 2 == 0 ? title1.compareToIgnoreCase(title2) : title2.compareToIgnoreCase(title1);
        });

        model.fireTableDataChanged();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
        contentPane = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        authorTxt = new JTextField();
        titleTxt = new JTextField();
        label3 = new JLabel();
        yearOfPublicationTxt = new JTextField();
        label4 = new JLabel();
        button1 = new JButton();
        genreJbc = new JComboBox();
        idButton = new JButton();
        authorButton = new JButton();
        yearOfPublicationButton = new JButton();
        titleButton = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("view novels");
        setIconifiable(true);
        setClosable(true);
        var contentPane2 = getContentPane();

        //======== contentPane ========
        {
            contentPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,contentPane. getBorder( )) ); contentPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //======== scrollPane1 ========
            {

                //---- table ----
                table.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, "", "", null, null},
                        {null, null, null, null, null, null},
                    },
                    new String[] {
                        "ID", "Author", "Storage number", "Year of publication", "Title", "Genre"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = table.getColumnModel();
                    cm.getColumn(0).setPreferredWidth(40);
                    cm.getColumn(1).setPreferredWidth(130);
                    cm.getColumn(2).setPreferredWidth(100);
                    cm.getColumn(3).setPreferredWidth(120);
                    cm.getColumn(4).setPreferredWidth(100);
                    cm.getColumn(5).setPreferredWidth(120);
                }
                scrollPane1.setViewportView(table);
            }

            //======== panel1 ========
            {
                panel1.setBorder(new TitledBorder("Searching conditions"));

                //---- label1 ----
                label1.setText("Title:");

                //---- label2 ----
                label2.setText("author:");

                //---- label3 ----
                label3.setText("Year:");

                //---- label4 ----
                label4.setText("Genre:");

                //---- button1 ----
                button1.setText("Search");
                button1.addActionListener(e -> onSearchPressed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(label2))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(yearOfPublicationTxt, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label4)))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addComponent(genreJbc, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(label2)
                                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(yearOfPublicationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4)
                                        .addComponent(genreJbc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(button1)))
                            .addContainerGap(10, Short.MAX_VALUE))
                );
            }

            //---- idButton ----
            idButton.setIcon(new ImageIcon(getClass().getResource("/sort icon (4) (1).png")));
            idButton.addActionListener(e -> sortOnId(e));

            //---- authorButton ----
            authorButton.setIcon(new ImageIcon(getClass().getResource("/sort icon (4) (1).png")));
            authorButton.addActionListener(e -> sortOnAuthor(e));

            //---- yearOfPublicationButton ----
            yearOfPublicationButton.setIcon(new ImageIcon(getClass().getResource("/sort icon (4) (1).png")));
            yearOfPublicationButton.addActionListener(e -> sortByYear(e));

            //---- titleButton ----
            titleButton.setIcon(new ImageIcon(getClass().getResource("/sort icon (4) (1).png")));
            titleButton.addActionListener(e -> sortByTitle(e));

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(idButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(authorButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186)
                                .addComponent(yearOfPublicationButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(titleButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)))
                        .addContainerGap(41, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(idButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(authorButton)
                            .addComponent(yearOfPublicationButton)
                            .addComponent(titleButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        fillGenreJbc();
        fillTable(new Novel());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kevin-Yichen Li
    private JPanel contentPane;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField authorTxt;
    private JTextField titleTxt;
    private JLabel label3;
    private JTextField yearOfPublicationTxt;
    private JLabel label4;
    private JButton button1;
    private JComboBox genreJbc;
    private JButton idButton;
    private JButton authorButton;
    private JButton yearOfPublicationButton;
    private JButton titleButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private DBUtil dbUtil = new DBUtil();
    private NovelDao novelDao = new NovelDao();

    /**
     * Initialize genre Jbc
     */
    private void fillGenreJbc() {
        genreJbc.addItem("Please choose...");
        genreJbc.addItem("Action");
        genreJbc.addItem("Horror");
        genreJbc.addItem("Fantasy");
        genreJbc.addItem("Science-fiction");
    }

    /**
     * Initialize the table
     * @param novel
     */
    private void fillTable(Novel novel) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet resultSet = novelDao.list(con, novel);
            while (resultSet.next()) {
                ArrayList<String> rowData = new ArrayList<>();
                rowData.add(resultSet.getString("id"));
                rowData.add(resultSet.getString("author"));
                rowData.add(resultSet.getString("storageNum"));
                rowData.add(resultSet.getString("yearOfPublication"));
                rowData.add(resultSet.getString("title"));
                rowData.add(resultSet.getString("genre"));
                defaultTableModel.addRow(rowData.toArray());
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
