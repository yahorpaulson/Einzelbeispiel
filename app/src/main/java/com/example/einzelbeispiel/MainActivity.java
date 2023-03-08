package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtMatrikelNr;
    Button btn1;
    Button btn2;
    TextView antwortTxt = null;

    MatrikelNummernService matrikelNummernService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        txtMatrikelNr = findViewById(R.id.editMatrikelNr);

        btn1 = findViewById(R.id.antwortBtn1);
        btn2 = findViewById(R.id.antwortBtn2);
        antwortTxt = findViewById(R.id.antwortTxt);

        matrikelNummernService = new MatrikelNummernService();
        btn1.setOnClickListener(
                view -> {
                    antwortTxt.setText("");
                    String text = txtMatrikelNr.getText().toString();
                    try {
                        String serverAntwort = matrikelNummernService.antwortServer(
                                String.valueOf(Integer.parseInt(text)));
                        antwortTxt.setText(serverAntwort);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        btn2.setOnClickListener(
                view -> {
                    antwortTxt.setText("");
                    String text = txtMatrikelNr.getText().toString();
                    text = String.valueOf(matrikelNummernService.checksumCount(text));
                    antwortTxt.setText(text);
                }
        );

    }
}