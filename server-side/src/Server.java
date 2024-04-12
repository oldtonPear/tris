public class Server implements Observer{
    private int[][] board = {
        {-1, -1, -1}, 
        {-1, -1, -1},
        {-1, -1, -1}
      };

    private ServerThread[] serverThreads;
    private Thread[] threads;

    Server(){
        serverThreads = new ServerThread[2];
        threads = new Thread[2];
        serverThreads[0] = new ServerThread();
        threads[0] = new Thread(serverThreads[0]);
        threads[0].start();
        serverThreads[0].register(this);
    }

    @Override
    public void updateObserver(String code) {

        switch (code) {
            case "PLAYER FOUND" -> {
                if(serverThreads[1] != null){
                    serverThreads[0].online();
                    serverThreads[1].offline();
                    return;
                }
                serverThreads[1] = new ServerThread();
                threads[1] = new Thread(serverThreads[1]);
                threads[1].start();
                serverThreads[1].register(this);
            }
            case "CHANGE TURN" -> {
                System.out.println("changing turn");
            }
        }
    }
}