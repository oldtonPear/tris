package com.company;

import java.io.IOException;

public class Main {
    private static Client c;

    public static void main(String[] args) {
        c = new Client(5050);
        request();
        c.close();
    }


    private static void request() {
        c.write("REQUEST");
        String s = c.listen();
        System.out.println(s);
        /*if(s.equals("5070") || s.equals("5090")){
            c.close();
            c = new Client(Integer.parseInt(s));
        }*/
    }
}
