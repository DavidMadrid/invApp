package com.example.david.invapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.invapp.pojos.PrincipalResult;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    TextView recuento;
    TextView fecha;
    TextView centro;
    TextView empresa;
    private List<PrincipalResult> resultados;
    private PrincipalAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        recuento=(TextView) findViewById(R.id.tvRecuento);
        centro=(TextView) findViewById(R.id.tvCentro);
        fecha=(TextView) findViewById(R.id.tvFecha);
        final String recuento="";
        String centro="";
        String empresa="";

        resultados = new LinkedList<>();
        adaptador = new PrincipalAdapter(resultados);

        //Inicilizar el ListView
        final ListView listView = (ListView) findViewById(R.id.lvRecuentos);

        listView.setAdapter(adaptador);
        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this,DatosActivity.class);
                i.putExtra("recuento", recuento);
                i.putExtra("centro", recuento);
                i.putExtra("fecha", fecha);
                i.putExtra("persona", almacenInicial);
                i.putExtra("persona", almacenFinal);
                i.putExtra("persona", ubicacionInicial);
                i.putExtra("persona",  ubicacionFinal);
                i.putExtra("persona", articuloInicial);
                i.putExtra("persona",  articuloFinal);
                startActivity(i);
            }
        });



        ServerConnectPrincipal miserver = new ServerConnectPrincipal();
        miserver.hacerRecuento(recuento,centro,empresa);   //(recuento,empresa,centro);





    }
}
