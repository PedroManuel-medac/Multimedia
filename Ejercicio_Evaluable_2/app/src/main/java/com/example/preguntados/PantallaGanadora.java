package com.example.preguntados;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class PantallaGanadora extends AppCompatActivity {

    private TextView tv1;
    private Button b;
    private ImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ganadora);

        // Mostrar puntuación
        tv1 = findViewById(R.id.textView9);
        tv1.setText(Almacen.contador + "/5");
        b = findViewById(R.id.button5);

        // Mostrar GIF
        gifImageView = findViewById(R.id.imageView3);
        Glide.with(this)
                .asGif()
                .load(R.drawable.confetis) // tu archivo GIF en drawable
                .into(gifImageView);
    }
}
