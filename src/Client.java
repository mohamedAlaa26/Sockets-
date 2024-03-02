import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 12345;

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Connected to server on port " + SERVER_PORT);

            // Create input/output streams for communication with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nPlease enter the message you want to send to the server :\n");
            String inputString = scanner.nextLine();
            // Send a message to the server
            out.println(inputString);

            // Receive and display the server's response
            String response = in.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}
