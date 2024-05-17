public class Server extends Thread{

    private ControllerThread controller;
    private int controllerPort;

    private ServerThread[] serverThreads;

    private PlayersHandler playersHandler = new PlayersHandler();

    Server(int port){
        controllerPort = port;
    }
    Server(){
        controllerPort = 5050;
        serverThreads = new ServerThread[2];
        controller = new ControllerThread(controllerPort, playersHandler);
        controller.start();
    }

    public void checkForPlayers(){
        System.out.println("SERVER ONLINE!");
        while(true){
            if(playersHandler.isPlayerFound()){
                if(serverThreads[0] == null){
                    serverThreads[0] = new ServerThread(controllerPort+1, playersHandler);
                    serverThreads[0].start();
                    
                    controller.manageOutput(controllerPort+1 + "");
                }
                
                else if(serverThreads[1] == null){
                    serverThreads[1] = new ServerThread(controllerPort+2, playersHandler);
                    serverThreads[1].start();
                    serverThreads[0].setBoard("0NNNNNNNN");
                    playersHandler.setBoard("NNNNNNNNN");
                    controller.manageOutput(controllerPort+2 + "");
                }
                else{
                    controller.manageOutput("Ports already occupied!!");
                }
            }
        }
    }
    @Override
    public void run() {
        checkForPlayers();
    }
}