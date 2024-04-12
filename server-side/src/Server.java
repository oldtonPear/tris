import java.util.ArrayList;

public class Server implements Observer{
    private int[][] board = {
        {-1, -1, -1}, 
        {-1, -1, -1},
        {-1, -1, -1}
      };

    private ArrayList<ServerThread> serverThreads;
    private ArrayList<Thread> threads;
    private int port = 5050;

    Server(){
        serverThreads = new ArrayList<>();
        threads = new ArrayList<>();
        serverThreads.add(new ServerThread(port, true));
        threads.add(new Thread(serverThreads.get(0)));
        threads.get(0).start();
        serverThreads.get(0).register(this);
        port += 20;
    }

    @Override
    public void updateObserver(String code) {

        switch (code) {
            case "PLAYER FOUND" -> {
                System.out.println("PLAYER FOUND!!");
                serverThreads.add(new ServerThread(port, false));
                threads.add(new Thread(serverThreads.get(serverThreads.size()-1)));
                threads.get(threads.size()-1).start();
                serverThreads.get(serverThreads.size()-1).register(this);
                serverThreads.get(0).manageOutput(port + "");
                port += 20;
            }
            case "CHANGE TURN" -> {
                
            }
            case "PLAYER CONNECTED" -> {
                System.out.println("player connected");
            }
        }
    }
}