import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerThread implements Runnable {

    private SocketUtils utils;

    private ServerSocket ss;
    private Socket cs;

    private int port;

    private PlayersHandler playersHandler;

    ControllerThread(int port, PlayersHandler playersHandler) {
        this.port = port;
        this.playersHandler = playersHandler;
    }

    @Override
    public void run() {
        waitForConnection();
    }

    /**
     * waits until a connection is established
     */
    public void waitForConnection() {
        try {
            ss = new ServerSocket(port);
            cs = ss.accept();
            utils = new SocketUtils(cs);
            playersHandler.setPlayerFound(true);
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
        waitForConnection();
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
