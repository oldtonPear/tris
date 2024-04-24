public class Server{
    private int[][] board = {
        {-1, -1, -1}, 
        {-1, -1, -1},
        {-1, -1, -1}
      };

    private ControllerThread controller;
    private Thread controllerThread;
    private int controllerPort;

    private ServerThread[] serverThreads;
    private Thread[] threads;

    private PlayersHandler playersHandler = new PlayersHandler();

    Server(int port){
        controllerPort = port;
    }
    Server(){
        controllerPort = 5050;
        serverThreads = new ServerThread[2];
        threads = new Thread[2];
        controller = new ControllerThread(controllerPort, playersHandler);
        controllerThread = new Thread(controller);
        controllerThread.start();
        checkForPlayers();
    }

    public void checkForPlayers(){
        while(true){
            if(playersHandler.isPlayerFound()){
                System.out.println("PLAYER FOUND!!");
                if(serverThreads[0] == null){
                    serverThreads[0] = new ServerThread(controllerPort+1, playersHandler);
                    threads[0] = new Thread(serverThreads[0]);
                    threads[0].start();
                    
                    controller.manageOutput(controllerPort+1 + "");
                }
                
                else if(serverThreads[1] == null){
                    serverThreads[1] = new ServerThread(controllerPort+2, playersHandler);
                    threads[1] = new Thread(serverThreads[1]);
                    threads[1].start();
                    serverThreads[0].setBoard("-1,-1,-1,-1,-1,-1,-1,-1,0");
                    playersHandler.setBoard("-1,-1,-1,-1,-1,-1,-1,-1,-1");
                    controller.manageOutput(controllerPort+2 + "");
                }
                else{
                    controller.manageOutput("Ports already occupied!!");
                }
            }
        }
    }
}