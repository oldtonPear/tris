public class Shared_board {
    public String board;

    Shared_board(){
        board = "NNNNNNNNN";
    }

    public synchronized void setBoard(String board) {
        this.board = board;
    }
    public synchronized String getBoard() {
        return board;
    }
}
