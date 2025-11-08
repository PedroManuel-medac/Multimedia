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

public class PantallaPerdedor extends AppCompatActivity {

    private TextView tv1, tvRanking;
    private Button b;
    private ImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_perdedor);

        tv1 = findViewById(R.id.textView11);
        tvRanking = findViewById(R.id.textView7);
        b = findViewById(R.id.button6);
        gifImageView = findViewById(R.id.imageView4);

        MediaPlayer sonidoPerdedor = MediaPlayer.create(PantallaPerdedor.this, R.raw.loserfinal);
        sonidoPerdedor.start();

        Intent intentRecibido = getIntent();
        String nombreJugador = intentRecibido.getStringExtra("nombreJugador");
        int puntosJugador = intentRecibido.getIntExtra("puntosJugador", 0);

        tv1.setText(nombreJugador + ", has obtenido " + puntosJugador + "/5 puntos");

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.insertarJugador(nombreJugador, puntosJugador);

        mostrarRanking(dbHelper);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantallaPrincipal = new Intent(PantallaPerdedor.this, PantallaPrincipal.class);
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
