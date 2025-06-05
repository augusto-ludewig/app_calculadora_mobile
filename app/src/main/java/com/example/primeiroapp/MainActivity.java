package com.example.primeiroapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        String estadoSaude;
        String aux1 = inputPeso.getText().toString();
        double peso = Double.parseDouble(aux1);
        String aux2 = inputAltura.getText().toString();
        double altura = Double.parseDouble(aux2);
        double resultImc = peso/(altura*altura);

        resultado.setText("Seu IMC é: " + String.format("%.2f", resultImc) + " kg/m2\n"
        + verificarSaude(resultImc));
    }

    public String verificarSaude(double imc){
        StringBuilder sb = new StringBuilder();
        String recomendado = "";
        sb.append("De acordo com a Organização Mundial da Saúde, seu IMC ");

        if(imc < 18.5) {
            recomendado = "está abaixo do recomendado para a sua altura.";
            sb.append(recomendado);
            sb.append("Para manter o valor de IMC normal, seu ");
            sb.append("peso pode variar entre 59.9 e 80.7 kg.");
            return sb.toString();
        } else if (imc >= 18.5 && imc <= 24.9){
            recomendado = "é considerado normal para a sua altura. ";
            sb.append(recomendado);
            sb.append("Para manter o valor de IMC normal, seu ");
            sb.append("peso pode variar entre 59.9 e 80.7 kg.");
            return sb.toString();
        } else {
            recomendado = "está acima do recomendado para a sua altura. ";
            sb.append(recomendado);
            sb.append("Para manter o valor de IMC normal, seu ");
            sb.append("peso pode variar entre 59.9 e 80.7 kg.");
            return sb.toString();
        }
    }

}