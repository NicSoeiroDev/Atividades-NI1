package com.example.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BoasVindas extends AppCompatActivity {

    private TextView Mensagem;
    private Button Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_boas_vindas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Mensagem = findViewById(R.id.textViewMensagem);
        Voltar = findViewById(R.id.buttonVoltar);

        Intent intent = getIntent();

        if(intent.hasExtra("Nome")){
            String Nome = intent.getStringExtra("Nome");
            //Log.d("BoasVindas", "Nome: " + Nome);
            Mensagem.setText("Bem Vindo(a) " + Nome + " a nossa loja, estaremos a sua disposição ;)");
        } else {
            Mensagem.setText("Erro ao obter seu nome");
            //Log.e("BoasVindas", "Erro: Extra 'imc_resultado' não encontrado no Intent.");
        }

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoasVindas.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}