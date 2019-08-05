package Session2.Online;
import java.io.*;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            while (true) {
                Socket mySocket = serverSocket.accept();
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                DataOutputStream outputWritter = new DataOutputStream(mySocket.getOutputStream());

                String s = inputReader.readLine();
                System.out.println(s);
                if (s.equals("stop")) {
                    outputWritter.writeBytes("Ok" + "\n");
                    mySocket.close();
                    break;
                } else if (s.equals("start")) {
                    outputWritter.writeBytes("enter a string" + "\n");
                    String userInput = inputReader.readLine();
                    System.out.println(userInput);
                    int c = noOfVowel(userInput.toLowerCase());
                    outputWritter.writeBytes("No of Vowel " + c + "\n");
                }
            }

        } catch (Exception e) {

        }
    }

    static int noOfVowel(String s) {
        ArrayList<Character> vowel = new ArrayList<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            if (vowel.contains(s.charAt(i))) {
                c++;
            }
        }

        return c;
    }

}
