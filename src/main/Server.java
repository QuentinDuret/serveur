package main;

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

    public Server(){
        try {
            server = new ServerSocket(port, 100, InetAddress.getByName(host));
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

                        System.out.println("Client connecter au serveur");
                        Thread thread = new Thread(new ReceiveClientRequest(client));
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