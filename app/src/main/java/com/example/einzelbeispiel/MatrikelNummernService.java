package com.example.einzelbeispiel;


import android.util.Log;

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

        outToServer.writeBytes(matNr + '\n');

        modified = inFromServer.readLine();

        clientSocket.close();

        return modified;
    }

    String checksumCount(String matNr){
        int querSumme = 0;

        try {
            int matNumberInt = Integer.parseInt(matNr);
            int temp = matNumberInt;

            //count a number of digits in the matriculation number
            int count = 0;
            while (temp != 0){
                temp /= 10;
                count++;
            }

            //create a buffer with digits
            int [] digitsMatNr = new int [count];

            for (int i = 0; i < count; i++){
                digitsMatNr[count-i-1] = matNumberInt%10;
                matNumberInt /= 10;
            }

            //take a digits and make either additions or substractions
            // what depends on the place where the particular digit is
            for(int i = 0; i < count; i++){
                if (i%2 == 0){
                    querSumme += digitsMatNr[i];
                } else
                    querSumme -= digitsMatNr[i];

            }
            if (querSumme%2 == 0){
                return "Quersumme " + querSumme + " ist gerade";
            } else
                return "Quersumme " + querSumme + " ist ungerade";

        } catch (NumberFormatException numEx){
            Log.e("TAG", "Wrong number format");
        }
        return "querSumme lässt sich leider nicht berechnet werden";
    }


}
