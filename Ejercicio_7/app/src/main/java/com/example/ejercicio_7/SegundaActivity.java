package com.example.ejercicio_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView tv1, tv2;
    private Button b1, b2;

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tv1 = findViewById(R.id.textView4);
        tv2 = findViewById(R.id.textView5);
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button3);

        //MÉTODO 1 PARA RECOGER DATOS
        /*
        //Obtener el intent y el valor "palabra"
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("Nombre");
        String apellido = intent.getStringExtra("Apellido");

        //Inserta el nombre y apellido
        tv1.setText(nombre);
        tv2.setText(apellido);
        */

        //MÉTODO 2 PARA RECOGER DATOS (CLASE STATIC)
        /*
        tv1.setText(Almacen.getNombre());
        tv2.setText(Almacen.getApellido());
        */

        //MÉTODO 3 PARA RECOGER DATOS (SHAREDPREFERENCES)
        SharedPreferences pf = getSharedPreferences("Datos", MODE_PRIVATE);

        tv1.setText(pf.getString("nombre", ""));
        tv2.setText(pf.getString("Apellido", ""));


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirPantalla = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(abrirPantalla);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(SegundaActivity.this, R.raw.iphonenotificacion2);
                mp.start();
            }
        });

    }
}