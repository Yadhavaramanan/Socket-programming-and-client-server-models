package server;
import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost and port 6666
            Socket socket = new Socket("localhost", 6666);
            
            // Prepare a DataOutputStream to send data to the server
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            // Write a message to the server
            dos.writeUTF("Hello, Server!");
            
            // Close the stream and socket
            dos.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
