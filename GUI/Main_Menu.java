/**
 *
 * @author Gabriele Urban
 */
public class Main_Menu extends javax.swing.JPanel {
    private javax.swing.JButton Confirm;
    private javax.swing.JCheckBox Host;
    private javax.swing.JTextField IP;
    private javax.swing.JLabel IPlabel;
    private javax.swing.JTextField Port;
    private javax.swing.JLabel Portlabel;
    private javax.swing.JLabel jLabel1;
    private String ip;
    private int port; 

    public Main_Menu() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        Confirm = new javax.swing.JButton();
        Host = new javax.swing.JCheckBox();
        Port = new javax.swing.JTextField();
        IP = new javax.swing.JTextField();
        IPlabel = new javax.swing.JLabel();
        Portlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(390, 235));

        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        Host.setText("Host The Game");
        Host.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostActionPerformed(evt);
            }
        });

        Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortActionPerformed(evt);
            }
        });

        IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPActionPerformed(evt);
            }
        });

        IPlabel.setText("IP");

        Portlabel.setText("Port");

        jLabel1.setText("T - Themes, C - Command Prompt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(IPlabel)
                                    .addComponent(Portlabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Port)
                                    .addComponent(IP)
                                    .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(Host, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(72, 72, 72)))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IPlabel))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Portlabel))
                .addGap(18, 18, 18)
                .addComponent(Host)
                .addGap(18, 18, 18)
                .addComponent(Confirm)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void IPActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void PortActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void HostActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {
        if(Host.isSelected()){
            ip = "localhost";
            Tris_Main.createServer(port);
        } 
        else ip = IP.getText();
        port = Integer.parseInt(Port.getText());
        Tris_Main.createClient(port, ip);
        Tris_Main.changeWin();
    }
}