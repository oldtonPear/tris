public class PlayersHandler {

    private int turnPlayerPort;

    private int port1, port2;

    private boolean secondPlayerConnected = false;

    PlayersHandler(int port1, int port2){
        this.port1 = port1;
        this.port2 = port2;
    }

    public void changeTurn(){
        if (turnPlayerPort == port1) {
            turnPlayerPort = port2;
            return;
        }
        turnPlayerPort = port1;
    }

    public synchronized void setTurnPlayerPort(int turnPlayerPort) {
        this.turnPlayerPort = turnPlayerPort;
    }
    public synchronized int getTurnPlayerPort() {
        return turnPlayerPort;
    }

    public synchronized boolean isSecondPlayerConnected() {
        return secondPlayerConnected;
    }
    public synchronized void setSecondPlayerConnected(boolean secondPlayerConnected) {
        this.secondPlayerConnected = secondPlayerConnected;
    }
}
