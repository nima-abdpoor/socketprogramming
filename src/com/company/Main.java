package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(4900);
        Socket socket=serverSocket.accept();
        System.out.println("client connected");
        for (int i=0;i<10;++i) {
            InputStreamReader readMessage = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(readMessage);
            String Message = bufferedReader.readLine();
            System.out.println(Message);
            //--------------------------------------
            Scanner scanner = new Scanner(System.in);
            String sent = scanner.nextLine();
            PrintWriter sentMessage = new PrintWriter(socket.getOutputStream());
            sentMessage.println(sent);
            sentMessage.flush();
        }
    }
}
