public void SetDBase(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM monday ");
                            Calendar calendar = Calendar.getInstance();
                            Date date = calendar.getTime();
                            
                            String dayNow = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
                            dayNow.toLowerCase();
                            //JOptionPane.showMessageDialog(null, dayNow);
                            jTable1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
                            DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                                new String [] {
                                    "Time", "Subject"
                                }, 0
                            ) {
                                boolean[] canEdit = new boolean [] {
                                    false, false
                                };

                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return canEdit [columnIndex];
                                }
                            };
                                
                            for (int counter = 1; counter <= 26; counter++) {
                                try {
                                    Statement Time = conn.createStatement();
                                    String getTime = "SELECT * FROM `"+ dayNow.toLowerCase() +"` Where Counter = '"+(counter)+"'";
                                    ResultSet resultSet = Time.executeQuery(getTime);
                                    
                                    if(resultSet.next()) { 
                                        model.addRow(new Object[]{ resultSet.getString("Time"), 
                                                                   resultSet.getString("Subject") }
                                        );
                                    }
                                }catch(Exception ex){
                                    
                                }
                                
                           }
                           jTable1.setModel(model);
                    conn.close();
                    jTable1.setRowHeight(30);
                //}  
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
    }     