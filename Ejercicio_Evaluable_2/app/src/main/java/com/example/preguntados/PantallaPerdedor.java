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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PantallaPerdedor extends AppCompatActivity {
    private TextView tv1;
    private Button b;
    private ImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_perdedor);

        // Mostrar puntuación
        tv1 = findViewById(R.id.textView11);
        tv1.setText(Almacen.contador + "/5");
        b = findViewById(R.id.button6);

        // Mostrar GIF
        gifImageView = findViewById(R.id.imageView4);
        Glide.with(this)
                .asGif()
                .load(R.drawable.loser) // tu archivo GIF en drawable
                .into(gifImageView);



    }

}