package com.example.motocoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private int[] images = {R.drawable.cascos,R.drawable.guantes,R.drawable.chaquetas,R.drawable.alforjas};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        viewFlipper = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }
    public void flip_image(int i)
    {
        //Cargando las imágenes en imageview
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);


        //configurando viewflipper
        viewFlipper.addView(view); //se le añade las imágenes
        viewFlipper.setAutoStart(true); //Inicia de forma automática
        viewFlipper.setFlipInterval(2500); //Intervalo que se cambian las imágenes

        //sentido del slider.
        viewFlipper.setInAnimation(this , android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
    public void Info(View v)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }

    public void Maps(View v)
    {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }

    public void Clientes(View v){

        ArrayList<String> clientes = new ArrayList<String>();
        clientes.add("Luzmar");
        clientes.add("Adrián");
        ArrayList<String> packs = new ArrayList<String>();
        packs.add("Pack1 - (Casco + Chaqueta)");
        packs.add("Pack2 - (Guantes + Alforjas)");

        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("listaClientes",clientes);
        i.putExtra("listaPacks",packs);
        startActivity(i);
    }

    public void Insumos(View v){
        Intent i = new Intent(this, Insumos_act.class);
        startActivity(i);
    }
}