package com.example.ejercicio_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText e1, e2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Recojo los textos escritos en el campo
                String nombre = e1.getText().toString();
                String apellido = e2.getText().toString();


                //MÉTODO 1 PARA PASAR DATOS


                /*
                //Enviar datos con el método putExtra
                abrirPantalla.putExtra("Nombre", nombre);
                abrirPantalla.putExtra("Apellido", apellido);
                */

                //MÉTODO 2 PARA PASAR DATOS (CLASE STATIC)
                /*
                Almacen.setNombre(nombre);
                Almacen.setApellido(apellido);
                */

                //MÉTODO 3 SharedPreferences (XML)
                SharedPreferences sp = getSharedPreferences("Datos", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("nombre", nombre);
                editor.putString("apellido", apellido);
                editor.apply();

                //Creo un intent para que lance la segunda pantalla
                Intent abrirPantalla = new Intent(MainActivity.this, SegundaActivity.class);
                //Se inicia la activity
                startActivity(abrirPantalla);

            }
        });

    }
}