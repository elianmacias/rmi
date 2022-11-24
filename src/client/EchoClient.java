package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import rmi.EchoInterface;

public class EchoClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EchoInterface servidorObj;
        String serverAddress = "localhost";
        int serverPort = 3232;
        try {
            Registry registry = LocateRegistry.getRegistry(serverAddress, serverPort);
            servidorObj = (EchoInterface) (registry.lookup("operacionservidor"));

            String input = "";
            while (!input.equals("fin")) {
                System.out.println("Ingresa un texto:");
                input = sc.nextLine();
                System.out.println(servidorObj.echo(input));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
