package com.example.trabajopalabras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText edt_palabra1;
    EditText edt_palabra2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Button btn_mayor= findViewById(R.id.mayor);
        Button btn_longitud= findViewById(R.id.longitud);
        Button btn_vocales= findViewById(R.id.quitar_vocales);
        Button btn_invertir= findViewById(R.id.invertir);
        final CheckBox btn_mayuscula=findViewById(R.id.mayuscula);
         edt_palabra1 = findViewById(R.id.palabra_1);
         edt_palabra2 = findViewById(R.id.palabra_2);

         btn_mayor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            mostrar_mayor();
        };

         });

         btn_longitud.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mostrar_longitud();
             }
         });

         btn_vocales.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 quitar_vocales();
             }
         });

         btn_invertir.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 invertir_palabras();
             }
         });

         btn_mayuscula.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(btn_mayuscula.isChecked()){
                     convertir_palabras_mayusculas();
                    }else{
                     convertir_palabras_minusculas();

                 }


             }
         });
    }


    private  void mostrar_mayor(){
        String palabra1= edt_palabra1.getText().toString();
        String palabra2= edt_palabra2.getText().toString();
        if(palabra1.length()>palabra2.length()){
            mostrar_resultado("la palabra 1 es la mayor");

        }else{
            mostrar_resultado("la palabra 2 es la mayor");

        }
    }

    private void  mostrar_resultado(String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setMessage(mensaje).setTitle("Resultado");


        AlertDialog dialog = builder.create();
        dialog.show();

    }
    private void mostrar_longitud(){
        int longitud_1= edt_palabra1.length();
        int longitud_2= edt_palabra2.length();
        String mensaje ="la longitud de la palabra 1 es de "+longitud_1+"  \n la longitud de la palabra 2 es de "+longitud_2 ;
        mostrar_resultado(mensaje);
    }

    private  void quitar_vocales(){
        String palabra_1=edt_palabra1.getText().toString();
        String palabra_2=edt_palabra2.getText().toString();
        String res_palabra_1=quitar_vocales_palabra(palabra_1);
        String res_palabra_2=quitar_vocales_palabra(palabra_2);
        edt_palabra1.setText(res_palabra_1);
        edt_palabra2.setText(res_palabra_2);
        Snackbar.make( findViewById(R.id.hola), "vocales eliminadas ",Snackbar.LENGTH_SHORT).show();
    }

    private String quitar_vocales_palabra(String palabra){
        String res = "";
        for (int i = 0; i<palabra.length();i++){
            char letra =palabra.charAt(i);
            if(!es_vocal(letra)){
                res+=letra;

            }


        }
        return res ;
    }



        private  boolean es_vocal(char letra){
        switch (letra){
            case 'a':
                return true;

            case 'e':
                return true;

            case 'i':
                return true;

            case 'o':
                return true;

            case 'u':
                return true;
            case 'A':
                return true;

            case 'E':
                return true;

            case 'I':
                return true;

            case 'O':
                return true;

            case 'U':
                return true;

            default:
                return false;
        }

        }

        private void  invertir_palabras(){
            String palabra_1=edt_palabra1.getText().toString();
            String palabra_2=edt_palabra2.getText().toString();
            String palabra_1_ivt=invertir_palabra(palabra_1);
            String palabra_2_ivt=invertir_palabra(palabra_2);
            edt_palabra1.setText(palabra_1_ivt);
            edt_palabra2.setText(palabra_2_ivt);
            Snackbar.make( findViewById(R.id.hola), "palabras invertidas ",Snackbar.LENGTH_SHORT).show();


        }
        private String invertir_palabra(String palabra){
        String res = "";
        int j = palabra.length()-1;
        for (int i=0;i<palabra.length();i++){
            res+=palabra.charAt(j);
            j--;
        }
        return res;
        }

        private void convertir_palabras_mayusculas(){
            String palabra_1=edt_palabra1.getText().toString();
            String palabra_2=edt_palabra2.getText().toString();
            String palabra_1_may=pasar_palabra_mayuscula(palabra_1);
            String palabra_2_may=pasar_palabra_mayuscula(palabra_2);
            edt_palabra1.setText(palabra_1_may);
            edt_palabra2.setText(palabra_2_may);
            Toast.makeText(getBaseContext(),"mayuscula",Toast.LENGTH_SHORT).show();
        }

        private String pasar_palabra_mayuscula(String palabra){
        return palabra.toUpperCase();

        }

    private void convertir_palabras_minusculas(){
        String palabra_1=edt_palabra1.getText().toString();
        String palabra_2=edt_palabra2.getText().toString();
        String palabra_1_may=pasar_palabra_minusculas(palabra_1);
        String palabra_2_may=pasar_palabra_minusculas(palabra_2);
        edt_palabra1.setText(palabra_1_may);
        edt_palabra2.setText(palabra_2_may);
        Toast.makeText(getBaseContext(),"minuscula ",Toast.LENGTH_SHORT).show();
    }

    private String pasar_palabra_minusculas(String palabra){
        return palabra.toLowerCase();

    }
}