import java.net.*;
public class clientHandler2 {
    public static void main(String[] args) throws Exception {
        ClientHandler clientHandler2 = new ClientHandler("Client2" , new Socket("localhost", 1234));
        Thread thread = new Thread(clientHandler2);
        thread.start();
    }
}
