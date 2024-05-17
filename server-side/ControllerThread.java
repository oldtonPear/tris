import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerThread extends Thread {
    
    private SocketUtils utils;
    
    private ServerSocket ss;
    private Socket cs;
    private int port;
    
    ControllerThread(int port) {
        this.port = port;
    }
    
    @Override
    public void run() {
        while (true) {
            if (!PlayersHandler.isPlayerFound()) {
                waitForConnection();
            }
        }
    }
    
    /**
    * waits until a connection is established
    */
    public void waitForConnection() {
        try {
            ss = new ServerSocket(port);
            cs = ss.accept();
            utils = new SocketUtils(cs);
            PlayersHandler.setPlayerFound(true);
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
        dispose();
        PlayersHandler.setPlayerFound(false);
    }
    
    /**
    * disposes resorces
    */
    public void dispose() {
        try {
            cs.close();
            ss.close();
            utils.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
