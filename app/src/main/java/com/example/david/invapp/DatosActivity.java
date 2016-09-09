package com.example.david.invapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.david.invapp.pojos.pojoPrincipal.Recuento;

public class DatosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TextView centro = (TextView) findViewById(R.id.tvMostrarCentro);
        TextView recuento =(TextView) findViewById(R.id.tvMostrarUbicacionEntrada);
        TextView fecha =(TextView) findViewById(R.id.tvMostrarLoteEntrada);
        TextView AlmacenInicial = (TextView) findViewById(R.id.tvAlmacenMostrarI);
        TextView AlmacenFinal =  (TextView) findViewById(R.id.tvMostrarAlmacenF);
        TextView UbicacionInicial =(TextView) findViewById(R.id.tvUbicacionMostrarI);
        TextView UbicacionFinal =(TextView) findViewById(R.id.tvMostrarUbicacionF);
        TextView ArticuloIncial = (TextView) findViewById(R.id.tvArticuloMostrarI);
        TextView ArticuloFinal = (TextView) findViewById(R.id.tvMostrarArticuloF);

        //String parametro = getIntent().getStringExtra("parametro");

        Recuento result = (Recuento) getIntent().getSerializableExtra("RESULT");
                //recoger los valores y setearlos a cada uno de los parametros
              centro.setText(result.getCentro());
              recuento.setText(result.getRecuento());
              fecha.setText(result.getFecha());
              AlmacenInicial.setText(result.getAlmacenInicial());
              AlmacenFinal.setText(result.getAlmacenFinal());
              UbicacionInicial.setText(result.getUbicacionInicial());
              UbicacionFinal.setText(result.getUbicacionFinal());
              UbicacionInicial.setText(result.getUbicacionInicial());
              UbicacionFinal.setText(result.getUbicacionFinal());
              ArticuloIncial.setText(result.getProductoInicial());
              ArticuloFinal.setText(result.getProductoFinal());
    }
}
