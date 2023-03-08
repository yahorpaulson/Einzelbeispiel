package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtMatrikelNr;
    Button antwortBtn;
    TextView antwortTxt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtMatrikelNr = findViewById(R.id.editMatrikelNr);
        antwortBtn = findViewById(R.id.antwortBtn);
        antwortTxt = findViewById(R.id.antwortTxt);


        //Text verknüpfen
        String text = txtMatrikelNr.getText().toString();



        //Button verknüpfen
        antwortBtn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        antwortTxt.setText("Hello World!");
                    }
                }
        );

    }
}