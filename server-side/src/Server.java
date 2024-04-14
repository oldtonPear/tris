import java.util.ArrayList;

public class Server implements Observer{
    private int[][] board = {
        {-1, -1, -1}, 
        {-1, -1, -1},
        {-1, -1, -1}
      };

    ServerThread controller;
    private Thread controllerThread;
    private ServerThread[] serverThreads;
    private Thread[] threads;
    private int port = 5050;

    Server(){
        serverThreads = new ServerThread[2];
        threads = new Thread[2];
        controller = new ServerThread(port, true);
        controllerThread = new Thread(controller);
        controllerThread.start();
    }

    @Override
    public void updateObserver(String code) {

        switch (code) {
            case "PLAYER FOUND" -> {
                controller.manageOutput(port + "");
                System.out.println("PLAYER FOUND!!");
                port += 20;
                if(port == 5070){
                    serverThreads[0] = new ServerThread(port, false);
                    threads[0] = new Thread(serverThreads[0]);
                    threads[0].start();
                    return;
                }
                serverThreads[1] = new ServerThread(port+40, false);
                threads[1] = new Thread(serverThreads[1]);
                threads[1].start();
            }
            case "CHANGE TURN" -> {
                
            }
            case "PLAYER CONNECTED" -> {
                System.out.println("player connected");
            }
        }
    }
}