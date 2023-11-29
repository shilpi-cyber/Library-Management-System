/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author SHILPI
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    public ManageBooks() {
        initComponents();
        setDataToTable();
    }
    DefaultTableModel model;
public void setDataToTable(){
    try{
        Connection con=DBConnection.getConnection();
        Statement pst=con.createStatement();
        ResultSet result=pst.executeQuery("select * from book_details");
        while(result.next()){
            int bookId=result.getInt("book_id");
            String bookName=result.getString("book_name");
            String  author=result.getString("author");
            int quantity=result.getInt("quantity");
            
            Object[] obj={bookId,bookName,author,quantity};
            model =(DefaultTableModel) table_bookdetails.getModel();
            model.addRow(obj);
        }
}
    catch(Exception e){
        e.printStackTrace();
    }
}
//to add book
 public boolean addBook(){
        int book_id=Integer.parseInt(text_bookId.getText());
        String book_name=text_bookName.getText();
        String author=text_author.getText();
        int quantity=Integer.parseInt(text_quantity.getText());
        
        boolean gotAdded=false;
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="insert into book_details values(?,?,?,?)";
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setInt(1,book_id);
            pt.setString(2,book_name);
            pt.setString(3,author);
            pt.setInt(4,quantity);
            int rowcount=pt.executeUpdate();
            if(rowcount>0){
                gotAdded=true;
//              JOptionPane.showMessageDialog(this,"New Book Added Successfully");
            }
            else{
                gotAdded=false;
//                JOptionPane.showMessageDialog(this,"Failed,Try Adding it again");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return gotAdded;
    }
  //method to clear table
 public void clearTable(){
     model=(DefaultTableModel)table_bookdetails.getModel();
     model.setRowCount(0);
     
     
 }
 //to  delete book details
 public boolean deleteBook(){
     boolean isDeleted=false;
     int book_id=Integer.parseInt(text_bookId.getText());
     try{
        Connection con=DBConnection.getConnection();
        String sql="delete from book_details where book_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,book_id);
        int rowcount=ps.executeUpdate();
         if(rowcount>0){
             isDeleted=true;
         }
         else{
             isDeleted=false;
         }
     }
     catch(Exception e){
         e.printStackTrace();
     }
     return isDeleted;
 }
 //to update book details
 public boolean updateBook(){
     int book_id=Integer.parseInt(text_bookId.getText());
        String book_name=text_bookName.getText();
        String author=text_author.getText();
        int quantity=Integer.parseInt(text_quantity.getText());
        
        boolean isUpdated=false;
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="update book_details set book_name=?,author=?,quantity=? where book_id=?";
//           String sql="update book_details values(?,?,?,?)"; 
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setString(1,book_name);
            pt.setString(2,author);
            pt.setInt(3,quantity);
            pt.setInt(4,book_id);
            int rowcount=pt.executeUpdate();
            if(rowcount>0){
                isUpdated=true;
//              JOptionPane.showMessageDialog(this,"New Book Added Successfully");
            }
            else{
                isUpdated=false;
//                JOptionPane.showMessageDialog(this,"Failed,Try Adding it again");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isUpdated;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        text_quantity = new javax.swing.JTextField();
        text_bookId = new javax.swing.JTextField();
        text_bookName = new javax.swing.JTextField();
        text_author = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_bookdetails = new rojerusan.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(228, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Book Id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 40, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Book Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 120, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Author Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 120, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantity");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 120, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));
        jPanel1.add(text_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 260, 40));
        jPanel1.add(text_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 260, 40));
        jPanel1.add(text_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 260, 40));
        jPanel1.add(text_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 260, 40));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 670, 100, 30));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 100, 30));

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 100, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 255));
        jLabel5.setText("Book Details Form");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 810));

        jPanel5.setBackground(new java.awt.Color(211, 208, 177));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pichh.jpg"))); // NOI18N
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1060, 210));

        jLabel2.setFont(new java.awt.Font("Pristina", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Book_50px_1.png"))); // NOI18N
        jLabel2.setText("Manage Books");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 300, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 20, 30));

        table_bookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Unit"
            }
        ));
        table_bookdetails.setColorBackgoundHead(new java.awt.Color(204, 0, 0));
        table_bookdetails.setColorFilasBackgound1(new java.awt.Color(255, 204, 0));
        table_bookdetails.setColorFilasForeground1(new java.awt.Color(204, 0, 0));
        table_bookdetails.setColorFilasForeground2(new java.awt.Color(204, 0, 0));
        table_bookdetails.setColorSelBackgound(new java.awt.Color(204, 0, 0));
        table_bookdetails.setRowHeight(40);
        table_bookdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookdetailsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_bookdetails);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 780, 320));

        jPanel2.setBackground(new java.awt.Color(225, 0, 0));
        jPanel2.setForeground(new java.awt.Color(225, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 370, 4));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 1060, 810));

        setSize(new java.awt.Dimension(1500, 810));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Home home =new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void table_bookdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookdetailsMouseClicked
        int rowNo=table_bookdetails.getSelectedRow();
        TableModel model= table_bookdetails.getModel();
        
        text_bookId.setText(model.getValueAt(rowNo, 0).toString());
        text_bookName.setText(model.getValueAt(rowNo, 1).toString());
        text_author.setText(model.getValueAt(rowNo, 2).toString());
        text_quantity.setText(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_table_bookdetailsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(addBook()==true){
           JOptionPane.showMessageDialog(this,"Book Added");
           clearTable();
           setDataToTable();
       }
       else{
           JOptionPane.showMessageDialog(this,"Failed, Try Adding Again");
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(updateBook()==true){
           JOptionPane.showMessageDialog(this,"Book Updated");
           clearTable();
           setDataToTable();
       }
       else{
           JOptionPane.showMessageDialog(this,"Failed, Try Updating Again");
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(deleteBook()==true){
           JOptionPane.showMessageDialog(this,"Book Deleted Successfully");
           clearTable();
           setDataToTable();
       }
       else{
           JOptionPane.showMessageDialog(this,"Failed, Try Deleting Again");
       }
    }//GEN-LAST:event_jButton1ActionPerformed
// to add books into table
//    int book_id,quantity;
//    String book_name,author;
   
    
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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private rojerusan.RSTableMetro table_bookdetails;
    private javax.swing.JTextField text_author;
    private javax.swing.JTextField text_bookId;
    private javax.swing.JTextField text_bookName;
    private javax.swing.JTextField text_quantity;
    // End of variables declaration//GEN-END:variables
}
