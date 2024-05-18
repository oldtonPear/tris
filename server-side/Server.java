public class Server extends Thread{

    private ControllerThread controller;
    private int controllerPort;
    private boolean close = false;

    private ServerThread[] serverThreads;

    Server(int port){
        controllerPort = port;
        serverThreads = new ServerThread[2];
        controller = new ControllerThread(controllerPort);
        controller.start();
    }

    Server(){
        controllerPort = 5050;
        serverThreads = new ServerThread[2];
        controller = new ControllerThread(controllerPort);
        controller.start();
    }

    @Override
    public void run() {
        System.out.println("SERVER ONLINE!");
        while(true){
            if(PlayersHandler.isPlayerFound()){
                if(serverThreads[0] == null){
                    serverThreads[0] = new ServerThread(controllerPort+1);
                    serverThreads[0].start();
                    controller.manageOutput(controllerPort+1 + "");
                }
                else if(serverThreads[1] == null){
                    serverThreads[1] = new ServerThread(controllerPort+2);
                    serverThreads[1].start();
                    serverThreads[0].setBoard("0NNNNNNNN");
                    PlayersHandler.setBoard("NNNNNNNNN");
                    controller.manageOutput(controllerPort+2 + "");
                }else{
                    controller.manageOutput("Ports already occupied!!");
                }
            }
            if (close) break;
        }
    }

    public void dispose(){
        controller.setClose();
        if (controller != null) controller.dispose();
        synchronized (this) {close = true;}
    }
}