package Session2.Online;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            while (true) {
                Socket clientSOket = new Socket("localhost", 6789);
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSOket.getInputStream()));
                DataOutputStream outputWritter = new DataOutputStream(clientSOket.getOutputStream());
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                outputWritter.writeBytes(s + "\n");

                String cmd = inputReader.readLine();
                System.out.println(cmd);
                if (cmd.equals("enter a string")) {
                    String msg = sc.nextLine();
                    outputWritter.writeBytes(msg + "\n");

                    String fOutput = inputReader.readLine();
                    System.out.println(fOutput);

                } else if (cmd.equals("OK")) {
                    clientSOket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
