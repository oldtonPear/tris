public abstract class BoardManager {
    
    public static void reset(Tris_Board board){
        javax.swing.JButton[] buttons = board.getButtons();
        javax.swing.JLabel[] Xs = board.getXs(), Os = board.getOs();
        
        for (int i = 0; i < 9; i++) {
            buttons[i].setVisible(true);
            Xs[i].setVisible(false);
            Os[i].setVisible(false);
        }
    }
    
    public static void updateButtons(Tris_Board board, String sharedBoard){
        /*javax.swing.JButton[] buttons = board.getButtons();
        javax.swing.JLabel[] Xs = board.getXs(), Os = board.getOs();
        
        for (int i = 0; i < 9; i++) {
            if (sharedBoard.charAt(i) != 'N') {
                buttons[i].setVisible(false);
                if (sharedBoard.charAt(i) == 'X') {
                    Xs[i].setVisible(true);
                    Os[i].setVisible(false);
                }else {
                    Xs[i].setVisible(false);
                    Os[i].setVisible(true);
                }
            } else {
                buttons[i].setVisible(true);
                Xs[i].setVisible(false);
                Os[i].setVisible(false);
            }
        }*/
    }
}
