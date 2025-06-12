package com.example.primeiroapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView appTitle;
    TextView resultado;
    EditText inputPeso;
    EditText inputAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Chama a classe do package R (res) - layout - arquivo xml
        Log.d("LifeCicle","onCreated");

        appTitle = findViewById(R.id.appName);
        resultado = findViewById(R.id.resultado);
        inputPeso = findViewById(R.id.peso);
        inputAltura = findViewById(R.id.altura);
    }

    public void calcularButtonOnClick(View v) {
        String aux1 = inputPeso.getText().toString();
        double peso = Double.parseDouble(aux1);
        String aux2 = inputAltura.getText().toString();
        double altura = Double.parseDouble(aux2);
        double resultImc = peso/(altura*altura);

        resultado.setText("Seu IMC é: " + String.format("%.2f", resultImc) + " kg/m2\n"
        + verificarSaude(resultImc, altura));
    }

    public String verificarSaude(double imc, double altura){
        StringBuilder sb = new StringBuilder();
        String pesoMaxMin = calcularPesoMaxMin(altura);
        sb.append("De acordo com a Organização Mundial da Saúde, seu IMC ");
        if(imc < 18.5) {
            sb.append("está abaixo do recomendado para a sua altura.");
            sb.append("Para manter o valor de IMC normal, seu ");
            sb.append("peso pode variar entre ");
            sb.append(pesoMaxMin);
            return sb.toString();
        } else if (imc >= 18.5 && imc <= 24.9){
            sb.append("é considerado normal para a sua altura. ");
            sb.append("Para manter o valor de IMC normal, seu ");
            sb.append("peso pode variar entre ");
            sb.append(pesoMaxMin);
            return sb.toString();
        } else {
            sb.append("está acima do recomendado para a sua altura. ");
            sb.append("Para manter o valor de IMC normal, seu ");
            sb.append("peso pode variar entre ");
            sb.append(pesoMaxMin);
            return sb.toString();
        }
    }

    // Calcula o peso mínimo e máximo ideal de acordo com a altura da pessoa
    public String calcularPesoMaxMin(double altura) {
        double pesoMin = 18.5 * altura * altura;
        double pesoMax = 24.9 * altura * altura;
        return String.format("peso pode variar entre %.2f e %.2f Kg.", pesoMin, pesoMax);
    }

    public void goToSecondEmptyActivityButtonOnClick(View v){
        Intent view = new Intent(MainActivity.this, SecondMainActivity.class);
        startActivity(view);
    }

}