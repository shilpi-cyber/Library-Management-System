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
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        showPieChart1();
        showPieChart();
        clearStudentTable();
        setDataToStudentTable();
        clearBookTable();
        setDataToBooksTable();
        setDataToFirstCard();
        setDataToSecondCard();
        setDataToThirdCard();
        setDataToFourthCard();
    }
public void showPieChart1(){
        
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
   String sql="select book_name ,count(*) as quantity_count from book_details group by book_id";
   Statement st=con.createStatement();
   ResultSet res=st.executeQuery(sql);
   while(res.next()){
       pieDataset.setValue(res.getString("book_name"), Double.valueOf(res.getDouble("quantity_count")));
   }
}
catch(Exception e){
    e.printStackTrace();
}
    
    
    JFreeChart chart;
        chart = ChartFactory.createPieChart(
                "Books Quantity Pie Chart", pieDataset, true , true, true);
      
      
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
        PanelPieChart1.removeAll();
        PanelPieChart1.add(barChartPanel, BorderLayout.CENTER);
        PanelPieChart1.validate();
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
DefaultTableModel model;
Color enter= new Color(0,0,0);
Color managebook = new Color(0,204,102);
Color managestudent= new Color(255,102,102);
Color issuebook= new Color(0,153,153);
Color returnbook= new Color(204,204,0);
Color viewrecords= new Color(153,0,153);
Color viewissuedbook= new Color(102,51,0);
Color defaulter= new Color(255,204,102);
Color exit=new Color(51,51,51);
Color a1= new Color(0,255,0);
Color a2=new Color(0,0,0);
public void clearStudentTable(){
     model=(DefaultTableModel)table_studentsDetails.getModel();
     model.setRowCount(0);
     
     
 }
public void clearBookTable(){
     model=(DefaultTableModel)table_bookDetails.getModel();
     model.setRowCount(0);
     
     
 }

public void setDataToStudentTable(){
    try{
        Connection con=DBConnection.getConnection();
        Statement pst=con.createStatement();
        ResultSet result=pst.executeQuery("select * from student_details");
        while(result.next()){
            int studentId=result.getInt("student_id");
            String studentName=result.getString("student_name");
            String  course=result.getString("course");
            String branch=result.getString("branch");
            
            Object[] obj={studentId,studentName,course,branch};
            model =(DefaultTableModel) table_studentsDetails.getModel();
            model.addRow(obj);
        }
}
    catch(Exception e){
        e.printStackTrace();
    }
}

public void setDataToBooksTable(){
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
            model =(DefaultTableModel) table_bookDetails.getModel();
            model.addRow(obj);
        }
}
    catch(Exception e){
        e.printStackTrace();
    }
}

