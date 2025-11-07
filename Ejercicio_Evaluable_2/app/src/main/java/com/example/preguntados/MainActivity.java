package com.example.preguntados;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        et = findViewById(R.id.editTextText);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = et.getText().toString();
                int puntos = 0;

                Intent abrirPantalla = new Intent(MainActivity.this, Geografia.class);

                abrirPantalla.putExtra("nombreJugador", nombre);
                abrirPantalla.putExtra("puntosJugador", puntos);

                startActivity(abrirPantalla);
            }
        });
    }
}