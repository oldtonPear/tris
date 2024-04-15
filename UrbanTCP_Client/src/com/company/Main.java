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
        try {
            c.write("REQUEST");
            String s = c.listen();
            System.out.println(s);
            c = new Client(Integer.parseInt(s));
        } catch (Exception e) {
            return;
        }
    }
}
