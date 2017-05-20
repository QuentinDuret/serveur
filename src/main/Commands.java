package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by sebde on 20/05/2017.
 */
public interface Commands extends Remote {

    String listIdea() throws RemoteException;

    String postIdea(String request) throws RemoteException;
}
