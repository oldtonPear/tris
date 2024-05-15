/**
 *
 * @author Gabriele Urban
 */
public class Tris_Board extends javax.swing.JPanel implements Observer {
    private javax.swing.JPanel[] cells;
    private javax.swing.JButton[] buttons;

    private int player = 0;
    private boolean myTurn;
    private Client client;
    private Shared_board sh = new Shared_board();

    public Tris_Board() {
        myTurn = false;
        initComponents();
    }

    private void initComponents() {
        cells = new javax.swing.JPanel[9];
        buttons = new javax.swing.JButton[9];

        setPreferredSize(new java.awt.Dimension(390, 235));
        setLayout(new java.awt.GridLayout(3, 3));

        for (int i = 0; i < cells.length; i++) {
            cells[i] = new javax.swing.JPanel();
            buttons[i] = new javax.swing.JButton();

            cells[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            buttons[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            buttons[i].setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            buttons[i].setOpaque(false);

            final int t = i;
            buttons[i].addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonActionPerformed(evt, t);
                }
            });

            javax.swing.GroupLayout cellLayout = new javax.swing.GroupLayout(cells[i]);
            cells[i].setLayout(cellLayout);

            cellLayout.setHorizontalGroup(
                    cellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttons[i], javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE));
            cellLayout.setVerticalGroup(
                    cellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttons[i], javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE));

            buttons[i].getAccessibleContext().setAccessibleDescription("");
            add(cells[i]);
        }
    }

    private void buttonActionPerformed(java.awt.event.ActionEvent evt, int i) {
        if (buttons[i].getIcon() != null)
            return;
        doAction(i);
        updateButtons();
    }

    private void doAction(int n) {
        String board = sh.getBoard();
        if (myTurn && board.charAt(n) == 'N') {
            sh.setBoard(board.substring(0, n) + (player == 1 ? 'X' : 'O') + board.substring(n + 1));
        }
        myTurn = false;
    }

    @Override
    public void update() {
        if (player == 0) {
            player = client.getPlayer();
        }
        System.out.println("MY TURN!");
        myTurn = true;
        updateButtons();
        // BoardManager.updateButtons(this, sh.getBoard());
    }

    public void updateButtons() {
        String board = sh.getBoard();
        for (int i = 0; i < buttons.length; i++) {
            if (board.charAt(i) == 'X') {
                buttons[i].setIcon(new javax.swing.ImageIcon("GUI\\Assets\\X.png"));
            } else if (board.charAt(i) == 'O') {
                buttons[i].setIcon(new javax.swing.ImageIcon("GUI\\Assets\\O.png"));
            }
        }
    }

    public void setClient(Client client) {
        this.client = client;
        this.client.setSh(sh);
    }

    /*-Getters and Setters-*/
    public javax.swing.JPanel[] getCells() {
        return cells;
    }

    public javax.swing.JButton[] getButtons() {
        return buttons;
    }
}