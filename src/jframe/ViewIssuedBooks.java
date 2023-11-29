/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author SHILPI
 */
public class ViewIssuedBooks extends javax.swing.JFrame {

    /**
     * Creates new form ViewIssuedBooks
     */
    public ViewIssuedBooks() {
        initComponents();
        viewIssuedRecordsToTable();
        showPieChart();
    }
DefaultTableModel model;
public void viewIssuedRecordsToTable(){
    try{
        Connection con=DBConnection.getConnection();
        Statement pst=con.createStatement();
        ResultSet result=pst.executeQuery("select * from issue_book_details where status='"+"pending"+"'  ");
        
        while(result.next()){
//            int Id=result.getInt("id");
            int bookId=result.getInt("book_id");
            int studentId=result.getInt("student_id");
            String bookName=result.getString("book_name");
            String studentName=result.getString("student_name");
            Date issueDate=result.getDate("issue_date");
            Date dueDate=result.getDate("due_date");
            String status=result.getString("status");
            
            Object[] obj={bookId,bookName,studentId,studentName,issueDate,dueDate,status};
            model =(DefaultTableModel) table_issuedBookRecords.getModel();
            model.addRow(obj);
        }
}
    catch(Exception e){
        e.printStackTrace();
    }
}

public void clearTable(){
     model=(DefaultTableModel)table_issuedBookRecords.getModel();
     model.setRowCount(0);
     
     
 }

public void showPieChart(){
        
        //create dataset
     DefaultPieDataset pieDataset = new DefaultPieDataset();
//    pieDataset.setValue("One", Double.valueOf(10));
//    pieDataset.setValue("Two", Double.valueOf(20));
//    pieDataset.setValue("Three", Double.valueOf(30));
//    pieDataset.setValue("Four", Double.valueOf(10));
//    pieDataset.setValue("Five", Double.valueOf(20));
//    pieDataset.setValue("Six", Double.valueOf(10));
    
try{
   Connection con=DBConnection.getConnection();
   String sql="select book_name ,count(*) as issue_count from issue_book_details group by book_id";
   Statement st=con.createStatement();
   ResultSet res=st.executeQuery(sql);
   while(res.next()){
       pieDataset.setValue(res.getString("book_name"), Double.valueOf(res.getDouble("issue_count")));
   }
}
catch(Exception e){
    e.printStackTrace();
}
    
    
    JFreeChart chart;
        chart = ChartFactory.createPieChart(
                "Issued Books Pie Chart", pieDataset, true , true, true);
      
      
        PiePlot piePlot =(PiePlot) chart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("One", new Color(255,255,102));
        piePlot.setSectionPaint("Two", new Color(102,255,102));
        piePlot.setSectionPaint("Three", new Color(255,102,153));
        piePlot.setSectionPaint("Four", new Color(206,13,204));
        piePlot.setSectionPaint("Five", new Color(9,24,204));
        piePlot.setSectionPaint("Six", new Color(89,245,204));
      
       
    piePlot.setBackgroundPaint(Color.white);
    piePlot.setLabelBackgroundPaint(null);
    piePlot.setLabelOutlinePaint(null);
    piePlot.setLabelShadowPaint(null);
    Font font = new Font(chart.getLegend().getItemFont().getFamily(), Font.BOLD ,12);
    piePlot.setLabelFont(font);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(chart);
        PanelPieChart.removeAll();
        PanelPieChart.add(barChartPanel, BorderLayout.CENTER);
        PanelPieChart.validate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_issuedBookRecords = new rojerusan.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(204, 204, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel20.setText("Back");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        table_issuedBookRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Student Id", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        table_issuedBookRecords.setColorBackgoundHead(new java.awt.Color(255, 51, 0));
        table_issuedBookRecords.setColorFilasForeground1(new java.awt.Color(255, 51, 51));
        table_issuedBookRecords.setColorFilasForeground2(new java.awt.Color(255, 51, 0));
        table_issuedBookRecords.setColorSelBackgound(new java.awt.Color(255, 51, 0));
        table_issuedBookRecords.setRowHeight(40);
        table_issuedBookRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_issuedBookRecordsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_issuedBookRecords);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 1080, 250));

        jPanel2.setBackground(new java.awt.Color(225, 0, 0));
        jPanel2.setForeground(new java.awt.Color(225, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 164, 470, 5));

        jLabel2.setFont(new java.awt.Font("Pristina", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Edit_Property_50px.png"))); // NOI18N
        jLabel2.setText("Issued  Books Record");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 400, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 0, 30, 40));

        PanelPieChart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelPieChartMouseClicked(evt);
            }
        });
        PanelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel1.add(PanelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 360, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 800));

        setSize(new java.awt.Dimension(1500, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        Home home=new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void table_issuedBookRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_issuedBookRecordsMouseClicked

    }//GEN-LAST:event_table_issuedBookRecordsMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void PanelPieChartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPieChartMouseClicked
        ViewIssuedBooks dodo = new ViewIssuedBooks();
        dodo.setVisible(true);
        dispose();
    }//GEN-LAST:event_PanelPieChartMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIssuedBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPieChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private rojerusan.RSTableMetro table_issuedBookRecords;
    // End of variables declaration//GEN-END:variables
}
