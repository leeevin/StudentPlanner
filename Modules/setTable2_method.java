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
                                    String getTime = "SELECT * FROM `"+ dayNow.toLowerCase() +"` Where Counter = '"+(counter)+"'";
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