package com.example.david.invapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class EntradaActivity extends AppCompatActivity {

String ubicacion;
String articulo;
String cantidad;
TextView almacenText;
TextView ubicacionText;
TextView loteText;
TextView codigoText;
TextView descripcioText;
    EditText edUbicacion;
    EditText edArticulo;
    EditText edCantidad;
    ServerConnect miserver;
   // miserver.
    String empresa;
    String centro;
    String recuento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
        //empresa recoger de bbdd
        //centro recoger de bbdd
        //recuento recoger de ApiRest retrofit
        initUI();
        setup();
        if(ubicacionText.equals(ubicacion)){
            edCantidad.setEnabled(true);

        }else{

            Intent intencion = new Intent(EntradaActivity.this,PrincipalActivity.class);
            EntradaActivity.this.startActivity(intencion);
            Bundle extras= intencion.getExtras();
            intencion.putExtra("ubicacion", (Serializable) ubicacion);
            EntradaActivity.this.finish();
            //sino se permitira entrada de recuento en pantalla
        }
        if(edArticulo.equals(articulo)){
            edCantidad.setEnabled(true);
        }else{
            //en vez de ir a principal iria a la que lee codigo de barras
            Intent intencion = new Intent(EntradaActivity.this,CodigoBarrasActivity.class);
            EntradaActivity.this.startActivity(intencion);
          /*  Bundle extras= intencion.getExtras();
            intencion.putExtra("ubicacion", (Serializable) ubicacion);*/


        }
    }
    private void initUI()
    {

        almacenText = (TextView) findViewById(R.id.tvMostrarAlmacenEntrada);
        ubicacionText = (TextView) findViewById(R.id.tvMostrarUbicacionEntrada);
        loteText = (TextView) findViewById(R.id.tvMostrarLoteEntrada);
        codigoText = (TextView) findViewById(R.id.tvCodigoEntrada);
        descripcioText=(TextView)findViewById(R.id.tvDescripcionEntrada);
        edUbicacion = (EditText) findViewById(R.id.edUbicacionEntrada);
        edArticulo = (EditText) findViewById(R.id.edArticuloEntrada);
        edCantidad = (EditText) findViewById(R.id.edCantidadEntrada);

    }
    private void setup(){

        ubicacion = edUbicacion.getText().toString();
        articulo = edArticulo.getText().toString();
        cantidad = edCantidad.getText().toString();

      //  miserver.descargaEntradaRecuento(empresa,centro,recuento);
    }
}
