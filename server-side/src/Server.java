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

    PlayersHandler playersHandler = new PlayersHandler(controllerPort+1, controllerPort+2);

    Server(){
        serverThreads = new ServerThread[2];
        threads = new Thread[2];
        controller = new ControllerThread(controllerPort);
        controllerThread = new Thread(controller);
        controllerThread.start();
        controller.register(this);
    }

    @Override
    public void updateObserver(String code, int threadPort) {

        switch (code) {
            case "PLAYER FOUND" -> {
                System.out.println("PLAYER FOUND!!");
                if(serverThreads[0] == null){
                    serverThreads[0] = new ServerThread(controllerPort+1, playersHandler);
                    threads[0] = new Thread(serverThreads[0]);
                    threads[0].start();
                    serverThreads[0].register(this);
                    
                    controller.manageOutput(controllerPort+1 + "");
                }
                
                else if(serverThreads[1] == null){
                    serverThreads[1] = new ServerThread(controllerPort+2, playersHandler);
                    threads[1] = new Thread(serverThreads[1]);
                    threads[1].start();
                    serverThreads[1].register(this);
                    
                    playersHandler.setSecondPlayerConnected(true);
                    controller.manageOutput(controllerPort+2 + "");
                }
                else{
                    controller.manageOutput("Ports already occupied!!");
                }
            }
            case "CHANGE TURN" -> {
                playersHandler.changeTurn();
                
            }
            case "PLAYER CONNECTED" -> {
                System.out.println("PLAYER CONNECTED AT PORT: " + threadPort);
            }
        }
    }
}