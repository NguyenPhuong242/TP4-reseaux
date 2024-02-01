import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    /* 
    public static void main(String[] args) throws Exception {
        ServerSocket TCPserver = new ServerSocket(1234);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Serveur démarré: " + TCPserver.getLocalSocketAddress());
        System.out.println("Serveur en attente de connexion \n");
        Socket server = TCPserver.accept();
        Code code = new Code(new Random());
        System.out.println(code.toString());
        int left = 10;
        int count = 0;

        if (server.isConnected())
            System.out.println("Client connecté \n");
        while (true) {

            InputStream inputStream = server.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String messageToReceive = new String(buffer, 0, bytesRead);
            System.out.println("Message reçu du client: " + messageToReceive);
            if (messageToReceive.equals(code.toString())) {
                System.out.println("Vous avez gagné");
                break;
            } else if (count == 9) {
                System.out.println("Vous avez perdu");
                break;
            } else {
                count++;
                System.out.println("Tentatives: " + count);
                System.out.println("Nombre de couleurs bien placées: "
                        + code.numberOfColorsWithCorrectPosition(new Code(messageToReceive)));
                System.out.println("Nombre de couleurs mal placées: "
                        + code.numberOfColorsWithIncorrectPosition(new Code(messageToReceive)));
                //System.out.print("Entrez un message à envoyer au client : ");
                //String messageToSend = scanner.nextLine();
                System.out.println("\n");
                String messageToSend = ("Faux\n" + "Tentitative: " + count + "\n" + "Nombre de couleurs bien placées: "
                        + code.numberOfColorsWithCorrectPosition(new Code(messageToReceive)) + "\n"
                        + "Nombre de couleurs mal placées: "
                        + code.numberOfColorsWithIncorrectPosition(new Code(messageToReceive)) + "\n");
                OutputStream outputStream = server.getOutputStream();
                outputStream.write(messageToSend.getBytes());

            }

            // server.close();
        }

    }
    */

    //Le serveur accepte multiple client:
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(1234);
        while(true){
            Socket client = server.accept();
            Thread t = new Thread(new ClientHandler("Client" + client.getPort(), client));
            t.start();
            
        }
        
        
    }

}
