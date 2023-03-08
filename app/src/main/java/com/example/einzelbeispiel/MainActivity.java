package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtMatrikelNr;
    Button antwortBtn;
    TextView antwortTxt = null;

    MatrikelNummernService matrikelNummernService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        txtMatrikelNr = findViewById(R.id.editMatrikelNr);
        antwortBtn = findViewById(R.id.antwortBtn);
        antwortTxt = findViewById(R.id.antwortTxt);

        matrikelNummernService = new MatrikelNummernService();

        antwortBtn.setOnClickListener(
                view -> {
                    String text = txtMatrikelNr.getText().toString();
                    try {
                        text = matrikelNummernService.antwortServer(text);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    antwortTxt.setText(text);
                }
        );

    }
}