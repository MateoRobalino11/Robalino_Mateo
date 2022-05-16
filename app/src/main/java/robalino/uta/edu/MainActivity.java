package robalino.uta.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int LAUNCH_ACTIVITY_2 = 1;
    String nombre = "",
            apellido = "",
            base = "",
            exponente = "",
            numero = "";

    private TextView text_nombre;
    private TextView text_apellido;
    private TextView text_base;
    private TextView text_exponente;
    private TextView text_factorial;
    private TextView text_potencia;
    private Button button_mostrar_resultados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_nombre = findViewById(R.id.editText_nombre);
        text_apellido = findViewById(R.id.editText_apellido);
        text_base = findViewById(R.id.editText_base);
        text_exponente = findViewById(R.id.editText_exponente);
        text_factorial = findViewById(R.id.editText_factorial);
        text_potencia = findViewById(R.id.editText_potencia);

        button_mostrar_resultados = findViewById(R.id.button_mostrar);


        if(nombre.equals(""))
            button_mostrar_resultados.setEnabled(false);

    }

    public void AbrirSegundaActivity(View view){
        Intent intent = new Intent(this, activity_tres.class);
        startActivityForResult(intent, LAUNCH_ACTIVITY_2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LAUNCH_ACTIVITY_2){
            if(resultCode == Activity.RESULT_OK){
                nombre = data.getStringExtra("nombre");
                apellido = data.getStringExtra("apellido");
                base = data.getStringExtra("base");
                exponente = data.getStringExtra("exponente");
                numero = data.getStringExtra("numero");

                if(!nombre.equals(""))
                    button_mostrar_resultados.setEnabled(true);

            }

            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }

    public int Potencia(int base, int exponente){
        return (int)Math.pow(base, exponente);
    }

    public int factorial (double numero) {
        if (numero==0)
            return 1;
        else
            return (int)(numero * factorial(numero-1));
    }

    public void MostrarResultados(View view){
        text_nombre.setText(nombre);
        text_apellido.setText(apellido);
        text_base.setText(base);
        text_exponente.setText(exponente);
        text_factorial.setText(String.valueOf(factorial(Integer.parseInt(numero))));
        text_potencia.setText(String.valueOf(Potencia(Integer.parseInt(base), Integer.parseInt(exponente))));
    }
}