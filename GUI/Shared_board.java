public class Shared_board {
    public String board;

    Shared_board(){
        board = "-1,-1,-1,-1,-1,-1,-1,-1,-1";
    }

    public synchronized void setBoard(String board) {
        this.board = board;
    }
    public synchronized String getBoard() {
        return board;
    }
}
