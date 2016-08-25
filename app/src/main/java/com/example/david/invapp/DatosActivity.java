package com.example.david.invapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.david.invapp.pojos.PrincipalResult;

public class DatosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TextView centro = (TextView) findViewById(R.id.tvAlmacenEntrada);
        TextView recuento =(TextView) findViewById(R.id.tvRecuento);
        TextView fecha =(TextView) findViewById(R.id.tvLoteEntrada);
        TextView AlmacenInicial = (TextView) findViewById(R.id.tvAlmacenInicial);
        TextView AlmacenFinal =  (TextView) findViewById(R.id.tvAlmacenFinal);
        TextView UbicacionInicial =(TextView) findViewById(R.id.tvUbicacionInicial);
        TextView UbicacionFinal =(TextView) findViewById(R.id.tvUbicacionFinal);
        TextView ArticuloIncial = (TextView) findViewById(R.id.tvArticuloInicial);
        TextView ArticuloFinal = (TextView) findViewById(R.id.tvArticuloFinal);
        PrincipalResult principal = new PrincipalResult();

        //String parametro = getIntent().getStringExtra("parametro");

        PrincipalResult result = (PrincipalResult) getIntent().getSerializableExtra("RESULT");
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
