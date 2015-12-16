// layout of "Today's" Panel

Timer SimpleTimer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeStamp = new SimpleDateFormat("h:mm:ss a").format(Calendar.getInstance().getTime());
                timeTextField.setText(timeStamp);
                timeTextField.setEditable(false);
            }
        });
        
        SimpleTimer.start();
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Calendar cal = Calendar.getInstance();
        dateTextField.setText(dateFormat.format(cal.getTime()));
        dateTextField.setEditable(false);
        
        timeTextField.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        timeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        dateTextField.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        dateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);