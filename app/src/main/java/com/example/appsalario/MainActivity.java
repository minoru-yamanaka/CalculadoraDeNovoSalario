package com.example.appsalario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    // Declaração de variáveis para os elementos da interface do usuário
    RadioGroup rgopcoes;
    Button btcalcular;
    EditText edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos elementos da interface do usuário
        edsalario = findViewById(R.id.edsalario);
        rgopcoes = findViewById(R.id.rgopcoes);
        btcalcular = findViewById(R.id.btcalcular);

        // Configuração do botão para ouvir o clique
        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Variável para armazenar o salário digitado pelo usuário
                double salario;

                try {
                    // Tentativa de converter o texto do EditText para um valor double
                    salario = Double.parseDouble(edsalario.getText().toString());
                } catch (NumberFormatException e) {
                    // Tratamento de exceção se a conversão falhar (quando o texto não é um número)
                    edsalario.setError("Digite um valor válido");
                    return;
                }

                // Identificação do RadioButton selecionado
                int op = rgopcoes.getCheckedRadioButtonId();

                // Variável para armazenar o novo salário calculado
                double novo_salario = 0;

                // Lógica condicional para calcular o novo salário com base na escolha do RadioButton
                if (op == R.id.rb40) {
                    novo_salario = salario + (salario * 0.4);
                } else if (op == R.id.rb45) {
                    novo_salario = salario + (salario * 0.45);
                } else if (op == R.id.rb50) {
                    novo_salario = salario + (salario * 0.50);
                }

                // Criação e exibição de um AlertDialog com o novo salário calculado
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Novo Salário");
                dialogo.setMessage("Seu novo salário é: R$ " + String.valueOf(novo_salario));
                dialogo.setNegativeButton("OK", null);
                dialogo.show();
            }
        });
    }
}
