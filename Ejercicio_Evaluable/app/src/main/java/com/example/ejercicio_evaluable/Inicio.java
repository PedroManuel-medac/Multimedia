package com.example.ejercicio_evaluable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


    }

    public void portada1 (){
        Intent uvst = new Intent(Inicio.this, unveranosinti.class);
        startActivity(uvst);
    }
}