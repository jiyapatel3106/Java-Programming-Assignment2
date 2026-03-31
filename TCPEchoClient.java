import java.io.*;
import java.net.*;

public class TCPEchoClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server.");

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String message;

            while (true) {
                System.out.print("Enter message: ");
                message = userInput.readLine();

                output.println(message);

                String response = input.readLine();
                System.out.println("Server: " + response);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}