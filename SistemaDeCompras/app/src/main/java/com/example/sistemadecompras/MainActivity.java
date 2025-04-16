package com.example.sistemadecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.text.DecimalFormat;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox Carne;
    private CheckBox Leite;
    private CheckBox Feijao;
    private CheckBox Refrigerante;
    private CheckBox Arroz;
    private TextView Teste;
    private Button Total;

    private double precoArroz = 2.69;
    private double precoLeite = 2.70;
    private double precoCarne = 16.70;
    private double precoFeijao = 3.38;
    private double precoRefri = 3.00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Carne = findViewById(R.id.cbCarne);
        Leite = findViewById(R.id.cbLeite);
        Feijao = findViewById(R.id.cbFeijao);
        Refrigerante = findViewById(R.id.cbRefrigerante);
        Arroz = findViewById(R.id.cbArroz);

        Teste = findViewById(R.id.test);

        Total = findViewById(R.id.total);

        Total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });

    }

    private void calcularTotal(){
        double total = 0;

        if(Arroz.isChecked()){
            total += precoArroz;
        }

        if(Carne.isChecked()){
            total += precoCarne;
        }

        if(Leite.isChecked()){
            total += precoLeite;
        }

        if(Feijao.isChecked()){
            total += precoFeijao;
        }

        if(Refrigerante.isChecked()){
            total += precoRefri;
        }


        DecimalFormat df2 = new DecimalFormat("#.##");
        String totalFormatado = df2.format(total);
        Teste.setText("Total: " + "R$" + totalFormatado);
    }


}