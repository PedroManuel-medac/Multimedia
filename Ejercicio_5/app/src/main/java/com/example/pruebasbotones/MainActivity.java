package com.example.pruebasbotones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private ConstraintLayout cl;

    int tamanio = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.helloworld);
        b1 = findViewById(R.id.botonAumentar);
        b2 = findViewById(R.id.botonDisminuir);
        b3 = findViewById(R.id.botonFondo);
        b4 = findViewById(R.id.botonToast);
        cl = findViewById(R.id.fondo1);

        b1.setOnClickListener(new
                                      View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              tv1.setTextSize(tamanio);
                                              tamanio++;
                                          }
                                      });

        b2.setOnClickListener(new
                                      View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              tv1.setTextSize(tamanio);
                                              tamanio--;
                                          }
                                      });

        b3.setOnClickListener(new
                                      View.OnClickListener(){
                                          @Override
                                          public void onClick(View v){

                                          }
                                      });

        b4.setOnClickListener(v ->{
            Toast.makeText(this,"boton pulsado", Toast.LENGTH_SHORT).show();

    });



    }
}