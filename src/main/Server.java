package main;

import main.ideas.Ideas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    private int port = 8080;
    private String host = "127.0.0.1";
    private ServerSocket server = null;
    private boolean isRunning = true;
    private Ideas ideas;

    public Server(){
        try {
            server = new ServerSocket(port, 100, InetAddress.getByName(host));
            ideas=new Ideas();
        }

        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server(String host, int port){
        this.host = host;
        this.port = port;
        ideas=new Ideas();
        try {
            server = new ServerSocket(port, 100, InetAddress.getByName(host));
        }

        catch (UnknownHostException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open(){

        Thread t = new Thread(new Runnable(){

            public void run(){
                while(isRunning == true){

                    try {
                        Socket client = server.accept();
                        System.out.println("Connecté");

                        System.out.println("Client connecter au serveur");
                        Thread thread = new Thread(new ReceiveClientRequest(client,ideas));
                        thread.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    server = null;
                }
            }
        });
        t.start();
    }

}