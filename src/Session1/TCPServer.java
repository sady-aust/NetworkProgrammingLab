package Session1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6789);
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outputWritter = new DataOutputStream(connectionSocket.getOutputStream());

            String clientMessage = inputReader.readLine();
            System.out.println("Client Message Is "+clientMessage);

            String outputMessage = clientMessage.toUpperCase();
            outputWritter.writeBytes(outputMessage+'\n');

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
