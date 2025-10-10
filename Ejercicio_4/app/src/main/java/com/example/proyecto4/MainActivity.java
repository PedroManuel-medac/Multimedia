package com.example.proyecto4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private TextView contadorTextView;
    private Button botonContar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorTextView = findViewById(R.id.textView1);
        botonContar = findViewById(R.id.button1);

        botonContar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                contador++;
                contadorTextView.setText(Integer.toString(contador));
            }
        });
    }



}