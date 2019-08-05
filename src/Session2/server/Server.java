/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author student
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {            
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("One client connected "+connectionSocket);
            DataOutputStream dos = new DataOutputStream(connectionSocket.getOutputStream());
            DataInputStream  dis= new DataInputStream(connectionSocket.getInputStream());
            ClientHandler t = new ClientHandler(connectionSocket,dos,dis);
            t.start();
            
        }
     
    }
}
