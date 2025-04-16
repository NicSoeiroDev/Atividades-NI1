package com.example.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedido extends AppCompatActivity {

    private TextView Lanche;
    private TextView Bebida;
    private TextView Mensagem;
    private Button Confirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Lanche  = findViewById(R.id.textViewLanche);
        Bebida = findViewById(R.id.textViewBebida);
        Mensagem = findViewById(R.id.textViewConfimacao);
        Confirmacao = findViewById(R.id.buttonConfirmar);

        Intent intent = getIntent();

        if (intent != null) {
            String lanche = intent.getStringExtra("lanche");
            String bebida = intent.getStringExtra("bebida");
            String nome = intent.getStringExtra("nome");

            if (lanche != null) {
                Lanche.setText("Lanche: " + lanche);
            } else {
                Lanche.setText("Lanche: Não selecionado");
            }

            if (bebida != null) {
                Bebida.setText("Bebida: " + bebida);
            } else {
                Bebida.setText("Bebida: Não selecionada");
            }
            if (nome != null) {
                Mensagem.setText("Tudo nos conformes " + nome + "?");
            }
        } else {
            Lanche.setText("Erro ao receber informações do pedido.");
            Bebida.setText("");
        }

        Confirmacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPedido.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}