// set data to side panel
public void setDataToFirstCard(){
    Statement state=null;
    ResultSet res=null;
    int count1=0;
    
    try{
       Connection con=DBConnection.getConnection();
       state =con.createStatement();
//       String sql="select * from book_details";
       res=state.executeQuery("select * from book_details");
       while(res.next()){
           count1++;
       }
       
       label_books.setText(Integer.toString(count1));
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
public void setDataToSecondCard(){
    Statement state=null;
    ResultSet res=null;
    int count1=0;
    try{
       Connection con=DBConnection.getConnection();
       state =con.createStatement();
//       String sql="select * from book_details";
       res=state.executeQuery("select * from student_details");
       while(res.next()){
           count1++;
       }
       
       label_students.setText(Integer.toString(count1));
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
public void setDataToThirdCard(){
    Statement state=null;
    ResultSet res=null;
    int count1=0;
    
    try{
       Connection con=DBConnection.getConnection();
       state =con.createStatement();
//       String sql="select * from book_details";
       res=state.executeQuery("select * from issue_book_details");
       while(res.next()){
           count1++;
       }
       
       label_issuedBooks.setText(Integer.toString(count1));
    }
    catch(Exception e){
        e.printStackTrace();
    }
}

public void setDataToFourthCard(){
    Statement state=null;
    ResultSet res=null;
    int count1=0;
    long currentMillis = System.currentTimeMillis();
    Date date = new Date(currentMillis);
    Long d1=date.getTime();
    java.sql.Date fdate=new java.sql.Date(d1);
    
    try{
       Connection con=DBConnection.getConnection();
       state =con.createStatement();
//       String sql="select * from book_details";
       res=state.executeQuery("select * from issue_book_details where due_date < '"+fdate+"' and status= '"+"pending"+"' ");
       while(res.next()){
           count1++;
       }
       
       label_defaulters.setText(Integer.toString(count1));
    }
    catch(Exception e){
        e.printStackTrace();
    }
}

//Color a1= new Color(253,256,345);
//Color a2=new Color(0,0,0);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        DefaulterPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ManageBookPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        ManageStudentsPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        IssueBookPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        ReturnBookPanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        ViewRecordsPanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        ViewIssuedBooksPanel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        label_defaulters = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        label_books = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        label_students = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        label_issuedBooks = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_studentsDetails = new rojerusan.RSTableMetro();
        PanelPieChart = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_bookDetails = new rojerusan.RSTableMetro();
        PanelPieChart1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 0, 20, -1));

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel5.setText("Welcome, Admin");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 180, -1));

        jLabel39.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Library Management System");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 270, 60));

        jLabel40.setBackground(new java.awt.Color(51, 51, 51));
        jLabel40.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px.png"))); // NOI18N
        jLabel40.setText("  Logout");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 10, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 70));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Features");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 60));

        jPanel12.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 60));

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel11.setText("  Home");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 110, 60));

        jPanel12.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        DefaulterPanel.setBackground(new java.awt.Color(255, 204, 102));
        DefaulterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(204, 204, 0));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel12.setText(" Defaulter List");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        DefaulterPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 190, 30));

        jPanel9.setBackground(new java.awt.Color(0, 204, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(204, 204, 0));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel15.setText(" ManageBooks");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        DefaulterPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 60));

        jPanel12.add(DefaulterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 340, 50));

        jPanel8.setBackground(new java.awt.Color(204, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel14.setText(" LMS Dashboard");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        jPanel12.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 340, 60));

        ManageBookPanel.setBackground(new java.awt.Color(0, 204, 102));
        ManageBookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(204, 204, 0));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel16.setText(" Manage Books");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        ManageBookPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 190, 30));

        jPanel11.setBackground(new java.awt.Color(0, 204, 102));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(204, 204, 0));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel17.setText(" ManageBooks");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        ManageBookPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 60));

        jPanel12.add(ManageBookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 50));

        ManageStudentsPanel.setBackground(new java.awt.Color(255, 102, 102));
        ManageStudentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(204, 204, 0));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel18.setText(" Manage Students");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        ManageStudentsPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 190, 30));

        jPanel14.setBackground(new java.awt.Color(0, 204, 102));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(204, 204, 0));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel19.setText(" ManageBooks");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        ManageStudentsPanel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 60));

        jPanel12.add(ManageStudentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 340, 50));

        IssueBookPanel.setBackground(new java.awt.Color(0, 153, 153));
        IssueBookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(204, 204, 0));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel20.setText(" Issue Book");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
        IssueBookPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 190, 30));

        jPanel16.setBackground(new java.awt.Color(0, 204, 102));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(204, 204, 0));
        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel21.setText(" ManageBooks");
        jPanel16.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        IssueBookPanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 60));

        jPanel12.add(IssueBookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 340, 50));

        ReturnBookPanel.setBackground(new java.awt.Color(204, 204, 0));
        ReturnBookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(204, 204, 0));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel22.setText(" Return Book");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        ReturnBookPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 190, 30));

        jPanel18.setBackground(new java.awt.Color(0, 204, 102));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(204, 204, 0));
        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel23.setText(" ManageBooks");
        jPanel18.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        ReturnBookPanel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 60));

        jPanel12.add(ReturnBookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 340, 50));

        ViewRecordsPanel.setBackground(new java.awt.Color(153, 0, 153));
        ViewRecordsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(204, 204, 0));
        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel24.setText(" View Records");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        ViewRecordsPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 190, 30));

        jPanel20.setBackground(new java.awt.Color(0, 204, 102));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(204, 204, 0));
        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel25.setText(" ManageBooks");
        jPanel20.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        ViewRecordsPanel.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 60));

        jPanel12.add(ViewRecordsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 340, 50));

        ViewIssuedBooksPanel.setBackground(new java.awt.Color(102, 51, 0));
        ViewIssuedBooksPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(204, 204, 0));
        jLabel26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel26.setText(" View Issued Books");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });
        ViewIssuedBooksPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 210, 30));

        jPanel22.setBackground(new java.awt.Color(0, 204, 102));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(204, 204, 0));
        jLabel27.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel27.setText(" ManageBooks");
        jPanel22.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 60));

        ViewIssuedBooksPanel.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 340, 60));

        jPanel12.add(ViewIssuedBooksPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 340, 50));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 760));

        jPanel4.setBackground(new java.awt.Color(255, 245, 243));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(0, 0, 0));
        jPanel23.setPreferredSize(new java.awt.Dimension(190, 100));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        jLabel6.setText(" No. of Defaulters");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, -1));

        label_defaulters.setBackground(new java.awt.Color(204, 204, 204));
        label_defaulters.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_defaulters.setForeground(new java.awt.Color(153, 153, 153));
        label_defaulters.setText("10");
        jPanel7.add(label_defaulters, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jPanel27.setBackground(new java.awt.Color(0, 0, 0));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel13.setText(" No. of Books");
        jPanel27.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, -1));

        jLabel35.setBackground(new java.awt.Color(204, 204, 204));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("10");
        jPanel27.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jPanel7.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 100));

        jPanel23.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 200, 110));

        jPanel24.setBackground(new java.awt.Color(0, 0, 0));
        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel24MouseExited(evt);
            }
        });
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel7.setText(" No. of Books");
        jPanel24.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));

        label_books.setBackground(new java.awt.Color(204, 204, 204));
        label_books.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_books.setForeground(new java.awt.Color(153, 153, 153));
        label_books.setText("10");
        jPanel24.add(label_books, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 100));

        jPanel25.setBackground(new java.awt.Color(0, 0, 0));
        jPanel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel25MouseExited(evt);
            }
        });
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        jLabel8.setText(" No. of Students");
        jPanel25.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        label_students.setBackground(new java.awt.Color(204, 204, 204));
        label_students.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_students.setForeground(new java.awt.Color(153, 153, 153));
        label_students.setText("10");
        jPanel25.add(label_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jPanel23.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 200, 100));

        jPanel28.setBackground(new java.awt.Color(0, 0, 0));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel28MouseExited(evt);
            }
        });
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(204, 204, 204));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel28.setText(" No. of Issued Books");
        jPanel28.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 50));

        label_issuedBooks.setBackground(new java.awt.Color(204, 204, 204));
        label_issuedBooks.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_issuedBooks.setForeground(new java.awt.Color(153, 153, 153));
        label_issuedBooks.setText("10");
        jPanel28.add(label_issuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jPanel29.setBackground(new java.awt.Color(0, 0, 0));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(204, 204, 204));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel29.setText(" No. of Books");
        jPanel29.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, -1));

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 153, 153));
        jLabel37.setText("10");
        jPanel29.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 100));

        jPanel23.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 200, 100));

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setBackground(new java.awt.Color(51, 51, 51));
        jLabel41.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/search (1).png"))); // NOI18N
        jLabel41.setText("  Search By Students Details ");
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 170, 20));

        jPanel23.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 20));

        jPanel4.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 235, 740));

        jLabel30.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel30.setText("Student Details");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 150, 30));

        jLabel38.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel38.setText("Details of Books");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel38MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel38MouseExited(evt);
            }
        });
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 150, 30));

        table_studentsDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo.", "Name", "Branch", "Student ID"
            }
        ));
        table_studentsDetails.setColorBackgoundHead(new java.awt.Color(204, 0, 0));
        table_studentsDetails.setColorFilasForeground1(new java.awt.Color(204, 0, 0));
        table_studentsDetails.setColorFilasForeground2(new java.awt.Color(204, 0, 0));
        table_studentsDetails.setColorSelBackgound(new java.awt.Color(204, 0, 0));
        table_studentsDetails.setRowHeight(40);
        table_studentsDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_studentsDetailsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_studentsDetails);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 430, 220));

        PanelPieChart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelPieChartMouseClicked(evt);
            }
        });
        PanelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel4.add(PanelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 380, 310));

        table_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Quantity"
            }
        ));
        table_bookDetails.setColorBackgoundHead(new java.awt.Color(204, 0, 0));
        table_bookDetails.setColorFilasForeground1(new java.awt.Color(204, 0, 0));
        table_bookDetails.setColorFilasForeground2(new java.awt.Color(204, 0, 0));
        table_bookDetails.setColorSelBackgound(new java.awt.Color(204, 0, 0));
        table_bookDetails.setRowHeight(40);
        table_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_bookDetails);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 480, 220));

        PanelPieChart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelPieChart1MouseClicked(evt);
            }
        });
        PanelPieChart1.setLayout(new java.awt.BorderLayout());
        jPanel4.add(PanelPieChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 380, 310));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1180, 760));

        setSize(new java.awt.Dimension(1525, 825));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        ManageBooks temp=new ManageBooks();
        temp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked
    
    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        ManageBookPanel.setBackground(enter);
       
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
         ManageBookPanel.setBackground(managebook);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        ManageStudentsPanel.setBackground(enter);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        ManageStudentsPanel.setBackground(managestudent);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
       IssueBookPanel.setBackground(enter);
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        IssueBookPanel.setBackground(issuebook);
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        ReturnBookPanel.setBackground(enter);
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        ReturnBookPanel.setBackground(returnbook);
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        ViewRecordsPanel.setBackground(enter);
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        ViewRecordsPanel.setBackground(viewrecords);
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        ViewIssuedBooksPanel.setBackground(enter);
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        ViewIssuedBooksPanel.setBackground(viewissuedbook);
    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        DefaulterPanel.setBackground(enter);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        DefaulterPanel.setBackground(defaulter);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jPanel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseEntered
        jPanel24.setBackground(exit);
    }//GEN-LAST:event_jPanel24MouseEntered

    private void jPanel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseExited
        jPanel24.setBackground(enter);
    }//GEN-LAST:event_jPanel24MouseExited

    private void jPanel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseEntered
        jPanel25.setBackground(exit);
    }//GEN-LAST:event_jPanel25MouseEntered

    private void jPanel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseExited
        jPanel25.setBackground(enter);
    }//GEN-LAST:event_jPanel25MouseExited

    private void jPanel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseEntered
        jPanel28.setBackground(exit);
    }//GEN-LAST:event_jPanel28MouseEntered

    private void jPanel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseExited
        jPanel28.setBackground(enter);
    }//GEN-LAST:event_jPanel28MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        jPanel7.setBackground(exit);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        jPanel7.setBackground(enter);
    }//GEN-LAST:event_jPanel7MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        ManageStudents mngstd = new ManageStudents();
        mngstd.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        IssueBook issue = new IssueBook();
        issue.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        ReturnBook rtrn = new ReturnBook();
        rtrn.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        ViewRecords records=new ViewRecords();
        records.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        ViewIssuedBooks issuedrecords=new ViewIssuedBooks();
        issuedrecords.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        DefaulterList defaulters=new DefaulterList();
        defaulters.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
       Search search =new Search();
       search.setVisible(true);
       dispose();
               
    }//GEN-LAST:event_jLabel41MouseClicked

    private void PanelPieChartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPieChartMouseClicked
        ViewIssuedBooks dodo = new ViewIssuedBooks();
        dodo.setVisible(true);
        dispose();
    }//GEN-LAST:event_PanelPieChartMouseClicked

    private void PanelPieChart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPieChart1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelPieChart1MouseClicked

    private void table_studentsDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_studentsDetailsMouseClicked
        ManageStudents mana= new ManageStudents();
        mana.setVisible(true);
        dispose();
    }//GEN-LAST:event_table_studentsDetailsMouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        ManageStudents mana= new ManageStudents();
        mana.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
       ManageBooks mana= new ManageBooks();
        mana.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel38MouseClicked

    private void table_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookDetailsMouseClicked
        ManageBooks mana= new ManageBooks();
        mana.setVisible(true);
        dispose();
    }//GEN-LAST:event_table_bookDetailsMouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
       jLabel30.setForeground(a1);
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        jLabel30.setForeground(a2);
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseEntered
        jLabel38.setForeground(a1);
    }//GEN-LAST:event_jLabel38MouseEntered

    private void jLabel38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseExited
        jLabel38.setForeground(a2);
    }//GEN-LAST:event_jLabel38MouseExited

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DefaulterPanel;
    private javax.swing.JPanel IssueBookPanel;
    private javax.swing.JPanel ManageBookPanel;
    private javax.swing.JPanel ManageStudentsPanel;
    private javax.swing.JPanel PanelPieChart;
    private javax.swing.JPanel PanelPieChart1;
    private javax.swing.JPanel ReturnBookPanel;
    private javax.swing.JPanel ViewIssuedBooksPanel;
    private javax.swing.JPanel ViewRecordsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label_books;
    private javax.swing.JLabel label_defaulters;
    private javax.swing.JLabel label_issuedBooks;
    private javax.swing.JLabel label_students;
    private rojerusan.RSTableMetro table_bookDetails;
    private rojerusan.RSTableMetro table_studentsDetails;
    // End of variables declaration//GEN-END:variables
}
