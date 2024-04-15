import java.util.ArrayList;

public class Server implements Observer{
    private int[][] board = {
        {-1, -1, -1}, 
        {-1, -1, -1},
        {-1, -1, -1}
      };

    private ControllerThread controller;
    private Thread controllerThread;
    private int controllerPort = 5050;

    private ServerThread[] serverThreads;
    private Thread[] threads;
    private int port = controllerPort;

    Server(){
        serverThreads = new ServerThread[2];
        threads = new Thread[2];
        controller = new ControllerThread(port);
        controllerThread = new Thread(controller);
        controllerThread.start();
        controller.register(this);
    }

    @Override
    public void updateObserver(String code) {

        switch (code) {
            case "PLAYER FOUND" -> {
                System.out.println("PLAYER FOUND!!");
                port ++;
                if(port - controllerPort == 1){
                    serverThreads[0] = new ServerThread(port);
                    threads[0] = new Thread(serverThreads[0]);
                    threads[0].start();
                    serverThreads[0].register(this);
                    controller.manageOutput(port + "");
                }
                
                else if(port - controllerPort == 2){
                    serverThreads[1] = new ServerThread(port);
                    threads[1] = new Thread(serverThreads[1]);
                    threads[1].start();
                    serverThreads[1].register(this);
                    controller.manageOutput(port + "");
                }
                else{
                    controller.manageOutput("Ports already occupied!!");
                }
            }
            case "CHANGE TURN" -> {
                
            }
            case "PLAYER CONNECTED" -> {
                System.out.println("player connected");
            }
        }
    }
}