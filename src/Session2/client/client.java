/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class client {

    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 6789);
        System.out.println("Connected to server");

        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));

        while (true) {
            Scanner sc = new Scanner(System.in);
            String input_string = sc.nextLine();
            dos.writeBytes(input_string + "\n");
        }

    }
}
