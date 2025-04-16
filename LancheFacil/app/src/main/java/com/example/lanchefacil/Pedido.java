package com.example.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pedido extends AppCompatActivity {

    private Button FinalizarPedido;
    private RadioGroup Lanches;
    private RadioGroup Bebidas;
    private EditText Nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FinalizarPedido = findViewById(R.id.buttonFinalizar);
        Lanches = findViewById(R.id.lanches);
        Bebidas = findViewById(R.id.bebidas);
        Nome = findViewById(R.id.editTextTextNome);

        FinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = Nome.getText().toString();

                int selectedLancheId = Lanches.getCheckedRadioButtonId();
                int selectedBebidaId = Bebidas.getCheckedRadioButtonId();

                if (selectedLancheId != -1 && selectedBebidaId != -1) {
                    RadioButton selectedLancheRadioButton = findViewById(selectedLancheId);
                    RadioButton selectedBebidaRadioButton = findViewById(selectedBebidaId);

                    String lancheEscolhido = selectedLancheRadioButton.getText().toString();
                    String bebidaEscolhida = selectedBebidaRadioButton.getText().toString();

                    Intent intent = new Intent(Pedido.this, ResumoPedido.class);
                    intent.putExtra("lanche", lancheEscolhido);
                    intent.putExtra("bebida", bebidaEscolhida);
                    intent.putExtra("nome", nome);
                    startActivity(intent);
                }
            }
        });

    }
}