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
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    EditText et;

    ImageButton iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        et = findViewById(R.id.editTextText);
        iv = findViewById(R.id.imageButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = et.getText().toString();
                int puntos = 0;

                Intent abrirPantalla = new Intent(MainActivity.this, PantallaPrincipal.class);

                abrirPantalla.putExtra("nombreJugador", nombre);
                abrirPantalla.putExtra("puntosJugador", puntos);

                startActivity(abrirPantalla);
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(MainActivity.this);
                db.borrarTodo();
                Toast.makeText(MainActivity.this, "Ranking borrado correctamente", Toast.LENGTH_SHORT).show();
            }
        });


    }
}