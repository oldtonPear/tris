import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread implements Runnable{

    private SocketUtils utils;

    private ServerSocket ss;
    private Socket cs;

    public int port;

    private PlayersHandler playersHandler;

    private String board;

    ServerThread(int port, PlayersHandler playersHandler){
        this.port = port;
        this.playersHandler = playersHandler;
        board = "-1,-1,-1,-1,-1,-1,-1,-1,-1";
    }

    @Override
    public void run() {
        waitForConnection();
        while(!playersHandler.getBoard().equals("-1,-1,-1,-1,-1,-1,-1,-1,-1")){}
        online();
    }

    /**
     * waits until a connection is established
     */
    public void waitForConnection(){
        try {
            ss = new ServerSocket(port);
            System.out.println("Waiting for connection at port " + port);
            cs = ss.accept();
            utils = new SocketUtils(cs);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sends 's' to the connected client
     * @param s
     */
    public void manageOutput(String s){
        utils.out.write(s + '\n');
        utils.out.flush();
    }


    public String manageInput(){
        String s = "";
        try {
            s = utils.in.readLine();
            if(s == null) return "-1";
            else if(s.equals("")) return "-1";
            
        } catch (IOException e) {
            return "-1";
        }
        return s;
    }

    /**
     * continues to listen and processed data when needed
     * eventually calling manageOutput
     */
    public void online(){
        System.out.println("ONLINE PORT " + port);
        while(!cs.isClosed()){
            if(board != playersHandler.getBoard()){
                board = playersHandler.getBoard();
                System.out.println("It's my turn " + port);
                manageOutput(board);
                String response = manageInput();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                playersHandler.setBoard(response);
            }
        }
    }

    /**
     * disposes resorces
    */
    public void dispose(){
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
}
