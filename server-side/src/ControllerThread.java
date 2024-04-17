import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ControllerThread implements Runnable, Observable{

    private SocketUtils utils;

    private ServerSocket ss;
    private Socket cs;

    private LinkedList<Observer> observers = new LinkedList<>();

    private int port;

    ControllerThread(int port){
        this.port = port;
    }

    @Override
    public void run() {
        waitForConnection();
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
            notifyObservers("PLAYER FOUND");
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
        dispose();
        waitForConnection();
    }

    /**
     * disposes resorces
    */
    public void dispose(){
        try { 
            System.out.println("Closing connection on port " + port);
            cs.close();
            ss.close();
            utils.dispose();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String code) {
        for (Observer observer : observers) {
            observer.updateObserver(code, port);
        }
    }
}
