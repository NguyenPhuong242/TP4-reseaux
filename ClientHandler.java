import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements java.lang.Runnable {
    private Socket client;
    private String name;

    public ClientHandler(String name, Socket client) {
        this.client = client;
        this.name = name;
    }

    @Override
    public void run() {
        String messageToSend;
        String messageToReceive;
        try {
            Socket connectToServer = new Socket("localhost", 1234);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Acces au serveur: " + connectToServer.getRemoteSocketAddress() + " \n");

            while (true) {
                System.out.print("Entrez un message à envoyer au serveur : ");
                messageToSend = scanner.nextLine();

                OutputStream outputStream = connectToServer.getOutputStream();
                outputStream.write(messageToSend.getBytes());

                InputStream inputStream = connectToServer.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                messageToReceive = new String(buffer, 0, bytesRead);

                System.out.println("Message reçu du serveur: " + messageToReceive);
                // connectToServer.close();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
