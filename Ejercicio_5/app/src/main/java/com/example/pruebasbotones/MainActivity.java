package com.example.pruebasbotones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private ConstraintLayout cl;

    private Button bl;
    private CheckBox cb;

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
        bl = findViewById(R.id.buttonLog);
        cb = findViewById(R.id.checkBox1);

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
                                              int randomColor = Color.rgb ((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256));
                                              tv1.setBackgroundColor(randomColor);

                                          }
                                      });

        b4.setOnClickListener(v ->{
            Toast.makeText(this,"boton pulsado", Toast.LENGTH_SHORT).show();

    });


        bl.setOnClickListener(new
                                      View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              System.out.println(cb.isChecked());
                                              Log.e("MainActivity", "El check está: " +cb.isChecked());
                                          }
                                      });



    }
}