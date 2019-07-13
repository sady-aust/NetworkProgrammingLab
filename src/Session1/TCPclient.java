package Session1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TCPclient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost",6789);
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outputWritter = new DataOutputStream(clientSocket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            String s = sc.nextLine();
            outputWritter.writeBytes(s+'\n');

            String modifiedString = inputReader.readLine();
            System.out.println("Modified String is- "+modifiedString);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
