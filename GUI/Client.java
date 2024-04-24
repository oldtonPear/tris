import java.net.Socket;
import java.net.SocketException;

public class Client implements Runnable{
    private Socket s;
    private String ip;
    private int port;
    private int player;

    Client(int port, String ip){
        this.ip = ip;
        this.port = port;
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
        while(s.isConnected()){
            String board = read();
            System.out.println(board);
            board = board.concat("a");
            write(board);
        }
    }

    @Override
    public void run() {
        System.out.println("Client running");
        init();
    }
}