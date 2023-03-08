package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText txtMatrikelNr;
        Button antwortBtn;

        txtMatrikelNr = findViewById(R.id.editMatrikelNr);
        antwortBtn = findViewById(R.id.antwortBtn);


        //Text verknüpfen
        String text = txtMatrikelNr.getText().toString();


        //Button verknüpfen
        antwortBtn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        //TODO: Fuktionalität fürs Button
                    }
                }
        );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}