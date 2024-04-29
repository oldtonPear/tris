/**
 *
 * @author Gabriele Urban
 */
public class Tris_Main extends javax.swing.JFrame {
    private static Main_Menu main_Menu1;
    private static Tris_Board tris_Board1;
    private static Client client;
    private static Thread clientThread;
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tris_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tris_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tris_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tris_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tris_Main().setVisible(true);
            }
        });
    }
    
    public Tris_Main() {
        initComponents();
        tris_Board1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        main_Menu1 = new Main_Menu();
        tris_Board1 = new Tris_Board();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tris_Board1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(main_Menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tris_Board1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(main_Menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addGap(26, 26, 26)))
        );

        pack();
    }
    public static void createClient(int port, String ip){
        client = new Client(5050, "localhost");
        clientThread = new Thread(client);
        client.setRes(new Resources());
        tris_Board1.setRes(client.getRes());
        client.register(tris_Board1);
        clientThread.start();
    }
    public static void createServer(int port){

    }

    public static void changeWin(){
        tris_Board1.setVisible(!tris_Board1.isVisible());
        main_Menu1.setVisible(!main_Menu1.isVisible());
    }
}