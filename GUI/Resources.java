public class Resources {
    private String board;
    Resources(){
        board = "";
    }
    public synchronized void setBoard(String board) {
        this.board = board;
    }
    public synchronized String getBoard() {
        return board;
    }
}
