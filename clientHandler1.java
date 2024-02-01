import java.net.*;


public class clientHandler1 {
    public static void main(String[] args) throws Exception {
        ClientHandler clientHandler1 = new ClientHandler("Client1" , new Socket("localhost", 1234));
        Thread thread = new Thread(clientHandler1);
        thread.start();
    }
}
