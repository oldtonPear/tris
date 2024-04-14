package com.company;

import java.net.Socket;
import java.net.SocketException;
import java.net.InetAddress;

public class Client {
    private Socket s;
    private int port;

    Client(int port){
        this.port = port;
        init();
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
            s = new Socket("127.0.0.1", port);
            if (s.isConnected()) System.out.println("Socket connected");
            SocketIO.init(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            s.close();
            SocketIO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
