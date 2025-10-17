package com.example.ejercicio_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;

    private EditText e1;
    private EditText e2;
    private EditText e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        boton3 = findViewById(R.id.button3);
        boton4 = findViewById(R.id.button4);

        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editTextText2);
        e3 = findViewById(R.id.editTextText3);



        //Botón teléfono
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tlf = new Intent(Intent.ACTION_DIAL);
                tlf.setData(Uri.parse("tel: " + e1.getText()));
                startActivity(tlf);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tlf = new Intent(Intent.ACTION_SENDTO);
                tlf.setData(Uri.parse("mailto: " + e2.getText()));
                startActivity(tlf);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tres = new Intent(Intent.ACTION_VIEW);
                tres.setData(Uri.parse(e3.getText().toString()));
                startActivity(tres);
            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ubi = "geo: 37.7681,-3.7903";

                Intent cuatro = new Intent(Intent.ACTION_VIEW);
                cuatro.setData(Uri.parse(ubi));
                startActivity(cuatro);
            }
        });

    }
}