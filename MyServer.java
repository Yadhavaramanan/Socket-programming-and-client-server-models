package server;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        DataInputStream dis = null;

        try {
            ss = new ServerSocket(6666);
            System.out.println("Server is waiting for a client...");

            // Accept a client connection
            socket = ss.accept();
            System.out.println("Client connected.");

            // Get input stream from the client socket
            dis = new DataInputStream(socket.getInputStream());

            // Read UTF data from the client
            String str = dis.readUTF();
            System.out.println("Message from client: " + str);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (dis != null) dis.close();
                if (socket != null) socket.close();
                if (ss != null) ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

	