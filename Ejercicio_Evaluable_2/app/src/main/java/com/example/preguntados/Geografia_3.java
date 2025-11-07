package com.example.preguntados;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

public class Geografia_3 extends AppCompatActivity {

    private Button b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geografia3);

        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        Intent intentRecibido = getIntent();
        String nombreJugador = intentRecibido.getStringExtra("nombreJugador");
        int puntosJugador = intentRecibido.getIntExtra("puntosJugador", 0);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer sonidoIncorrecto = MediaPlayer.create(Geografia_3.this, R.raw.incorrecto);
                sonidoIncorrecto.start();

                b2.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(Geografia_3.this, R.color.rojo)
                ));
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Geografia_3.this);
                    builder.setTitle("¡Respuesta incorrecta!");
                    builder.setMessage("La respuesta correcta es --> Augusto");
                    builder.setPositiveButton("Aceptar", (dialog, which) -> {
                        dialog.dismiss();
                        Intent intent = new Intent(Geografia_3.this, Geografia_4.class);
                        intent.putExtra("nombreJugador", nombreJugador);
                        intent.putExtra("puntosJugador", puntosJugador);
                        startActivity(intent);
                    });
                    builder.show();
                }, 1000);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(Geografia_3.this, R.color.verde)
                ));

                MediaPlayer sonidoIncorrecto = MediaPlayer.create(Geografia_3.this, R.raw.correcto);
                sonidoIncorrecto.start();

                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    int nuevosPuntos = puntosJugador + 1;
                    Intent intent = new Intent(Geografia_3.this, Geografia_4.class);
                    intent.putExtra("nombreJugador", nombreJugador);
                    intent.putExtra("puntosJugador", nuevosPuntos);
                    startActivity(intent);
                }, 1000);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer sonidoIncorrecto = MediaPlayer.create(Geografia_3.this, R.raw.incorrecto);
                sonidoIncorrecto.start();

                b4.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(Geografia_3.this, R.color.rojo)
                ));
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Geografia_3.this);
                    builder.setTitle("¡Respuesta incorrecta!");
                    builder.setMessage("La respuesta correcta es --> Augusto");
                    builder.setPositiveButton("Aceptar", (dialog, which) -> {
                        dialog.dismiss();
                        Intent intent = new Intent(Geografia_3.this, Geografia_4.class);
                        intent.putExtra("nombreJugador", nombreJugador);
                        intent.putExtra("puntosJugador", puntosJugador);
                        startActivity(intent);
                    });
                    builder.show();
                }, 1000);
            }
        });
    }
}
