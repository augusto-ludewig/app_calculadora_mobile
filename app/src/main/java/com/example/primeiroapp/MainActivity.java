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

    TextView tituloApp;
    TextView resultado;
    EditText inputPeso;
    EditText inputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Chama a classe do package R (res) - layout - arquivo xml
        Log.d("LifeCicle","onCreated");

        tituloApp = findViewById(R.id.calculadora_title);
        tituloApp.setText("Calculado");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularButtonOnClick(View v){
        Toast.makeText(MainActivity.this, "Calculando", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v("LifeCicle","onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.w("LifeCicle","onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e("LifeCicle","onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.wtf("LifeCicle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("LifeCicle","onDestroy");
    }
}