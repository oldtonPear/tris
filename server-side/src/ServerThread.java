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

    ServerThread(int port, PlayersHandler playersHandler){
        this.port = port;
        this.playersHandler = playersHandler;
    }

    @Override
    public void run() {
        waitForConnection();
        while(!playersHandler.isSecondPlayerConnected()){}
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
        System.out.println("ONLINE PORT " + port + playersHandler.getTurnPlayerPort());
        while(!cs.isClosed()){
            if(port == playersHandler.getTurnPlayerPort()){
                System.out.println("It's my turn " + port);
                manageOutput("YOUR TURN");
                String response = manageInput();
                playersHandler.changeTurn();
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
}
