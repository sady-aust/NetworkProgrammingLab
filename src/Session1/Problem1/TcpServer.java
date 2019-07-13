package Session1.Problem1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            while (true){
                Socket connectionSocket = serverSocket.accept();

                BufferedReader inputReader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outputStream = new DataOutputStream(connectionSocket.getOutputStream());

                String inputMessage = inputReader.readLine();
                String[] values = inputMessage.split(":");

                String output = Integer.toString(doCalculation(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2])));

                outputStream.writeBytes(output+"\n");
                connectionSocket.close();
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static int doCalculation(String value, int value1, int value2) {
        switch (value){
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value1 / value2;
            default:
                return 0;
        }

    }
}
