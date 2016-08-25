package com.example.david.invapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
        centro=(TextView) findViewById(R.id.tvAlmacenEntrada);
        fecha=(TextView) findViewById(R.id.tvLoteEntrada);
        Button miboton = (Button) findViewById(R.id.btLupa);
        ServerConnect server = new ServerConnect();
        miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server.descargarCentro();// hay que meterle los objetos de reciclerview
            }
        });
        final String recuento="";
        String centro="";
        String empresa="";

        resultados = new LinkedList<>();
        adaptador = new PrincipalAdapter(resultados);

        //Inicilizar el ListView
        final ListView listView = (ListView) findViewById(R.id.lvRecuentos);

        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long idView) {
                Intent i = new Intent(PrincipalActivity.this,DatosActivity.class);
                PrincipalResult principalResult = resultados.get(position);
                i.putExtra("RESULT", principalResult);
             /*   i.putExtra("centro", recuento);
                i.putExtra("fecha", fecha);
                i.putExtra("persona", almacenInicial);
                i.putExtra("persona", almacenFinal);
                i.putExtra("persona", ubicacionInicial);
                i.putExtra("persona",  ubicacionFinal);
                i.putExtra("persona", articuloInicial);
                i.putExtra("persona",  articuloFinal);*/
                startActivity(i);
            }
        });
     /*   adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            PrincipalResult result = (PrincipalResult) view.getTag();

                Intent i = new Intent(PrincipalActivity.this,DatosActivity.class);
                i.putExtra("RESULT", result);
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
        });*/



        ServerConnect miserver = new ServerConnect();
        miserver.hacerRecuento(recuento,centro,empresa);   //(recuento,empresa,centro);





    }
}
