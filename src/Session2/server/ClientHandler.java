/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class ClientHandler extends Thread {

    final Socket connectionSocket;
    final DataOutputStream dos;
    final DataInputStream dis;

    ClientHandler(Socket connectionSocket, DataOutputStream dos, DataInputStream dis) {
        this.dis = dis;
        this.dos = dos;
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        System.out.println("Thread Started for client");
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        try {
            while (true) {
                String clientSentence = br.readLine();
                System.out.println("From Client: " + clientSentence);
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
