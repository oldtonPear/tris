import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    
    private SocketUtils utils;
    
    private ServerSocket ss;
    private Socket cs;
    
    public int port;
    
    private PlayersHandler playersHandler;
    
    private String board;
    private char myChar;
    
    ServerThread(int port, PlayersHandler playersHandler) {
        this.port = port;
        this.playersHandler = playersHandler;
        board = "NNNNNNNNN";
        myChar = '\0';
    }
    
    @Override
    public void run() {
        waitForConnection();
        while (!playersHandler.getBoard().equals("NNNNNNNNN")) {
        }
        online();
    }
    
    /**
    * waits until a connection is established
    */
    public void waitForConnection() {
        try {
            ss = new ServerSocket(port);
            cs = ss.accept();
            utils = new SocketUtils(cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * sends 's' to the connected client
    * 
    * @param s
    */
    public void manageOutput(String s) {
        utils.out.write(s + '\n');
        utils.out.flush();
    }
    
    /**
    * manages inputs on the Socket
    * 
    * @return -1 if an error accours, the message arrived if everything goes well
    */
    public String manageInput() {
        String s = "";
        try {
            s = utils.in.readLine();
            if (s == null)
            return "-1";
            else if (s.equals(""))
            return "-1";
            
        } catch (IOException e) {
            return "-1";
        }
        return s;
    }
    
    /**
    * continues to listen and processed data when needed
    * eventually calling manageOutput
    */
    public void online() {
        while (!cs.isClosed()) {
            if (board != playersHandler.getBoard()) {
                board = playersHandler.getBoard();
                manageOutput(board);
                String response = manageInput();
                playersHandler.setBoard(response);
                while (response.equals(playersHandler.getBoard())) {
                }
                checkWin();
                if (playersHandler.getBoard().equals("X") || playersHandler.getBoard().equals("O"))
                System.out.println("Win!");
            }
        }
    }
    
    /**
    * disposes resorces
    */
    public void dispose() {
        try {
            cs.close();
            cs = null;
            utils.dispose();
            try {
                ss = new ServerSocket(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
            waitForConnection();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setBoard(String board) {
        this.board = board;
    }
    
    private void checkWin() {
        char[][] mat = {
            {board.charAt(0), board.charAt(1), board.charAt(2)},
            {board.charAt(3), board.charAt(4), board.charAt(5)},
            {board.charAt(6), board.charAt(7), board.charAt(8)}
        };
        char playerWon = ' ';
        
        for (int i = 0; i < 3; i += 3) {
            boolean condition1 = (mat[i][0] != 'N' && mat[i][0] == mat[i][1] && mat[i][0] == mat[i][2]);
            boolean condition2 = (mat[0][i] != 'N' && mat[0][i] == mat[1][i] && mat[0][i] == mat[2][i]);
            if (condition1) playerWon = mat[i][0];
            if (condition2) playerWon = mat[0][1];
        }

        boolean condition1 = (mat[0][0] != 'N' && mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2]);
        boolean condition2 = (mat[0][2] != 'N' && mat[0][2] == mat[1][1] && mat[0][2] == mat[2][0]);
        if (condition1) playerWon = mat[0][0];
        if (condition2) playerWon = mat[0][2];
        
        if (playerWon != ' ') {
            System.out.println((playerWon == 'X' ? "Giocatore 1 ha vinto" : "Giocatore 2 ha vinto"));
            return;
        }
        
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == 'N') return;
        }
        System.out.println("Patta");
    }
}
