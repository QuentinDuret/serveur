package main;

import main.commands.ListIdea;
import main.commands.PostIdea;
import main.ideas.Ideas;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by sebde on 20/05/2017.
 */
public class MainRMI implements Commands{

    Ideas ideas;

    public MainRMI(){
        ideas=new Ideas();
    }

    public static void main(String arg[]){
        int port=1234;
        String host="locahost";
        try{
            MainRMI obj =new MainRMI();
            Commands stub=(Commands) UnicastRemoteObject.exportObject(obj,0);

            Registry registry= LocateRegistry.createRegistry(port);
            registry.bind("LISTIDEA",stub);
            registry.bind("POSTIDEA",stub);

            System.out.println("Server open");
        }catch (Exception e){}

    }

    public String listIdea() throws RemoteException {
        System.out.println("command: LISTIDEA");
        return new ListIdea().read("",ideas);
    }

    public String postIdea(String request) throws RemoteException {
        System.out.println("command: POSTIDEA");
        return new PostIdea().read(request,ideas);
    }
}
