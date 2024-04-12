import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread implements Runnable, Observable{

    private SocketUtils utils;

    private ServerSocket ss;
    private Socket cs;

    private LinkedList<Observer> observers = new LinkedList<>();

    private boolean isOnline;

    private int port;

    private boolean isSorter;

    ServerThread(int port, boolean isSorter){
        this.port = port;
        this.isSorter = isSorter;
    }

    @Override
    public void run() {
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        waitForConnection();
        //online();
    }

    /**
     * waits until a connection is established
     */
    private void waitForConnection(){
        try {
            System.out.println("Waiting for connection at port " + port);
            cs = ss.accept();
            utils = new SocketUtils(cs);
            if(isSorter) notifyObservers("PLAYER FOUND");
            else notifyObservers("PLAYER CONNECTED");
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
        if(isSorter){
            dispose();
        } 
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
        isOnline = true;
        System.out.println("online!");
        while(!cs.isClosed()){

            String input = manageInput();
            
            if(input.equals("-3")) break;

            if(input.equals("-2")){
                manageOutput("null");
            }
            
            else if(!input.equals("-1")){
                System.out.println("Something received on port" + port);
                manageOutput("Ricevuto!");
            }
        }
        dispose();
    }

    public void offline(){
        isOnline = false;
        while(true){}
    }

    /**
     * disposes resorces
    */
    private void dispose(){
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
            observer.updateObserver(code);
        }
    }
    public boolean isOnline() {
        return isOnline;
    }
}
