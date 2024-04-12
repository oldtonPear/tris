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

    @Override
    public void run() {
        try {
            ss = new ServerSocket(1069);
        } catch (IOException e) {
            e.printStackTrace();
        }
        waitForConnession();
    }

    /**
     * waits until a connection is established
     */
    private void waitForConnession(){
        try {
            cs = ss.accept();
            utils = new SocketUtils(cs);
            notifyObservers("PLAYER FOUND");
            System.out.println("connession succesful!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sends 's' to the connected client
     * @param s
     */
    private void manageOutput(String s){
        utils.out.write(s + '\n');
        utils.out.flush();
    }


    private String manageInput(){
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
                System.out.println("Messaggio ricevuto!");
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
            System.out.println("Chiudo connessione!");
            cs.close();
            cs = null;
            utils.dispose();
            waitForConnession();

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
    
}
