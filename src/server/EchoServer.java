package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.EchoInterface;

public class EchoServer {

    public static void main(String[] args) throws Exception {
        int PUERTO = 3232;
        try {
            System.out.println("Servidor escuchando en el puerto " + PUERTO);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            EchoInterface stub = new EchoObject();
            registry.bind("operacionservidor", (EchoInterface) stub);
        } catch (RemoteException e) {
            e.getMessage();
            System.err.println("Ocurrio algo malo en el extremo remoto" + " " + e.toString());
            System.exit(-1);
        }
    }
}