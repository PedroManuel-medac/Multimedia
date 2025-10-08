package com.example.ejercicio_evaluable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void comprobar(View v) {

        FirebaseAuth auth = FirebaseAuth.getInstance();

        EditText email = findViewById(R.id.emailText);
        EditText contrasenia = findViewById(R.id.contraseniaText);
        TextView resultado = findViewById(R.id.textoResultado);

        String emailPasado = email.getText().toString();
        String contraseniaPasada = contrasenia.getText().toString();

        if (emailPasado.isEmpty() || contraseniaPasada.isEmpty()) {
            resultado.setText("Debes de rellenar todos los campos");
        }

        auth.signInWithEmailAndPassword(emailPasado, contraseniaPasada)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent inicio = new Intent(MainActivity.this, Inicio.class);
                            startActivity(inicio);

                        } else {
                            resultado.setText("Correo o contraseña incorrecto");
                        }
                    }
                });
    }
}
