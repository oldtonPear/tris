import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
    
    private SocketUtils utils;
    
    private ServerSocket ss;
    private Socket cs;
    
    public int port;
    
    private String board;
    
    ServerThread(int port) {
        this.port = port;
        board = "NNNNNNNNN";
    }
    
    @Override
    public void run() {
        waitForConnection();
        while (!PlayersHandler.getBoard().equals("NNNNNNNNN")) {}
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
            if (board != PlayersHandler.getBoard()) {
                board = PlayersHandler.getBoard();
                manageOutput(board);
                String response = manageInput();
                if(response.equals("OK")){
                    dispose();
                    System.out.println("ENDING GAME");
                    break;
                }
                else PlayersHandler.setBoard(response);
                while (response.equals(PlayersHandler.getBoard())) {}
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
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setBoard(String board) {
        this.board = board;
    }
}
