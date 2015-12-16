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
                                    String getTime = "SELECT * FROM `"+ dayNow.toLowerCase() +"` Where Counter = '"+(counter)+"'";
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