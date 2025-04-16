package com.example.calculodosalario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText Salario;
    private RadioGroup Radiogroup;
    private Button Calcular;
    private TextView Resultado;

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

        Salario = findViewById(R.id.editTextTextSalario);
        Radiogroup = findViewById(R.id.radioGroupAumento);
        Calcular = findViewById(R.id.Calcular);
        Resultado = findViewById(R.id.textViewResultado);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSalario();
            }
        });
    }

    private void calcularSalario(){
        String salarioStr = Salario.getText().toString();

        if(salarioStr.isEmpty()){
            Toast.makeText(this, "Por Favor informe um valor", Toast.LENGTH_LONG).show();
        }

        try {
            double salario = Double.parseDouble(salarioStr);
            double percentualAumento = 0.00;
            int selectedRadioButtonId = Radiogroup.getCheckedRadioButtonId();

            if(selectedRadioButtonId == -1){
                Toast.makeText(this,"Por favor, selecione uma das opções", Toast.LENGTH_LONG).show();
            } else if(selectedRadioButtonId == R.id.radioButton40){
                percentualAumento = 0.40;
            } else if(selectedRadioButtonId == R.id.radioButton45){
                percentualAumento = 0.45;
            } else if(selectedRadioButtonId == R.id.radioButton50){
                percentualAumento = 0.50;
            }

            double novoSalario = salario * (1 + percentualAumento);

            DecimalFormat df = new DecimalFormat("#.##");
            String salarioFormatado = df.format(novoSalario);

            Resultado.setText("R$" + salarioFormatado);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Salário inválido. Use o formato correto (Ex: 1500.00).", Toast.LENGTH_SHORT).show();
        }
    }

}