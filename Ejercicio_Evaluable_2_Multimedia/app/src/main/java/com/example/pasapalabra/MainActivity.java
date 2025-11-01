package com.example.pasapalabra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    EditText nombre;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para la musica de fondo
        mp = MediaPlayer.create(this, R.raw.musicafondo);
        mp.setLooping(true);
        mp.start();

        //Recogemos datos
        nombre = findViewById(R.id.editTextText2);
        boton = findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUsuario = nombre.getText().toString();

                Intent intent = new Intent(MainActivity.this, Inicio.class);
                intent.putExtra("nombre", nombreUsuario);
                startActivity(intent);
            }
        });
    }
}