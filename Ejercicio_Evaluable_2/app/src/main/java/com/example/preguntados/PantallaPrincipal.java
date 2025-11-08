package com.example.preguntados;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaPrincipal extends AppCompatActivity {

    private VideoView videoView;
    private Button b1;
    EditText et;
    ImageButton iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        MediaPlayer sonidoIncorrecto = MediaPlayer.create(PantallaPrincipal.this, R.raw.musicafantasy);
        sonidoIncorrecto.setLooping(true);
        sonidoIncorrecto.start();

        b1 = findViewById(R.id.button7);
        et = findViewById(R.id.editTextText2);
        iv = findViewById(R.id.imageButton2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = et.getText().toString();
                int puntos = 0;

                Intent abrirPantalla = new Intent(PantallaPrincipal.this, Pregunta1.class);

                abrirPantalla.putExtra("nombreJugador", nombre);
                abrirPantalla.putExtra("puntosJugador", puntos);

                startActivity(abrirPantalla);
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(PantallaPrincipal.this);
                db.borrarTodo();
                Toast.makeText(PantallaPrincipal.this, "Ranking borrado correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        videoView = findViewById(R.id.videoView1);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fondoinicio);
        videoView.setVideoURI(videoUri);

        // Iniciar reproducción
        videoView.start();

        // Loop infinito
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }
}
