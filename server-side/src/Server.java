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
        Thread[] threads = new Thread[2];
        serverThreads[0] = new ServerThread();
        threads[0] = new Thread();
        threads[0].start();
        serverThreads[0].register(this);
    }

    @Override
    public void updateObserver(String code) {

        if(serverThreads[1] != null && code.equals("Player found")){
            for (int i = 0; i < serverThreads.length; i++) {
                serverThreads[i].online(i);
            }
            return;
        }

        switch (code) {
            case "Player found" -> {
                serverThreads[1] = new ServerThread();
                threads[1] = new Thread();
                threads[1].start();
                serverThreads[1].register(this);
            }  

        }
    }
}