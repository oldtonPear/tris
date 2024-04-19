import java.net.Socket;
import java.net.SocketException;

public class Client implements Runnable{
    private Socket s;
    private String ip;
    private int port;

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
            port = Integer.parseInt(str);
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
            String turn = read();
            if(turn.equals("YOUR TURN")){
                System.out.println("YOUR TURN!!");
                try {
                    Thread.sleep(3000);
                    write("DONE");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Client running");
        init();
    }
}
