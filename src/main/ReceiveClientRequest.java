package main;

import main.commands.Parser;
import main.commands.PostIdea;
import main.enums.EnumCommands;
import main.ideas.Ideas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ReceiveClientRequest implements Runnable{


    private Socket sock;
    private BufferedInputStream reader = null;
    private Ideas ideas;

    public ReceiveClientRequest(Socket sock,Ideas ideas){
        this.sock = sock;
        this.ideas=ideas;
    }

    public void run(){
        System.err.println("Lancement de la commande du client");

        boolean closeConnexion = false;

        while(!sock.isClosed()){

            try {

                reader = new BufferedInputStream(sock.getInputStream());
                String response = read();
                Parser parser= EnumCommands.valueOf(response.split("\\$")[0]).toCommand();

                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(sock.getOutputStream());
                bufferedOutputStream.write(parser.read(response,ideas).getBytes());
                bufferedOutputStream.flush();


                if(closeConnexion){
                    System.out.println("commande close  ");
                    reader = null;
                    sock.close();
                    break;
                }
            }catch(SocketException e){
                System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String read() throws IOException{
        String response;
        int stream;
        byte[] b = new byte[1000];
        stream = reader.read(b);
        response = new String(b, 0, stream);
        return response;
    }

}