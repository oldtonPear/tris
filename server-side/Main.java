public class Main {
    public static void main(String[] args) throws Exception {
        Server s = new Server();
        Thread serverThread = new Thread(s);
        serverThread.start();
    }
}
