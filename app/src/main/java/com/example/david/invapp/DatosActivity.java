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

        TextView centro = (TextView) findViewById(R.id.tvCentro);
        TextView recuento =(TextView) findViewById(R.id.tvRecuento);
        TextView fecha =(TextView) findViewById(R.id.tvFecha);
        TextView AlmacenInicial = (TextView) findViewById(R.id.tvAlmacenInicial);
        TextView AlmacenFinal =  (TextView) findViewById(R.id.tvAlmacenFinal);
        TextView UbicacionInicial =(TextView) findViewById(R.id.tvUbicacionInicial);
        TextView UbicacionFinal =(TextView) findViewById(R.id.tvUbicacionFinal);
        TextView ArticuloIncial = (TextView) findViewById(R.id.tvArticuloInicial);
        TextView ArticuloFinal = (TextView) findViewById(R.id.tvArticuloFinal);
        PrincipalResult principal = new PrincipalResult();

        //String parametro = getIntent().getStringExtra("parametro");

        PrincipalResult result = (PrincipalResult) getIntent().getSerializableExtra("persona");

    }
}
