package sp.senai.br.caulcuradoraimc;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout tela;
    EditText txtPeso, txtAltura;
    TextView txtIMC,txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tela = findViewById(R.id.tela);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtIMC = findViewById(R.id.txtIMC);
        txtResultado = findViewById(R.id.txtResultado);

    }
    public void Calcular(View v){

        float peso = Float.parseFloat(txtPeso.getText().toString());
        float altura = Float.parseFloat(txtAltura.getText().toString());

        float imc = peso/(altura*altura);

        String resultado = "";

        if(imc < 18.5){
            resultado = "Você está abaixo do peso";
            tela.setBackgroundColor(Color.rgb(255,255,0));
        }if(imc < 25){
            resultado = "Você está com peso normal";
            tela.setBackgroundColor(Color.rgb(0,255,0));
        }if(imc < 30){
            resultado = "Você está com sobrepeso";
            tela.setBackgroundColor(Color.rgb(255,255,0));
        }if(imc < 40){
            resultado = "Você está com obesidade";
            tela.setBackgroundColor(Color.rgb(255,127,0));
        }if(imc >= 40){
            resultado = "Você está com obesidade severa";
            tela.setBackgroundColor(Color.rgb(255,0,0));
        }

        txtIMC.setText("seu imc é: "+imc);
        txtResultado.setText(resultado);
    }
}