/**
 *
 * @author Gabriele Urban
 */
public class Tris_Board extends javax.swing.JPanel {
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JPanel cell1;
    private javax.swing.JPanel cell2;
    private javax.swing.JPanel cell3;
    private javax.swing.JPanel cell4;
    private javax.swing.JPanel cell5;
    private javax.swing.JPanel cell6;
    private javax.swing.JPanel cell7;
    private javax.swing.JPanel cell8;
    private javax.swing.JPanel cell9;
    
    public Tris_Board() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        cell1 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        cell2 = new javax.swing.JPanel();
        button2 = new javax.swing.JButton();
        cell3 = new javax.swing.JPanel();
        button3 = new javax.swing.JButton();
        cell4 = new javax.swing.JPanel();
        button4 = new javax.swing.JButton();
        cell5 = new javax.swing.JPanel();
        button5 = new javax.swing.JButton();
        cell6 = new javax.swing.JPanel();
        button6 = new javax.swing.JButton();
        cell7 = new javax.swing.JPanel();
        button7 = new javax.swing.JButton();
        cell8 = new javax.swing.JPanel();
        button8 = new javax.swing.JButton();
        cell9 = new javax.swing.JPanel();
        button9 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(390, 235));
        setLayout(new java.awt.GridLayout(3, 3));

        cell1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button1.setOpaque(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell1Layout = new javax.swing.GroupLayout(cell1);
        cell1.setLayout(cell1Layout);
        cell1Layout.setHorizontalGroup(
            cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell1Layout.setVerticalGroup(
            cell1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        button1.getAccessibleContext().setAccessibleDescription("");

        add(cell1);

        cell2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button2.setOpaque(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell2Layout = new javax.swing.GroupLayout(cell2);
        cell2.setLayout(cell2Layout);
        cell2Layout.setHorizontalGroup(
            cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell2Layout.setVerticalGroup(
            cell2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell2);

        cell3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button3.setOpaque(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell3Layout = new javax.swing.GroupLayout(cell3);
        cell3.setLayout(cell3Layout);
        cell3Layout.setHorizontalGroup(
            cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell3Layout.setVerticalGroup(
            cell3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell3);

        cell4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button4.setOpaque(false);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell4Layout = new javax.swing.GroupLayout(cell4);
        cell4.setLayout(cell4Layout);
        cell4Layout.setHorizontalGroup(
            cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell4Layout.setVerticalGroup(
            cell4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell4);

        cell5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button5.setOpaque(false);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell5Layout = new javax.swing.GroupLayout(cell5);
        cell5.setLayout(cell5Layout);
        cell5Layout.setHorizontalGroup(
            cell5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell5Layout.setVerticalGroup(
            cell5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell5);

        cell6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button6.setOpaque(false);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell6Layout = new javax.swing.GroupLayout(cell6);
        cell6.setLayout(cell6Layout);
        cell6Layout.setHorizontalGroup(
            cell6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell6Layout.setVerticalGroup(
            cell6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell6);

        cell7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button7.setOpaque(false);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell7Layout = new javax.swing.GroupLayout(cell7);
        cell7.setLayout(cell7Layout);
        cell7Layout.setHorizontalGroup(
            cell7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell7Layout.setVerticalGroup(
            cell7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell7);

        cell8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button8.setOpaque(false);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell8Layout = new javax.swing.GroupLayout(cell8);
        cell8.setLayout(cell8Layout);
        cell8Layout.setHorizontalGroup(
            cell8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button8, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell8Layout.setVerticalGroup(
            cell8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button8, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell8);

        cell9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button9.setOpaque(false);
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cell9Layout = new javax.swing.GroupLayout(cell9);
        cell9.setLayout(cell9Layout);
        cell9Layout.setHorizontalGroup(
            cell9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        cell9Layout.setVerticalGroup(
            cell9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        add(cell9);
    }

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
}