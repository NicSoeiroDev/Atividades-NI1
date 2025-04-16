package com.example.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaFormulario extends AppCompatActivity {

    private Button Finalizar;
    private EditText Nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_formulario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        Finalizar = findViewById(R.id.buttonFinalizar);

        Nome = findViewById(R.id.editTextTextNome);

        Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = Nome.getText().toString();


                Intent intent = new Intent(TelaFormulario.this, BoasVindas.class);
                intent.putExtra("Nome",nome);
                startActivity(intent);


            }
        });
    }
}