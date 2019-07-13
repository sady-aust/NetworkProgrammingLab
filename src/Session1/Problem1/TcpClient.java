package Session1.Problem1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost",6789);
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outputWritter = new DataOutputStream(clientSocket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter your values");
            String input = sc.nextLine();

            outputWritter.writeBytes(input+"\n");

            String result = inputReader.readLine();
            System.out.println("Result from Server "+result);

            clientSocket.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
