public abstract class PlayersHandler {

    private static String board = "";

    private static boolean playerFound = false;

    public static synchronized boolean isPlayerFound() {
        return playerFound;
    }

    public static synchronized void setPlayerFound(boolean value) {
        playerFound = value;
    }

    public static synchronized void setBoard(String newBoard) {
        board = newBoard;
        int winner = checkWin();
        if(winner != 0){
            board = winner + "";
        }
        System.out.println(board);
        System.out.println(winner);
    }

    public static synchronized String getBoard() {
        return board;
    }

    private static int checkWin() {
        char[][] mat = {
            {board.charAt(0), board.charAt(1), board.charAt(2)},
            {board.charAt(3), board.charAt(4), board.charAt(5)},
            {board.charAt(6), board.charAt(7), board.charAt(8)}
        };
        char playerWon = ' ';
        
        for (int i = 0; i < 3; i += 3) {
            boolean condition1 = (mat[i][0] != 'N' && mat[i][0] == mat[i][1] && mat[i][0] == mat[i][2]);
            boolean condition2 = (mat[0][i] != 'N' && mat[0][i] == mat[1][i] && mat[0][i] == mat[2][i]);
            if (condition1) playerWon = mat[i][0];
            if (condition2) playerWon = mat[0][1];
        }

        boolean condition1 = (mat[0][0] != 'N' && mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2]);
        boolean condition2 = (mat[0][2] != 'N' && mat[0][2] == mat[1][1] && mat[0][2] == mat[2][0]);
        if (condition1) playerWon = mat[0][0];
        if (condition2) playerWon = mat[0][2];
        
        if (playerWon != ' ') {
            return playerWon == 'X' ? 1 : 2;
        }
        
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == 'N') return 0;
        }
        return 3;
    }
}
