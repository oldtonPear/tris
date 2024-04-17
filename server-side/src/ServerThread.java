import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread implements Runnable, Observable{

    private SocketUtils utils;

    private ServerSocket ss;
    private Socket cs;

    private LinkedList<Observer> observers = new LinkedList<>();

    private int port;

    ServerThread(int port){
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
            notifyObservers("PLAYER CONNECTED");
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
        System.out.println("online!");
        while(!cs.isClosed()){
            manageOutput("YOUR TURN");
            String responce = manageInput();
            manageOutput("OK!");
            notifyObservers("CHANGE TURN");
        }
    }

    /**
     * disposes resorces
    */
    public void dispose(){
        try { 
            System.out.println("Closing connection on port " + port);
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
