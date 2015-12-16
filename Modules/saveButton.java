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