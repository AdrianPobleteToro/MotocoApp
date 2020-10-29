package com.example.motocoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Pack;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1,spin2;
    private EditText editTxt;
    private TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spnClientes);
        spin2 = (Spinner)findViewById(R.id.spnPack);
        editTxt = (EditText)findViewById(R.id.et1);
        tView = (TextView)findViewById(R.id.tv);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayAdapter<String> adapterCli = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaClientes);
        ArrayList<String> listaPacks = (ArrayList<String>) getIntent().getSerializableExtra("listaPacks");
        ArrayAdapter<String> adapterPac = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaPacks);


        spin1.setAdapter(adapterCli);
        spin2.setAdapter((adapterPac));

    }

    public void Calcular(View v){
        String cliente = spin1.getSelectedItem().toString();
        String pack = spin2.getSelectedItem().toString();
        int monto = Integer.parseInt(editTxt.getText().toString());
        if(!cliente.isEmpty()){
            Pack pk = new Pack(pack);
            if(pk.getNombrePack().equals("Pack 2"))
                pk.setPrecioPack(100000);//Le subí el precio al Pack 2
            int total = pk.getPrecioPack() - monto;
            tView.setText("El precio del pack seleccionado es: $" + pk.getPrecioPack() +"\n" +
                    "Correspondiente al " + pk.getNombrePack() + " y el monto a pagar es: $" + monto + "\n" +
                    "Por lo que la deuda final sería: $" + total);
        }
    }
}