package com.example.motocoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Insumos_act extends AppCompatActivity {

    private EditText cod, nom,precio,stock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        cod = (EditText)findViewById(R.id.etCod);
        nom = (EditText)findViewById(R.id.etNom);
        precio = (EditText)findViewById(R.id.etPrecio);
        stock = (EditText)findViewById(R.id.etStock);
    }

    public void AgregarInsumo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();//Permite la sobrescritura en la base de datos.

        String codigo = cod.getText().toString();
        if(!codigo.isEmpty()){
            ContentValues content = new ContentValues();
            content.put("codigo",cod.getText().toString());
            content.put("nombre",nom.getText().toString());
            content.put("precio",precio.getText().toString());
            content.put("stock",stock.getText().toString());
            db.insert("insumos",null,content);
            db.close();
            Toast.makeText(this,"Has guardado un insumo",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Debe ingresar un código", Toast.LENGTH_LONG).show();
        }
    }

    public void MostrarInsumo(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = cod.getText().toString();

        if(!codigo.isEmpty()){
            //Cursor para recorrer la tabla buscando el valor indicado (codigo)
            Cursor fila = db.rawQuery("SELECT nombre, precio, stock FROM insumos WHERE codigo = "+codigo,null);
            if(fila.moveToFirst()){
                nom.setText(fila.getString(0));
                precio.setText(fila.getString(1));
                stock.setText(fila.getString(2));
            }
            else{
                Toast.makeText(this,"No hay campos asociados al código",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"No hay campos en la entidad insumos", Toast.LENGTH_LONG).show();
        }
    }

    public void EliminarInsumo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = cod.getText().toString();

        if(!codigo.isEmpty()){
            db.delete("insumos","codigo="+codigo,null);
            db.close();
            Toast.makeText(this,"Has eliminado un insumo.",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No se especificó un código válido.",Toast.LENGTH_LONG).show();
        }
    }

    public void ActualizarInsumo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = cod.getText().toString();
        ContentValues content = new ContentValues();
        content.put("codigo",codigo);
        content.put("nombre",nom.getText().toString());
        content.put("precio",precio.getText().toString());
        content.put("stock",stock.getText().toString());
        if(!codigo.isEmpty()){
            db.update("insumos",content,"codigo="+codigo, null);
            db.close();
            Toast.makeText(this,"Has actualizado un insumo.",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No se especificó un código válido.",Toast.LENGTH_LONG).show();
        }
    }
}