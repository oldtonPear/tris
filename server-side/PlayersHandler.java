public class PlayersHandler {

    private String board = "";

    private boolean playerFound = false;

    public synchronized boolean isPlayerFound() {
        return playerFound;
    }
    public synchronized void setPlayerFound(boolean playerFound) {
        this.playerFound = playerFound;
    }

    public synchronized void setBoard(String board){
        this.board = board;
    }
    public synchronized String getBoard() {
        return board;
    }
}
 