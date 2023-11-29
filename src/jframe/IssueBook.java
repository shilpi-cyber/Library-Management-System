/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author SHILPI
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
// to get book details from database
    public void getBookDetails(){
        int book_id = Integer.parseInt(text_bookId.getText());
        
        try{
           Connection con=DBConnection.getConnection();
           String sql="select * from book_details where book_id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1, book_id);
           ResultSet rs=pst.executeQuery();
           
           if(rs.next()){
               label_bookId.setText(rs.getString("book_id"));
               label_bookName.setText(rs.getString("book_name"));
               label_author.setText(rs.getString("author"));
               label_quantity.setText(rs.getString("quantity"));
           }
           else{
                 label_bookError.setText("Invalid Book Id Entered");  
                 JOptionPane.showMessageDialog(this,"Error ! Error ! Error !");
                   }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    // to get student details from database
    public void getStudentDetails(){
        int student_id = Integer.parseInt(text_studentId.getText());
        
        try{
           Connection con=DBConnection.getConnection();
           String sql="select * from student_details where student_id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1, student_id);
           ResultSet rs=pst.executeQuery();
           
           if(rs.next()){
               label_studentId.setText(rs.getString("student_id"));
               label_studentName.setText(rs.getString("student_name"));
               label_course.setText(rs.getString("course"));
               label_branch.setText(rs.getString("branch"));
           }
           else{
                   label_studentError.setText("Invalid Student Id Entered"); 
                   JOptionPane.showMessageDialog(this,"Error ! Error ! Error !");
                   }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    // insert issue book details to database
    public boolean issueBook(){
                boolean isIssued=false;

        int bookId = Integer.parseInt(text_bookId.getText());
        int studentId = Integer.parseInt(text_studentId.getText());
        String bookName= label_bookName.getText();
        String studentName=label_studentName.getText();
        Date issueDate=text_issueDate.getDatoFecha();
        Date dueDate=text_dueDate.getDatoFecha();
        
        Long date1=issueDate.getTime();
        Long date2=dueDate.getTime();
        
        java.sql.Date fissueDate= new java.sql.Date(date1);
        java.sql.Date fdueDate= new java.sql.Date(date2);
        
//        boolean isIssued=false;
        try{
            Connection con=DBConnection.getConnection();
            String sql="insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookName);
            pst.setInt(3,studentId);
            pst.setString(4,studentName);
            pst.setDate(5, fissueDate);
            pst.setDate(6, fdueDate);
            pst.setString(7,"pending");
            
            int rowcount=pst.executeUpdate();
            if(rowcount>0){
                isIssued=true;
                
            }
            else{
                isIssued=false;
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       return isIssued; 
        
    }
    //updating of quantity of book 
    
    public void updateQuantity(){
//        boolean isDecremented=false;
        int bookId = Integer.parseInt(text_bookId.getText());
        
        try {
            Connection con=DBConnection.getConnection();
            String sql="update book_details set quantity=quantity-1 where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int count=pst.executeUpdate();
            if(count>0){
//                isDecremented=true;
               JOptionPane.showMessageDialog(this,"Data Updated");
               int iquantity=Integer.parseInt(label_quantity.getText());
               label_quantity.setText(Integer.toString(iquantity-1));
            }
            else{
                JOptionPane.showMessageDialog(this,"Data not Updated, Sorry for the inconvenience");
//                isDecremented=false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
//        return isDecremented;
    }
    //checking double booking
    public boolean doubleBooking(){
        boolean isPresent=false;
        int bookId=Integer.parseInt(text_bookId.getText());
        int studentId=Integer.parseInt(text_studentId.getText());
        try{
           Connection con=DBConnection.getConnection();
           String sql="select * from issue_book_details where book_id=? and student_id=? and status=?";
           PreparedStatement pst= con.prepareStatement(sql);
           pst.setInt(1,bookId);
           pst.setInt(2,studentId);
           pst.setString(3, "pending");
           ResultSet res=pst.executeQuery();
           if(res.next()){
               isPresent=true;
//               JOptionPane.showMessageDialog(this,"Sorry Can't Issue this Book, Already Issued in your Name");
           }
           else{
               isPresent=false;
           }
        }
        
        catch(Exception e){
           e.printStackTrace();
        }
        return isPresent;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        label_bookId = new javax.swing.JLabel();
        label_bookName = new javax.swing.JLabel();
        label_author = new javax.swing.JLabel();
        text_quantity = new javax.swing.JLabel();
        label_quantity = new javax.swing.JLabel();
        label_bookError = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_studentId = new javax.swing.JLabel();
        label_branch = new javax.swing.JLabel();
        label_course = new javax.swing.JLabel();
        label_studentName = new javax.swing.JLabel();
        label_studentError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        text_bookId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        text_studentId = new javax.swing.JTextField();
        text_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        text_dueDate = new rojeru_san.componentes.RSDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 40, 50));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book Name :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 90, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Author :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 60, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel23.setText("  Book Details ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 280, 100));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Book Id :");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 60, 30));

        label_bookId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 210, 30));

        label_bookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 210, 30));

        label_author.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 210, 30));

        text_quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_quantity.setForeground(new java.awt.Color(255, 255, 255));
        text_quantity.setText("Quantity :");
        jPanel2.add(text_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 70, 30));

        label_quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(label_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 210, 30));

        label_bookError.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel2.add(label_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 230, 60));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 800));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student Id :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 80, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 40, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student Name :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 100, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Course :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 60, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Branch :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 60, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel5.setText("Student Details");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 300, 100));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 40, 50));

        label_studentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 210, 30));

        label_branch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 210, 30));

        label_course.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 210, 30));

        label_studentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 210, 30));

        label_studentError.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(label_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 230, 60));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bali2.jpg"))); // NOI18N
        jLabel4.setText("jLabel1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 630, 500, 170));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 440, 800));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 0, 30, 40));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText(" Issue Book");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 70, 260, 60));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 0));
        jLabel14.setText("Book Id :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, 90, 30));

        text_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 0)));
        text_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_bookIdFocusLost(evt);
            }
        });
        text_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_bookIdActionPerformed(evt);
            }
        });
        jPanel3.add(text_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, 340, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 0));
        jLabel15.setText("Issue Date :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 410, 110, 30));

        text_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 0)));
        text_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_studentIdFocusLost(evt);
            }
        });
        text_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_studentIdActionPerformed(evt);
            }
        });
        jPanel3.add(text_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 310, 340, 40));

        text_issueDate.setColorBackground(new java.awt.Color(255, 51, 0));
        text_issueDate.setColorButtonHover(new java.awt.Color(255, 51, 0));
        text_issueDate.setColorForeground(new java.awt.Color(255, 51, 0));
        text_issueDate.setPlaceholder("");
        jPanel3.add(text_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 400, 370, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 0));
        jLabel26.setText("Student Id :");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 320, 110, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 51, 0));
        jLabel27.setText("Due Date :");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 500, 110, 30));

        text_dueDate.setColorBackground(new java.awt.Color(255, 51, 0));
        text_dueDate.setColorButtonHover(new java.awt.Color(255, 51, 0));
        text_dueDate.setColorForeground(new java.awt.Color(255, 51, 0));
        text_dueDate.setPlaceholder("");
        jPanel3.add(text_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 490, 370, -1));

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Issue Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 590, 180, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 800));

        setSize(new java.awt.Dimension(1500, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Home home=new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void text_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_bookIdActionPerformed

    private void text_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_studentIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(label_quantity.getText().equals("0")){
           JOptionPane.showMessageDialog(this,"Book not Available"); 
        }
        else{
        if(doubleBooking()==false){
        if(issueBook()==true){
            JOptionPane.showMessageDialog(this,"Book issued Successfully");
            updateQuantity();
        }
        else{
            JOptionPane.showMessageDialog(this,"Error, Please Try again");
        }
        }
        else{
           JOptionPane.showMessageDialog(this,"Sorry, Book already issued by your name"); 
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_bookIdFocusLost
        if(!text_bookId.getText().equals(""))
        {
            getBookDetails();
        }
    }//GEN-LAST:event_text_bookIdFocusLost

    private void text_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_studentIdFocusLost
        if(!text_studentId.getText().equals(""))
        {
            getStudentDetails();
        }
    }//GEN-LAST:event_text_studentIdFocusLost

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label_author;
    private javax.swing.JLabel label_bookError;
    private javax.swing.JLabel label_bookId;
    private javax.swing.JLabel label_bookName;
    private javax.swing.JLabel label_branch;
    private javax.swing.JLabel label_course;
    private javax.swing.JLabel label_quantity;
    private javax.swing.JLabel label_studentError;
    private javax.swing.JLabel label_studentId;
    private javax.swing.JLabel label_studentName;
    private javax.swing.JTextField text_bookId;
    private rojeru_san.componentes.RSDateChooser text_dueDate;
    private rojeru_san.componentes.RSDateChooser text_issueDate;
    private javax.swing.JLabel text_quantity;
    private javax.swing.JTextField text_studentId;
    // End of variables declaration//GEN-END:variables
}
