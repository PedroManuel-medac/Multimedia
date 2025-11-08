package com.example.preguntados;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Pregunta2 extends AppCompatActivity {

    private Button b2, b3, b4;
    private ImageView gifImageView;
    private ImageButton ib;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);

        ib = findViewById(R.id.imageButton4);
        tv = findViewById(R.id.textView10);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        gifImageView = findViewById(R.id.imageView);

        //Para el gif de la pregunta
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif2)
                .into(gifImageView);

        //Para el gif del mago pistas
        Glide.with(this)
                .asGif()
                .load(R.drawable.libro)
                .into(ib);

        Intent intentRecibido = getIntent();
        String nombreJugador = intentRecibido.getStringExtra("nombreJugador");
        int puntosJugador = intentRecibido.getIntExtra("puntosJugador", 0);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer sonidoIncorrecto = MediaPlayer.create(Pregunta2.this, R.raw.incorrecto);
                sonidoIncorrecto.start();

                b2.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(Pregunta2.this, R.color.rojo)
                ));

                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Pregunta2.this);
                    builder.setTitle("¡Respuesta incorrecta!");
                    builder.setMessage("La respuesta correcta es --> Campanas de plata");
                    builder.setPositiveButton("Aceptar", (dialog, which) -> {
                        dialog.dismiss();

                        Intent intent = new Intent(Pregunta2.this, Pregunta3.class);
                        intent.putExtra("nombreJugador", nombreJugador);
                        intent.putExtra("puntosJugador", puntosJugador);
                        startActivity(intent);
                    });
                    builder.show();
                }, 1000);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(Pregunta2.this, R.color.verde)
                ));

                MediaPlayer sonidoIncorrecto = MediaPlayer.create(Pregunta2.this, R.raw.correcto);
                sonidoIncorrecto.start();

                new Handler(Looper.getMainLooper()).postDelayed(() -> {

                    int nuevosPuntos = puntosJugador + 1;

                    Intent intent = new Intent(Pregunta2.this, Pregunta3.class);
                    intent.putExtra("nombreJugador", nombreJugador);
                    intent.putExtra("puntosJugador", nuevosPuntos);
                    startActivity(intent);
                }, 1000);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer sonidoIncorrecto = MediaPlayer.create(Pregunta2.this, R.raw.incorrecto);
                sonidoIncorrecto.start();

                b3.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(Pregunta2.this, R.color.rojo)
                ));

                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Pregunta2.this);
                    builder.setTitle("¡Respuesta incorrecta!");
                    builder.setMessage("La respuesta correcta es --> Campanas de plata");
                    builder.setPositiveButton("Aceptar", (dialog, which) -> {
                        dialog.dismiss();

                        Intent intent = new Intent(Pregunta2.this, Pregunta3.class);
                        intent.putExtra("nombreJugador", nombreJugador);
                        intent.putExtra("puntosJugador", puntosJugador);
                        startActivity(intent);
                    });
                    builder.show();
                }, 1000);
            }
        });

        String pista2 = "El metal que canta espanta lo que camina sin alma.";
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(pista2);
            }
        });
    }
}
