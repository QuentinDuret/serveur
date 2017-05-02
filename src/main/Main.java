package main;


public class Main {

    public static void main(String[] args) {

        String host = "10.212.126.230";
        int port = 1234;

        Server ts = new Server(host, port);
        ts.open();

        System.out.println("Serveur initialisé.");

    }
}