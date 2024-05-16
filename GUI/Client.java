import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;

public class Client implements Runnable, Observable{
    private Socket s;
    private String ip;
    private int port;
    private int player;
    private String board;
    private Shared_board sh;
    private LinkedList<Observer> observers;

    Client(int port, String ip){
        this.ip = ip;
        this.port = port;
        observers = new LinkedList<>();
    }

    public void write(String string) {
        if (!outputCheck()) return;
        try {
            SocketIO.pw.write(string + '\n');
            SocketIO.pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String listen(){
        String s = "";
        while (s.equals("")) {
            s = read();
        }
        return s;
    }

    public String read() {
        if (!inputCheck()) return "Null";
        try {
            String s = SocketIO.br.readLine();
            return (s == null ? "" : s);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
            
        }
    }

    public void setTimeOut(int n) throws SocketException {
        s.setSoTimeout(n);
    }

    public boolean isConnected() {
        return s.isConnected() && !s.isClosed();
    }

    public boolean inputCheck() {
        return isConnected() && !s.isInputShutdown();
    }

    public boolean outputCheck() {
        return isConnected() && !s.isOutputShutdown();
    }

    public void init() {
        try {
            s = new Socket(ip, port);
            SocketIO.init(s);
            String str = listen();
            System.out.println(str);
            int initPort = port;
            port = Integer.parseInt(str);
            player = port - initPort;
            System.out.println("I'M PLAYER " + player);
            close();
            s = new Socket(ip, port);
            SocketIO.init(s);
            online();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            s.close();
            s = null;
            SocketIO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void online(){
        board = read();
        System.out.println("Board ricevuta:" + board);
        sh.setBoard(board);
        notifyObservers();
        while(board.equals(sh.getBoard())){}
        board = sh.getBoard();
        write(board);
        System.out.println("Board inviata: " + board);
        if(!board.equals("OK")) online();
        else close();
    }

    @Override
    public void run() {
        init();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }
    @Override
    public void notifyObservers() {
        observers.getFirst().update();
    }

    public String getBoard() {
        return board;
    }
    public void setBoard(String board) {
        this.board = board;
    }
    public void setSh(Shared_board sh) {
        this.sh = sh;
    }
    public int getPlayer() {
        return player;
    }
}
