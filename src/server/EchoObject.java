package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import rmi.EchoInterface;

public class EchoObject extends UnicastRemoteObject implements EchoInterface {

    String myURL = "localhost";

    public EchoObject() throws RemoteException {
        try {
            myURL = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            myURL = "localhost";
        }
    }

    @Override
    public String echo(String input) throws RemoteException {
        Date h = new Date();
        String fecha = DateFormat.getTimeInstance(3, Locale.ENGLISH).format(h);
        String ret = myURL + ":" + fecha + "> " + input;
        try {
            Thread.sleep(3000);
            ret = ret + " (retrasada 3 segundos)";
        } catch (InterruptedException e) {
            e.getMessage();
        }

        return ret;
    }
}
