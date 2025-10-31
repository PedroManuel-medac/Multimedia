package com.example.ejercicio_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText e1, e2;
    private Button b;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        b = findViewById(R.id.button);

        //Inicializamos el helper de base de datos
        dbHelper = new DatabaseHelper(this);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Tnombre = e1.getText().toString();
                String Tapellido = e2.getText().toString();

                boolean existe = dbHelper.existeProfesor(Tnombre, Tapellido);
                if (existe){
                    Toast.makeText(MainActivity.this, "Profesor encontrado", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "Profesor no encontrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}