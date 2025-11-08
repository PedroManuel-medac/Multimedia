package com.example.preguntados;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class PantallaGanadora extends AppCompatActivity {

    private TextView tv1, tvRanking;
    private Button b;
    private ImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ganadora);

        tv1 = findViewById(R.id.textView9);
        tvRanking = findViewById(R.id.textView6); // nuevo TextView en el XML
        b = findViewById(R.id.button5);
        gifImageView = findViewById(R.id.imageView3);

        //Para el gif de la copa
        Glide.with(this)
                .asGif()
                .load(R.drawable.copa)
                .into(gifImageView);

        // Reproducir sonido ganador
        MediaPlayer sonidoGanador = MediaPlayer.create(PantallaGanadora.this, R.raw.ganadorfinal);
        sonidoGanador.start();

        // Recibir nombre y puntos desde el Intent
        Intent intentRecibido = getIntent();
        String nombreJugador = intentRecibido.getStringExtra("nombreJugador");
        int puntosJugador = intentRecibido.getIntExtra("puntosJugador", 0);

        // Mostrar texto de puntuación
        tv1.setText(nombreJugador + " has obtenido " + puntosJugador + "/5 puntos");

        // Guardar en la base de datos
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.insertarJugador(nombreJugador, puntosJugador);

        // Mostrar el ranking completo
        mostrarRanking(dbHelper);


        // Botón para volver al inicio
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantallaPrincipal = new Intent(PantallaGanadora.this, PantallaPrincipal.class);
                startActivity(pantallaPrincipal);
                finish();
            }
        });
    }

    private void mostrarRanking(DatabaseHelper dbHelper) {
        Cursor cursor = dbHelper.obtenerRanking();
        StringBuilder rankingTexto = new StringBuilder("🏆 RANKING 🏆\n\n");
        int posicion = 1;

        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            int puntos = cursor.getInt(cursor.getColumnIndexOrThrow("puntos"));

            rankingTexto
                    .append(posicion)
                    .append(". ")
                    .append(nombre)
                    .append(" - ")
                    .append(puntos)
                    .append(" puntos\n");

            posicion++;
        }

        cursor.close();
        tvRanking.setText(rankingTexto.toString());
    }
}
