package com.example.einzelbeispiel;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MatrikelNummernService extends Thread {

    static final String HOST = "se2-isys.aau.at";
    static final int PORT = 53212;


    //TODO: fix an output issue

    String antwortServer(String matNr) throws IOException {
        String modified;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket(HOST, PORT);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        matNr = inFromUser.readLine();

        outToServer.writeBytes(matNr + '\n');

        modified = inFromServer.readLine();

        clientSocket.close();

        return modified;
    }


}
