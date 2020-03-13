package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("10.10.201.189",4900);
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<10;++i) {
            String sent = scanner.nextLine();
            PrintWriter sentMessage = new PrintWriter(socket.getOutputStream());
            sentMessage.println(sent);
            sentMessage.flush();
            //---------------------------
            InputStreamReader getMessage = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(getMessage);
            String message = bufferedReader.readLine();
            System.out.println(message);
        }
    }
}
