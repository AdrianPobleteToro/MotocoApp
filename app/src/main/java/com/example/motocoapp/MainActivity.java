package com.example.motocoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tUsuario,tPsswrd;
    private ProgressBar progressBar;
    private Button btIngresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tUsuario = (EditText)findViewById(R.id.etUser);
        tPsswrd = (EditText)findViewById(R.id.etPwrd);
        btIngresa = (Button)findViewById(R.id.btIngresar);
        btIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!tUsuario.getText().toString().equals("usuario1") && !tPsswrd.getText().toString().equals("facilita")){
                    Toast.makeText(MainActivity.this, "Los campos son obligatorios. El usuario es: 'usuario1' y contraseña: 'facilita'", Toast.LENGTH_LONG).show();

                }else{
                new Task().execute();
                }
            }
        });

        progressBar = (ProgressBar)findViewById(R.id.pbCarga);

        progressBar.setVisibility(View.INVISIBLE); //ProgresBar Invisible / oculto.
    }

    //Crear tarea asincrona.

    class Task extends AsyncTask<String, Void, String> {

        @Override //Es la configuración inicial de la tarea.
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE); //La barra aparece.
        }

        @Override //Procesa la tarea pesada...
        protected String doInBackground(String... strings) {

            for(int i = 1; i <= 3; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);
        }
    }


    //Bota la aplicación al ejecutarse.
    public void Hilo(View v)
    {
        for(int i = 0; i <= 10; i++)
        {
            try{
                Thread.sleep((2000));

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}