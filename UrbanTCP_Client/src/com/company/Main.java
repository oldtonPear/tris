package com.company;

public class Main {
    private static Client c;

    public static void main(String[] args) {
        c = new Client();
        request();
        c.close();
    }


    private static void request() {
        //c.write("REQUEST");
        //String s = c.listen();

        //System.out.println(s);
    }
}
