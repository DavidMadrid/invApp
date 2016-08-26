package com.example.david.invapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
           /* EntradaActivity.startActivity(intencion);
            activity.finish();*/

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
