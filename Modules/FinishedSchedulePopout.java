/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentplanner;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static studentplanner.StudentPlanner.DB_URL;

/**
 *
 * @author User
 */
public class SchedulePopout extends javax.swing.JFrame {
    
   //Setting up variables
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/schedule";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    
    /**
     * Creates new form SchedulePopout
     */
    public SchedulePopout() {
        initComponents();
    }
    public void SetTable1(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                            Calendar calendar = Calendar.getInstance();
                            Date date = calendar.getTime();
                            
                            String dayNow = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
                            dayNow.toLowerCase();
                            
                            jTable1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
                            DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(
                                new String [] {
                                    "Time"
                                }, 0
                            ) {
                                boolean[] canEdit = new boolean [] {
                                    false, false
                                };

                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return canEdit [columnIndex];
                                }
                            };
                                
                            for (int counter = 1; counter <= 13; counter++) {
                                try {
                                    Statement Time = conn.createStatement();
                                    String getTime = "SELECT * FROM `"+ jComboBox1.getSelectedItem().toString() +"` Where Counter = '"+(counter)+"'";
                                    ResultSet resultSet = Time.executeQuery(getTime);
                                    
                                    if(resultSet.next()) { 
                                        model1.addRow(new Object[]{ resultSet.getString("Time") }
                                        );
                                    }
                                    resultSet.close();
                                }catch(Exception ex){
                                    
                                }
                                
                           }
                    jTable1.setModel(model1);
                           
