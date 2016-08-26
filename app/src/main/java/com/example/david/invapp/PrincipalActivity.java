package com.example.david.invapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.invapp.pojos.Delegacione;
import com.example.david.invapp.pojos.PrincipalResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    //recuento obtenido de bbdd
    String recuento;
    String fecha;
    String centro;
    String empresa;
    private List<PrincipalResult> resultados;
    //  private PrincipalAdapter adaptador;
    private RecyclerView principalRecuentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
      /* recuento= String.valueOf(findViewById(R.id.tvRecuento));// se llenan con la bbdd
        centro= String.valueOf(findViewById(R.id.tvAlmacenEntrada));
        fecha= String.valueOf(findViewById(R.id.tvLoteEntrada));*/
        //  List<PrincipalResult>resultados = new ArrayList<>();
        // PrincipalAdapter principalAdapter= new PrincipalAdapter(resultados);
        //recoger el recuento de entradaactivity  y mostrar en el list
        PrincipalResult ubicacion = (PrincipalResult)getIntent().getSerializableExtra("ubicacion");
        String articulo = getIntent().getStringExtra("articulo");
       resultados.add(ubicacion);
        principalRecuentos = (RecyclerView) findViewById(R.id.recyclerView);
        principalRecuentos.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        resultados = new ArrayList<>();
        PrincipalAdapter2 adapter2 = new PrincipalAdapter2(resultados);
        principalRecuentos.setAdapter(adapter2);
        Button miboton = (Button) findViewById(R.id.btLupa);
        final ServerConnect server = new ServerConnect();
        server.listaPrincipalRecuento(recuento /*obtenido restadapter retrofit*/);//para cargar la lista entera
        adapter2.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrincipalResult principal = (PrincipalResult) view.getTag();
                Intent i = new Intent(PrincipalActivity.this, DatosActivity.class);
                i.putExtra("DELEGACION", principal);
                startActivity(i);
            }
        });

        miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    hay que meterle los objetos de reciclerview
                // abria que pasarle el recuento pero solo de los item que coincidan por el recuento tecleado
                if (recuento == recuento/*recuento obtenido de restAdapter retrofit*/) {
                    principalRecuentos = (RecyclerView) findViewById(R.id.recyclerView);
                    principalRecuentos.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    resultados = new ArrayList<>();
                    PrincipalAdapter2 adapter2 = new PrincipalAdapter2(resultados);
                    principalRecuentos.setAdapter(adapter2);
                    server.listaPrincipalRecuento(recuento);
                }//else { seguiria la lista entera de arriba

                // posteriormente si pulsamos el item /tag nos haria igual que arriba una intencion a datos
                // // creo que con intent meterle
                PrincipalAdapter2 adapter2 = new PrincipalAdapter2(resultados);
                principalRecuentos.setAdapter(adapter2);
                adapter2.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PrincipalResult principal = (PrincipalResult) view.getTag();
                        Intent i = new Intent(PrincipalActivity.this, DatosActivity.class);
                        i.putExtra("DELEGACION", principal);
                        startActivity(i);
                    }
                });

            }
        });

        final String recuento = "";
        String centro = "";
        String empresa = "";
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
        //  resultados = new LinkedList<>();
        // adaptador = new PrincipalAdapter(resultados);

        //Inicilizar el ListView
        // final ListView listView = (ListView) findViewById(R.id.lvRecuentos);

       /* listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // listview sin recicler
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
                i.putExtra("persona",  articuloFinal);
                startActivity(i);
            }
        });
        adaptador.setOnItemClickListener(new View.OnClickListener() {// onclicklistener personalizado
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



    /*    ServerConnect miserver = new ServerConnect();
        miserver.hacerRecuento(recuento,centro,empresa);   //(recuento,empresa,centro);*/


    }
}