                    conn.close();
                    jTable1.setRowHeight(39);
                    jScrollPane1.setViewportView(jTable1);
                //}  
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
    }    
    
    
    
    public void SetTable2(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                //rs = stmt.executeQuery("SELECT * FROM monday ");
                            Calendar calendar = Calendar.getInstance();
                            Date date = calendar.getTime();
                            
                            String dayNow = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
                            dayNow.toLowerCase();
                            
                            jTable2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
                            DefaultTableModel model2 = new javax.swing.table.DefaultTableModel(
                                new String [] {
                                    "Time"
                                }, 0
                            ) {
                                boolean[] canEdit = new boolean [] {
                                    false, false
                                };

                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return canEdit [columnIndex];
                                }
                            };
                                
                            for (int counter = 14; counter <= 26; counter++) {
                                try {
                                    Statement Time = conn.createStatement();
                                    String getTime = "SELECT * FROM `"+ jComboBox1.getSelectedItem().toString() +"` Where Counter = '"+(counter)+"'";
                                    ResultSet resultSet = Time.executeQuery(getTime);
                                    
                                    if(resultSet.next()) { 
                                        model2.addRow(new Object[]{ resultSet.getString("Time") }
                                        );
                                    }
                                    resultSet.close();
                                }catch(Exception ex){
                                    
                                }
                                
                           }
                    jTable2.setModel(model2);    
                    conn.close();
                    jTable2.setRowHeight(39);
                    jScrollPane2.setViewportView(jTable2);
                    
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
            
    }
    
    public void setValuesTextfield(){
        String[] Subjects = new String[26];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            
            for (int counter = 1; counter <= 26; counter++) {
                try {
                                    Statement Time = conn.createStatement();
                                    String getTime = "SELECT * FROM `"+ jComboBox1.getSelectedItem().toString() +"` Where Counter = '"+(counter)+"'";
                                    //String getTime = "SELECT * FROM tuesday Where Counter = '"+(counter)+"'";
                                    ResultSet resultSet = Time.executeQuery(getTime);
                                    
                                    if(resultSet.next()) {
                                        //JOptionPane.showMessageDialog(null, resultSet.getString("Subject"));
                                        Subjects[counter] = resultSet.getString("Schedule");
                                        switch(counter){
                                            case 1:
                                                textField1.setText(Subjects[counter]);
                                                break;
                                            case 2:
                                                textField2.setText(Subjects[counter]);
                                                break;
                                            case 3:
                                                textField3.setText(Subjects[counter]);
                                                break;
                                            case 4:
                                                textField4.setText(Subjects[counter]);
                                                break;
                                            case 5:
                                                textField5.setText(Subjects[counter]);
                                                break;
                                            case 6:
                                                textField6.setText(Subjects[counter]);
                                                break;
                                            case 7:
                                                textField7.setText(Subjects[counter]);
                                                break;
                                            case 8:
                                                textField8.setText(Subjects[counter]);
                                                break;
                                            case 9:
                                                textField9.setText(Subjects[counter]);
                                                break;
                                            case 10:
                                                textField10.setText(Subjects[counter]);
                                                break;
                                            case 11:
                                                textField11.setText(Subjects[counter]);
                                                break;
                                            case 12:
                                                textField12.setText(Subjects[counter]);
                                                break;
                                            case 13:
                                                textField13.setText(Subjects[counter]);
                                                break;
                                            case 14:
                                                textField14.setText(Subjects[counter]);
                                                break;
                                            case 15:
                                                textField15.setText(Subjects[counter]);
                                                break;
                                            case 16:
                                                textField16.setText(Subjects[counter]);
                                                break;
                                            case 17:
                                                textField17.setText(Subjects[counter]);
                                                break;
                                            case 18:
                                                textField18.setText(Subjects[counter]);
                                                break;
                                            case 19:
                                                textField19.setText(Subjects[counter]);
                                                break;
                                            case 20:
                                                textField20.setText(Subjects[counter]);
                                                break;
                                            case 21:
                                                textField21.setText(Subjects[counter]);
                                                break;
                                            case 22:
                                                textField22.setText(Subjects[counter]);
                                                break;
                                            case 23:
                                                textField23.setText(Subjects[counter]);
                                                break;
                                            case 24:
                                                textField24.setText(Subjects[counter]);
                                                break;
                                            case 25:
                                                textField25.setText(Subjects[counter]);
                                                break;
                                            case 26:
                                                textField26.setText(Subjects[counter]);
                                                break;
                                                
                                            default: 
                                                break;
                                            
                                        }
                                        
                                        
                                    }
                                    //resultSet.close();
                                    //conn.close();
                }catch(Exception ex){
                    
                }
            }
            conn.close();
        }catch(Exception ex){
                    
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        dayLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        subjectLabel = new javax.swing.JLabel();
        textField1 = new javax.swing.JTextField();
        textField2 = new javax.swing.JTextField();
        textField3 = new javax.swing.JTextField();
        textField4 = new javax.swing.JTextField();
        textField5 = new javax.swing.JTextField();
        textField6 = new javax.swing.JTextField();
        textField7 = new javax.swing.JTextField();
        textField8 = new javax.swing.JTextField();
        textField9 = new javax.swing.JTextField();
        textField10 = new javax.swing.JTextField();
        textField11 = new javax.swing.JTextField();
        textField12 = new javax.swing.JTextField();
        textField13 = new javax.swing.JTextField();
        textField14 = new javax.swing.JTextField();
        textField15 = new javax.swing.JTextField();
        textField16 = new javax.swing.JTextField();
        textField17 = new javax.swing.JTextField();
        textField18 = new javax.swing.JTextField();
        textField19 = new javax.swing.JTextField();
        textField20 = new javax.swing.JTextField();
        textField21 = new javax.swing.JTextField();
        textField22 = new javax.swing.JTextField();
        textField23 = new javax.swing.JTextField();
        textField24 = new javax.swing.JTextField();
        textField25 = new javax.swing.JTextField();
        textField26 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        subjectLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        dayLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        dayLabel.setText("DAY");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { 
            "Monday", 
            "Tuesday", 
            "Wednesday", 
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        }
        ));
        
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        
        SetTable1();
        SetTable2();
        setValuesTextfield();
        
        subjectLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        subjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subjectLabel.setText("Subject");
        
        
        subjectLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        subjectLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subjectLabel1.setText("Subject");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(subjectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField14, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField15, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField16, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField17, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField18, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField19, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField20, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField21, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField22, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField23, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField24, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField25, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField26, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
            .addGroup(layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subjectLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(textField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(textField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowanceButtonActionPerformed
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Save",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                
                            //yes option
                            // Getting of values from JTextfields
                            String[] Values = new String[26];
                                for (int counter = 0; counter <= 25; counter++) {
                                        switch(counter+1){
                                            case 1:
                                                Values[counter] = textField1.getText();
                                                break;
                                            case 2:
                                                Values[counter] = textField2.getText();
                                                break;
                                            case 3:
                                                Values[counter] = textField3.getText();
                                                break;
                                            case 4:
                                                Values[counter] = textField4.getText();
                                                break;
                                            case 5:
                                                Values[counter] = textField5.getText();
                                                break;
                                            case 6:
                                                Values[counter] = textField6.getText();
                                                break;
                                            case 7:
                                                Values[counter] = textField7.getText();
                                                break;
                                            case 8:
                                                Values[counter] = textField8.getText();
                                                break;
                                            case 9:
                                                Values[counter] = textField9.getText();
                                                break;
                                            case 10:
                                                Values[counter] = textField10.getText();
                                                break;
                                            case 11:
                                                Values[counter] = textField11.getText();
                                                break;
                                            case 12:
                                                Values[counter] = textField12.getText();
                                                break;
                                            case 13:
                                                Values[counter] = textField13.getText();
                                                break;
                                            case 14:
                                                Values[counter] = textField14.getText();
                                                break;
                                            case 15:
                                                Values[counter] = textField15.getText();
                                                break;
                                            case 16:
                                                Values[counter] = textField16.getText();
                                                break;
                                            case 17:
                                                Values[counter] = textField17.getText();
                                                break;
                                            case 18:
                                                Values[counter] = textField18.getText();
                                                break;
                                            case 19:
                                                Values[counter] = textField19.getText();
                                                break;
                                            case 20:
                                                Values[counter] = textField20.getText();
                                                break;
                                            case 21:
                                                Values[counter] = textField21.getText();
                                                break;
                                            case 22:
                                                Values[counter] = textField22.getText();
                                                break;
                                            case 23:
                                                Values[counter] = textField23.getText();
                                                break;
                                            case 24:
                                                Values[counter] = textField24.getText();
                                                break;
                                            case 25:
                                                Values[counter] = textField25.getText();
                                                break;
                                            case 26:
                                                Values[counter] = textField26.getText();
                                                break;

                                            default: 
                                                break;

                                        }
                                }
                        // Update Database Table
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            conn = DriverManager.getConnection(DB_URL, USER, PASS);
                            Statement statement = conn.createStatement();
                            for(int counter = 1; counter <= 26; counter++){
                                    JOptionPane.showMessageDialog(null, counter);
                                    String query = "UPDATE `"+ jComboBox1.getSelectedItem().toString().toLowerCase() +"` SET Schedule = '"+ Values[counter-1] +"' WHERE Counter = '"+ (counter) +"' ";
                                    statement.executeUpdate(query);
                            }
                            conn.close();       
                        }catch(SQLException se){
                            //Handle errors for JDBC
                            se.printStackTrace();
                         }catch(Exception e){
                            //Handle errors for Class.forName
                            e.printStackTrace();
                         }finally{
                            //finally block used to close resources
                            try{
                               if(stmt!=null)
                                  conn.close();
                            }catch(SQLException se){
                            }// do nothing
                            try{
                               if(conn!=null)
                                  conn.close();
                            }catch(SQLException se){
                               se.printStackTrace();
                            }//end finally try
                         }//end try
                
            } else {
                // no option
            }
    }
    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowanceButtonActionPerformed         
            //JOptionPane.showMessageDialog(null, jComboBox1.getSelectedItem().toString());
            String[] Subjects = new String[26];
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();

                for (int counter = 1; counter <= 26; counter++) {
                    try {
                                        Statement Time = conn.createStatement();
                                        String getTime = "SELECT * FROM `"+ jComboBox1.getSelectedItem().toString() +"` Where Counter = '"+(counter)+"'";
                                        //String getTime = "SELECT * FROM tuesday Where Counter = '"+(counter)+"'";
                                        ResultSet resultSet = Time.executeQuery(getTime);

                                        if(resultSet.next()) {
                                            //JOptionPane.showMessageDialog(null, resultSet.getString("Subject"));
                                            Subjects[counter] = resultSet.getString("Schedule");
                                            switch(counter){
                                                case 1:
                                                    textField1.setText(Subjects[counter]);
                                                    break;
                                                case 2:
                                                    textField2.setText(Subjects[counter]);
                                                    break;
                                                case 3:
                                                    textField3.setText(Subjects[counter]);
                                                    break;
                                                case 4:
                                                    textField4.setText(Subjects[counter]);
                                                    break;
                                                case 5:
                                                    textField5.setText(Subjects[counter]);
                                                    break;
                                                case 6:
                                                    textField6.setText(Subjects[counter]);
                                                    break;
                                                case 7:
                                                    textField7.setText(Subjects[counter]);
                                                    break;
                                                case 8:
                                                    textField8.setText(Subjects[counter]);
                                                    break;
                                                case 9:
                                                    textField9.setText(Subjects[counter]);
                                                    break;
                                                case 10:
                                                    textField10.setText(Subjects[counter]);
                                                    break;
                                                case 11:
                                                    textField11.setText(Subjects[counter]);
                                                    break;
                                                case 12:
                                                    textField12.setText(Subjects[counter]);
                                                    break;
                                                case 13:
                                                    textField13.setText(Subjects[counter]);
                                                    break;
                                                case 14:
                                                    textField14.setText(Subjects[counter]);
                                                    break;
                                                case 15:
                                                    textField15.setText(Subjects[counter]);
                                                    break;
                                                case 16:
                                                    textField16.setText(Subjects[counter]);
                                                    break;
                                                case 17:
                                                    textField17.setText(Subjects[counter]);
                                                    break;
                                                case 18:
                                                    textField18.setText(Subjects[counter]);
                                                    break;
                                                case 19:
                                                    textField19.setText(Subjects[counter]);
                                                    break;
                                                case 20:
                                                    textField20.setText(Subjects[counter]);
                                                    break;
                                                case 21:
                                                    textField21.setText(Subjects[counter]);
                                                    break;
                                                case 22:
                                                    textField22.setText(Subjects[counter]);
                                                    break;
                                                case 23:
                                                    textField23.setText(Subjects[counter]);
                                                    break;
                                                case 24:
                                                    textField24.setText(Subjects[counter]);
                                                    break;
                                                case 25:
                                                    textField25.setText(Subjects[counter]);
                                                    break;
                                                case 26:
                                                    textField26.setText(Subjects[counter]);
                                                    break;

                                                default: 
                                                    break;

                                            }


                                        }
                                        //resultSet.close();
                                        //conn.close();
                    }catch(Exception ex){

                    }
                }
                conn.close();
            }catch(Exception ex){

            }
        }
    
    
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
            java.util.logging.Logger.getLogger(SchedulePopout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchedulePopout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchedulePopout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchedulePopout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchedulePopout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel dayLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JLabel subjectLabel1;
    private javax.swing.JTextField textField1;
    private javax.swing.JTextField textField10;
    private javax.swing.JTextField textField11;
    private javax.swing.JTextField textField12;
    private javax.swing.JTextField textField13;
    private javax.swing.JTextField textField14;
    private javax.swing.JTextField textField15;
    private javax.swing.JTextField textField16;
    private javax.swing.JTextField textField17;
    private javax.swing.JTextField textField18;
    private javax.swing.JTextField textField19;
    private javax.swing.JTextField textField2;
    private javax.swing.JTextField textField20;
    private javax.swing.JTextField textField21;
    private javax.swing.JTextField textField22;
    private javax.swing.JTextField textField23;
    private javax.swing.JTextField textField24;
    private javax.swing.JTextField textField25;
    private javax.swing.JTextField textField26;
    private javax.swing.JTextField textField3;
    private javax.swing.JTextField textField4;
    private javax.swing.JTextField textField5;
    private javax.swing.JTextField textField6;
    private javax.swing.JTextField textField7;
    private javax.swing.JTextField textField8;
    private javax.swing.JTextField textField9;
    // End of variables declaration                   
}
